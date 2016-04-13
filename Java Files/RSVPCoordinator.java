import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class RSVPCoordinator {
	// Instantiation of HotelSystem
	private static HotelSystem hs = new HotelSystem();

	private static int month = 1;
	private static int day = 1;
	private static int year = 2016;
	private static Date date = new Date(month, day, year);

	// Generate 5 single rooms and 5 double rooms
	private static List<Room> singleRooms = new ArrayList<Room>();
	private static List<Room> doubleRooms = new ArrayList<Room>();


	// Credit Cards doesn't have CCV in their inputs so we generated one.
	private static int CCV = 123;

	// Print date
	private static boolean printDate = true;

	public static void main(String[] args) {
		// Create rooms
		for (int i = 0; i < 5; i++)
			singleRooms.add(hs.addRoom(100 + i, false, 150));

		for (int i = 5; i < 10; i++)
			doubleRooms.add(hs.addRoom(100 + i, true, 180));


		try
		{
			Framework.init(args[0]);
		}
		catch(Exception e)
		{
			print("File not found. Please make sure you typed the file name correctly.");
		}
		while (Framework.hasNextInstruction())
		{
			String [] instructions = Framework.nextInstruction();
			executeInstructions(instructions);

			// Displays all the instructions
			//for (int i = 0; i < instructions.length; i++)
			//	print(instructions[i]);
		}
	}

	public static void executeInstructions(String[] instr)
	{
		if(printDate)
		{
			print(("==================" + date.toString()) + "==================");
			print("");
			printDate = false;
		}

		// Type of instruction
		int type = Integer.parseInt(instr[0]);
		Reservation rsvp;
		User usr;
		Room rm;
		switch(type)
		{
		case 1:	// Make a Reservation
			if (!(instr.length == 11 || instr.length == 8))
			{
				print("Make Reservation needs to have atleast 11 lines of code including the instruction type for guaranteed and 8 lines for non-guaranteed");
				break;
			}

			// Parse the Address
			List<String> addr = Arrays.asList(instr[2].split(", "));

			// Check if the user is already in the database or not.
			if (hs.getUserByName(instr[1]) != null)
				usr = hs.getUser(instr[1]);
			else
				usr = hs.addUser(instr[1].toLowerCase().replaceAll("[^a-z0-9]", ""), instr[1].replaceAll("\\s+",""), instr[1], 0, addr.get(0), "", addr.get(1), addr.get(2).substring(0, 2), Integer.parseInt(addr.get(2).substring(3, 8)));

			// Is it Guaranteed?
			boolean guaranteed = instr[7].equals("1") ? true : false;

			// New Reservation generated
			int idx = 0;
			do {
				// Select room
				if (instr[5].equals("2"))
					rm = doubleRooms.get(idx);
				else
					rm = singleRooms.get(idx);
				rsvp = hs.addReservation(usr, rm, Integer.parseInt(instr[6]), guaranteed, date.getMonth(), Integer.parseInt(instr[3]), date.getYear(), Integer.parseInt(instr[4]) - Integer.parseInt(instr[3]));
				idx++;
			} while (rsvp == null && (idx < singleRooms.size() && idx < doubleRooms.size()));
			if(rsvp == null)	// If it still null it means then there is no room left.
			{
				print("All " + (instr[5].equals("2") ? "double" : "single") + " rooms are fully booked. We can't proceed with the making of reservation using a " + (instr[5].equals("2") ? "double" : "single") + " room.");
				break;
			}

			if (guaranteed)
			{
				// Credit Card to be added under the User
				hs.addCreditCard(usr, usr.getFullName(), instr[8], instr[10], CCV, Integer.parseInt(instr[9].substring(0, instr[9].indexOf('/'))), Integer.parseInt(instr[9].substring(instr[9].indexOf('/')+1, instr[9].length())), usr.getAddress1(), usr.getAddress2(), usr.getCity(), usr.getState(), usr.getZip());

				// Charge User the total balance of the reservation using the credit card provided above
				hs.chargeUser(rsvp);
			}

			print("Make Reservation request for " + rsvp.getReservedTo().getFullName());
			print("Reservation: " + (rsvp != null ? "Success" : "Failed"));
			print("Guaranteed: " + (rsvp.isGuaranteed() ? "True" : "False"));
			print("CheckIn: " + rsvp.getDates().get(0));
			print("CheckOut: " + rsvp.getDates().get(rsvp.getDates().size()-1));

			break;

		case 2:	// Check In
			if (!(instr.length == 5 || instr.length == 2))
			{
				print("Check-in needs to have atleast 5 lines of code including the instruction type for non-guaranteed and 2 lines for guaranteed.");
				break;
			}

			usr = hs.getUserByName(instr[1]);
			if (usr == null)
			{
				print("User is not found in the database. Can't check in " + instr[1]);
				break;
			}
			rsvp = hs.getReservationByCID(usr.getUserID());
			if (rsvp == null)
			{
				print("Reservation is not found in the database. Can't check in " + instr[1]);
				break;
			}
			CheckIn checkedIn = null;
			if (rsvp.isGuaranteed() && rsvp.getBalance() == 0 && date.isBefore(rsvp.getDates().get(0)))
				checkedIn = hs.checkInReservation(rsvp);
			else if (!rsvp.isGuaranteed() && date.isBefore(rsvp.getDates().get(0)))
			{
				// Credit Card to be added under the User
				hs.addCreditCard(usr, usr.getFullName(), instr[2], instr[4], CCV, Integer.parseInt(instr[3].substring(0, instr[3].indexOf('/'))), Integer.parseInt(instr[3].substring(instr[3].indexOf('/')+1, instr[3].length())), usr.getAddress1(), usr.getAddress2(), usr.getCity(), usr.getState(), usr.getZip());
				checkedIn = hs.checkInReservation(rsvp);
			}
			print(checkedIn != null ? checkedIn.toString() : ("Failed checking in " + instr[1] + ". Check-in date supposed to be " + rsvp.getDates().get(0) + "."));
			break;

		case 3:	// Check Out
			if (instr.length != 2)
			{
				print("Check-out needs to have atleast 2 lines of code including the instruction type");
				break;
			}

			usr = hs.getUserByName(instr[1]);
			rsvp = hs.getReservationByCID(usr.getUserID());
			hs.checkOutReservation(rsvp);
			break;

		case 4:	// Print Management Report
			if (!(instr.length == 2 || instr.length == 1))
			{
				print("Management Report needs to have atleast 2 lines of code including the instruction type");
				break;
			}
			if (instr.length == 1)
				print(hs.generateReportAll());
			else
				print(hs.generateReportByRange(new Date(date.getMonth(), Integer.parseInt(instr[1]), year), new Date(date.getMonth(), Integer.parseInt(instr[1])+1, year)).toString(new Date(date.getMonth(), Integer.parseInt(instr[1]), year)));
			break;

		case 5: // Day Change
			if (instr.length != 1)
			{
				print("Day change needs to have atleast 1 lines of code including the instruction type");
				break;
			}

			if (date.getDay() == date.maxDayInMonth(date.getMonth(), date.getYear())) {
				date.setMonth(date.getMonth()+1);
				date.setDay(1);
			}
			else
				date.setDay(date.getDay()+1);

			// Check all those reservations who are booked but didn't show up
			for (int i = 0; i < hs.getDB().getListOfReservations().size(); i++)
				if (hs.getDB().getListOfReservations().get(i).getDates().get(0).isBefore(date) && !hs.getDB().getListOfReservations().get(i).isNoShow())
				{
					hs.getDB().getListOfReservations().get(i).setNoShow(true);
					print(hs.getDB().getListOfReservations().get(i).getReservedTo().getFullName() + " did not show.");
				}
			printDate = true;
			break;

		case 6: // 6 PM alarm
			if (instr.length != 1)
			{
				print("6PM Signal needs to have atleast 1 lines of code including the instruction type");
				break;
			}

			hs.trigger6PM();
			break;
		default:
			print("No instruction found. Make sure you put it the correct instruction type.");
			break;
		}
		print("");
	}

	public static void print(Object o)
	{
		System.out.println(o.toString());
	}

}
