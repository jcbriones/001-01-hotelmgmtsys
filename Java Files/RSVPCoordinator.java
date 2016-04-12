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
