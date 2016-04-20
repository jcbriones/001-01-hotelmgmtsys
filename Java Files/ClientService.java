/**
 * RSVPCoordinator.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the Coordinator class that responds an output to an input from a file.
 * The class from which users will be able to add themselves to the system and login to the system.
 * You can also check in and check out users from the system using this class
 * The management report is printed from this as well in addition to changing the day and managing
 * the 6PM signal
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class RSVPCoordinator {
	/**
	 * Class Variables
	 */
	// Instantiation of HotelSystem
	private static HotelSystem hs = new HotelSystem();

	// Starting month is 1 (January)
	private static int month = 1;
	// Starting day is 1
	private static int day = 1;
	// Starting year is 2016
	private static int year = 2016;
	// Get the date from the Date class
	private static Date date = hs.getCurrentDate();

	// List for singleRooms and doubleRooms
	private static List<Room> singleRooms = new ArrayList<Room>();
	private static List<Room> doubleRooms = new ArrayList<Room>();

	// Credit Cards doesn't have CCV in their inputs so we generated one.
	private static int CCV = 123;

	// Print date
	private static boolean printDate = true;

	/**
	 * Description: Where the entire HotelSystem takes inputs and prints them from.
	 * 
	 * @param args
	 * @author Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
	 */
	public static void main(String[] args) {
		// Initialize the date.
		date.setMonth(month);
		date.setDay(day);
		date.setYear(year);
		// Create rooms of 5 each
		for (int i = 0; i < 5; i++)
			singleRooms.add(hs.addRoom(100 + i, false, 80));

		for (int i = 5; i < 10; i++)
			doubleRooms.add(hs.addRoom(100 + i, true, 160));


		try
		{
			// Reading in an input file
			Framework.init(args[0]);
		}
		catch(Exception e)
		{
			// Throws an exception if the file was not found or could not be read in
			print("File not found. Please make sure you typed the file name correctly.");
		}
		while (Framework.hasNextInstruction())
		{
			String [] instructions = Framework.nextInstruction();
			try
			{
				//executeInstructions(instructions);
				for (int i = 0; i < instructions.length; i++)

					print(instructions[i]);
			}
			catch(Exception e)
			{
				print("Something was wrong inside your text file. Please check again. Common errors are in addresses. Should be 'Address, City, ST 12345'");
			}

			// Displays all the instructions
			//for (int i = 0; i < instructions.length; i++)
			//	print(instructions[i]);
		}
	}

	/**
	 * Description: Main function that runs in a loop in the main method of RSVPCoordinator. This is the code
	 * that enables user input at the console screen.
	 * 
	 * @param instr
	 * @author Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
	 */
	public static void executeInstructions(String[] instr)
	{
		// Prints the date out to the User
		if(printDate)
		{
			print(("==================" + date.toString()) + "==================");
			print("");
			printDate = false;
		}

		// Type of instruction
		// Allows the user to select the type of input.
		// Case 1 is to Make a Reservation
		// Case 2 is to Check In
		// Case 3 is to Check Out
		// Case 4 is to Print Management Report
		// Case 5 is to change the day
		// Case 6 is the 6 PM alarm
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
				print("All " + (instr[5].equals("2") ? "double" : "single") + " rooms are fully booked. We can't proceed with the making of reservation using a " + (instr[5].equals("2") ? "double" : "single") + " room.");


			if (guaranteed && rsvp != null)
			{
				// Credit Card to be added under the User
				hs.addCreditCard(usr, usr.getFullName(), instr[8], instr[10], CCV, Integer.parseInt(instr[9].substring(0, instr[9].indexOf('/'))), Integer.parseInt(instr[9].substring(instr[9].indexOf('/')+1, instr[9].length())), usr.getAddress1(), usr.getAddress2(), usr.getCity(), usr.getState(), usr.getZip());

				// Charge User the total balance of the reservation using the credit card provided above
				hs.chargeUser(rsvp);
			}

			print("Make Reservation request for " + instr[1]);
			print("Reservation: " + (rsvp != null ? "Success" : "Failed"));
			print("Guaranteed: " + (instr[7].equals("1") ? "True" : "False"));
			print("Check In: " + new Date(date.getMonth(), Integer.parseInt(instr[3]), date.getYear()));
			print("Check Out: " + new Date(date.getMonth(), Integer.parseInt(instr[4]), date.getYear()));

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
				print("User is not found in the database. " + instr[1] + " was not successfully checked in.");
				break;
			}
			rsvp = hs.getReservationByCID(usr.getUserID());
			if (rsvp == null)
			{
				print("Reservation is not found in the database. " + instr[1] + " was not successfully checked in.");
				break;
			}
			CheckIn checkedIn = null;
			if (rsvp.isGuaranteed())
				checkedIn = hs.checkInReservation(rsvp,date);
			else if (!rsvp.isGuaranteed() && date.equals(rsvp.getDates().get(0)))
			{
				// Credit Card to be added under the User
				hs.addCreditCard(usr, usr.getFullName(), instr[2], instr[4], CCV, Integer.parseInt(instr[3].substring(0, instr[3].indexOf('/'))), Integer.parseInt(instr[3].substring(instr[3].indexOf('/')+1, instr[3].length())), usr.getAddress1(), usr.getAddress2(), usr.getCity(), usr.getState(), usr.getZip());

				// Charge User the total balance of the reservation using the credit card provided above
				hs.chargeUser(rsvp);
				checkedIn = hs.checkInReservation(rsvp,date);
			}
			if (checkedIn != null)
			{
				print(instr[1] + " was successfully checked in.");
				print("");
				print("Check In Statement:");
				print("Customer Name: " + rsvp.getReservedTo().getFullName());
				print("Nights reserved: " + rsvp.getNumberOfNights());
				System.out.printf("Nightly rate: $%.2f\n", rsvp.getRoomCost());
				print("Check In: " + rsvp.getDates().get(0).toString());
				print("Check Out: " + rsvp.getDates().get(rsvp.getDates().size()-1).toString());
			}
			else
				print(instr[1] + " was not successfully checked in.");
			break;

		case 3:	// Check Out
			if (instr.length != 2)
			{
				print("Check-out needs to have atleast 2 lines of code including the instruction type");
				break;
			}

			usr = hs.getUserByName(instr[1]);
			if (usr == null)
			{
				print("User is not found in the database. " + instr[1] + " was not successfully checked out.");
				break;
			}
			rsvp = hs.getReservationByCID(usr.getUserID());
			if (rsvp == null)
			{
				print("Reservation is not found in the database. " + instr[1] + " was not successfully checked out.");
				break;
			}
			if (hs.checkOutReservation(rsvp,date) != null)
			{
				print(instr[1] + " was successfully checked out.");
				print("");
				print("Check Out Statement:");
				print("Customer Name: " + rsvp.getReservedTo().getFullName());
				print("Customer Address: " + rsvp.getReservedTo().printAddress());
				print("Room Type: " + (rsvp.getRoom().isDouble() ? "Double" : "Single"));
				print("Nights reserved: " + rsvp.getNumberOfNights());
				System.out.printf("Charge per night: $%.2f\n", rsvp.getRoomCost());
				System.out.printf("Amount payable: $%.2f\n", rsvp.getNumberOfNights()*rsvp.getRoomCost());
			}
			else
				print(instr[1] + " was not successfully checkedout");
			break;

		case 4:	// Print Management Report
			if (!(instr.length == 2 || instr.length == 1))
			{
				print("Management Report needs to have atleast 2 lines of code including the instruction type");
				break;
			}
			Report rpt;
			// Report for all
			if (instr.length == 1)
			{
				rpt = hs.generateReportAll();
				print("Management Report for All");
			}
			// For just a given date
			else
			{
				rpt = hs.generateReportByRange(new Date(date.getMonth(), Integer.parseInt(instr[1]), year), new Date(date.getMonth(), Integer.parseInt(instr[1])+1, year));
				print("Management Report for " + date.getMonth() + "/" + instr[1] + "/" + date.getYear());
			}
			print("Number of Reservations: " + rpt.getNumberOfReservations());
			print("Single Rooms Reserved: " + rpt.getNumberOfSinglesReserved());
			print("Double Rooms Reserved: " + rpt.getNumberOfDoublesReserved());
			System.out.printf("Occupancy Rate: %.2f%%\n", rpt.getOccupancyRate());
			System.out.printf("Total Revenue: $%.2f\n", rpt.getTotalRevenue());
			break;

		case 5: // Day Change
			if (instr.length != 1)
			{
				print("Day change needs to have atleast 1 lines of code including the instruction type");
				break;
			}

			if (date.getDay() == Date.maxDayInMonth(date.getMonth(), date.getYear())) {
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

			ArrayList<Reservation> rsvps = hs.trigger6PM();
			for (int i = 0; i < rsvps.size(); i++)
				print("Cancelled Reservation for " + rsvps.get(i).getReservedTo().getFullName());
			break;
		default:
			print("No instruction found. Make sure you put it the correct instruction type.");
			break;
		}
		print("");
	}

	/**
	 * Description: Just an alias for System.out.println();
	 * 
	 * @param o
	 */
	public static void print(Object o)
	{
		System.out.println(o.toString());
	}

	public static HotelSystem getHS()
	{
		return hs;
	}
}
