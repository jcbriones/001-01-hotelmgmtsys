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
	 * @param from
	 * @param to
	 * @return ArrayList<Reservation>
	 * @author Matt Edwards, Jc Briones
	 */
	public ArrayList<Reservation> ReservationByDateRange(Date from, Date to)
	{
		// Error checking for if to is before from
		if (to.isBefore(from))
			throw new RuntimeException();
		
		// Range of Dates
		ArrayList<Date> dates = new ArrayList<Date>();
		int diff = from.getDifferenceFrom(to);
		for (int i = 0; i <= diff; i++)
			dates.add(new Date(from.getMonth(), from.getDay(), from.getYear()).increase(i));

		// List will be holding all the reservations within the range given
		ArrayList<Reservation> list = new ArrayList<Reservation>();

		// Only get the Reservations within the given dates up to, but not including, the checkout date
		for (int i = 0; i < listOfReservations.size(); i++)
			for (int j = 0; j < listOfReservations.get(i).getDates().size() - 1; j++)
				for (int k = 0; k < dates.size(); k++)
					if (listOfReservations.get(i).getDates().get(j).equals(dates.get(k)) && !list.contains(listOfReservations.get(i)))
						list.add(listOfReservations.get(i));
		return list;
	}

}
