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
			print("---------------------------- Date ------------------------------");
			printDate();
			print("----------------------------------------------------------------");
			String [] instructions = Framework.nextInstruction();
			executeInstructions(instructions);

			// Displays all the instructions
			print("------------------------- Instruction --------------------------");
			for (int i = 0; i < instructions.length; i++)
				print(instructions[i]);
			print("----------------------------------------------------------------");
		}
	}

	public static void executeInstructions(String[] instr)
	{
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

			// Check if the user is already in the database or not.
			if (hs.getUserByName(instr[1]) != null)
				usr = hs.getUser(instr[1]);
			else
				usr = hs.addUser(instr[1].toLowerCase().replaceAll("[^a-z0-9]", ""), instr[1].replaceAll("\\s+",""), instr[1], 0);
			// Print the current User info
			print(usr.toString());

			// Is it Guaranteed?
			boolean guaranteed = instr[7].equals("1") ? true : false;
			
			// Select room
			if (instr[5].equals("2"))
				//rm = double
			else
				//rm = single
			// New Reservation generated
			rsvp = hs.addReservation(usr, rm, Integer.parseInt(instr[6]), guaranteed, date.getMonth(), Integer.parseInt(instr[3]), date.getYear(), Integer.parseInt(instr[4]) - Integer.parseInt(instr[3]));
			print(rsvp.toString());

			if (guaranteed)
			{
				// Parse the Address
				List<String> addr = Arrays.asList(instr[2].split(", "));
				// Credit Card to be added under the User
				CreditCard cc = hs.addCreditCard(usr, usr.getFullName(), instr[8], instr[10], CCV, Integer.parseInt(instr[9].substring(0, instr[9].indexOf('/'))), Integer.parseInt(instr[9].substring(instr[9].indexOf('/')+1, instr[9].length())), addr.get(0), "", addr.get(1), addr.get(2).substring(0, 2), Integer.parseInt(addr.get(2).substring(3, 8)));

				// Charge User the total balance of the reservation using the credit card provided above
				print(hs.chargeUser(rsvp) ? "Successfully charged the customer for a new reservation":"Charge failed. Could be an invalid card");
				print("");
				print(cc.toString());
			}
			break;

		case 2:	// Check In
			if (instr.length != 5)
			{
				print("Check-in needs to have atleast 5 lines of code including the instruction type");
				break;
			}

			usr = hs.getUserByName(instr[1]);
			rsvp = hs.getReservationByCID(usr.getUserID());
			print(hs.checkInReservation(rsvp));
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
			if (instr.length != 2)
			{
				print("Management Report needs to have atleast 2 lines of code including the instruction type");
				break;
			}
			print(hs.generateReportByRange(new Date(date.getMonth(), Integer.parseInt(instr[1]), year), new Date(date.getMonth(), Integer.parseInt(instr[1])+1, year)));
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

		}
	}

	public static void print(Object o)
	{
		System.out.println(o.toString());
	}
	
	public static void printDate()
	{
		System.out.println("CURRENT DATE: " + date.toString());
	}

}
