/**
 * Calendar.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the Calendar class which preview the list of reservations in a calendar format.
 * Class that keeps track of Dates and what days the Hotel Rooms are free
 */
import java.util.ArrayList;

public class Calendar {
	/**
	 * This will just point to the reservations inside the database.
	 */
	private ArrayList<Reservation> listOfReservations;

	/**
	 * Constructor
	 * @param hs
	 */
	public Calendar(HotelSystem hs)
	{
		listOfReservations = hs.getDB().getListOfReservations();
	}

	/**
	 * Description: Given a room and a list of dates, checks to see if the room is available.
	 * @param rm
	 * @param dates
	 * @return boolean
	 * @author Matt Edwards
	 */
	public boolean checkDate(Room rm, ArrayList<Date> dates)
	{
		// Goes through the list of reservations
		// Then checks that reservation's date range
		// Then checks to see if the given dates are equal to any of the dates in the date range
		for (int i = 0; i < listOfReservations.size(); i++)
			for (int j = 0; j < listOfReservations.get(i).getDates().size(); j++)
				for (int k = 0; k < dates.size(); k++)
					if (listOfReservations.get(i).getDates().get(j).equals(dates.get(k)) && listOfReservations.get(i).getRoom() == rm)
						return false;
		return true;
	}

	/**
	 *  Given a range of dates, collect the list of Reservation during that given time.
	 * @param day1
	 * @param day2
	 * @return ArrayList<Reservation>
	 * @author Matt Edwards
	 */
	public ArrayList<Reservation> ReservationByDateRange(Date day1, Date day2)
	{
		// Error checking for if day2 is before day1
		if (day2.isBefore(day1))
			throw new RuntimeException();
		
		// Range of Dates
		ArrayList<Date> dates = new ArrayList<Date>();
		int diff = day1.getDifferenceFrom(day2);
		for (int i = 0; i <= diff; i++)
			dates.add(new Date(day1.getMonth(), day1.getDay() + i, day1.getYear()));

		// list will be holding all the reservations within the range given
		ArrayList<Reservation> list = new ArrayList<Reservation>();

		
		for (int i = 0; i < listOfReservations.size(); i++)
			for (int j = 0; j < listOfReservations.get(i).getDates().size(); j++)
				for (int k = 0; k < dates.size(); k++)
					if (listOfReservations.get(i).getDates().get(j).equals(dates.get(k)) && !list.contains(listOfReservations.get(i)))
						list.add(listOfReservations.get(i));
		return list;
	}

}
