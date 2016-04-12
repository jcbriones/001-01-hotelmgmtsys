import java.io.FileNotFoundException;

public class RSVPCoordinator {
	// Instantiation of HotelSystem
	private static HotelSystem hs = new HotelSystem();

	private static int month = 1;
	private static int day = 1;
	private static int year = 2016;
	private static Date date = new Date(month, day, year);

	// Generate rooms for now since we don't know how the rooms will be used when making a reservation and what room is to give to them.
	private static Room doubleRoom = hs.addRoom(101,true,100);
	private static Room singleRoom = hs.addRoom(102, false, 100);

	public static void main(String[] args) {
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
			for (int i = 0; i < instructions.length; i++)
				System.out.println(instructions[i]);
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
				if (instr.length != 11)
					print("Make Reservation needs to have atleast 11 lines of code including the instruction type");

				// Check if the user is already in the database or not

				if (hs.getUserByName(instr[1]) != null)
					usr = hs.getUser(instr[1]);
				else
					usr = hs.addUser(instr[1].replaceAll("\\s+",""), instr[1].replaceAll("\\s+",""), instr[1], 0);

				// Room will be used for Reservation
				hs.addReservation(usr, instr[5].equals("2") ? doubleRoom : singleRoom, Integer.parseInt(instr[6]), instr[7].equals("1") ? true : false, date.getMonth(), Integer.parseInt(instr[3]), date.getYear(), Integer.parseInt(instr[4]) - Integer.parseInt(instr[3]));
				break;

			case 2:	// Check In
				if (instr.length != 5)
					print("Check needs to have atleast 5 lines of code including the instruction type");

				usr = hs.getUserByName(instr[1]);
				rsvp = hs.getReservationByCID(usr.getUserID());
				hs.checkInReservation(rsvp);
				break;

			case 3:	// Check Out
				if (instr.length != 2)
					print("Check needs to have atleast 2 lines of code including the instruction type");

				usr = hs.getUserByName(instr[1]);
				rsvp = hs.getReservationByCID(usr.getUserID());
				hs.checkOutReservation(rsvp);
				break;

			case 4:	// Print Management Report
				hs.generateReportRange(new Date(month, Integer.parseInt(instr[1]), year), new Date(month, Integer.parseInt(instr[1])+1, year));
				break;

			case 5: // Day Change
				if (date.getDay() == date.maxDayInMonth(date.getMonth(), date.getYear())) {
					date.setMonth(date.getMonth()+1);
					date.setDay(1);

				}
				else
					date.setDay(date.getDay()+1);
				break;


			case 6: // 6 PM alarm


		}
	}