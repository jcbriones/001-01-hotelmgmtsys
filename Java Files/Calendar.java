/*
 * Calendar.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the Calendar class which preview the list of reservations in a calendar format.
 */
import java.util.ArrayList;

public class Calendar {
	private ArrayList<Reservation> listOfReservations;

	// Constructor
	public Calendar()
	{
		listOfReservations = HotelSystem.getDB().getListOfReservations();
	}

	public boolean checkDate(Room rm, ArrayList<Date> dates)
	{
		for (int i = 0; i < listOfReservations.size(); i++)
			for (int j = 0; j < listOfReservations.get(i).getDates().size(); j++)
				for (int k = 0; k < dates.size(); k++)
					if (listOfReservations.get(i).getDates().get(j).equals(dates.get(k)) && listOfReservations.get(i).getRoom() == rm)
						return false;
		return true;
	}

	// Given a range of dates, collect the list of Reservation during that given time.
	public ArrayList<Reservation> ReservationByDateRange(Date day1, Date day2)
	{
		// Error checking for if day2 is before day1
		if (day2.isBefore(day1))
			throw new RuntimeException();
		
		// Range of Dates
		ArrayList<Date> dates = new ArrayList<Date>();
		int diff = day2.getDifferenceFrom(day1);
		for (int i = 0; i <= diff; i++)
			dates.add(new Date(day1.getMonth(), day1.getDay() + i, day1.getYear()));

		// List will be holding all the reservations within the range given
		ArrayList<Reservation> list = new ArrayList<Reservation>();

		for (int i = 0; i < listOfReservations.size(); i++)
			for (int j = 0; j < listOfReservations.get(i).getDates().size(); j++)
				for (int k = 0; k < dates.size(); k++)
					if (listOfReservations.get(i).getDates().get(j).equals(dates.get(k)) && !list.contains(listOfReservations.get(i)))
						list.add(listOfReservations.get(i));
		return list;
	}

}
