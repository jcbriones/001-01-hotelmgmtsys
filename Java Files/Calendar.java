/*
 * Calendar.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the Calendar class which preview the list of reservations in a calendar format.
 */
import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class Calendar {
    public Date Today;
    //revinue by a period of time
    private double Revinue;
    //Number of people in the hotel
    private int TotalOccupancy;

    public ArrayList<Reservation> ListOfReservations = new ArrayList<Reservation>();

    public Date Today(){return Today;}

    public void addReservation(Reservation res)
    {
        ListOfReservations.add(res);
    }


    //Goes through the events  in the Hotel System
    //And return all events that are happening at the provided date
    public ArrayList<Reservation> ReservationByDate(Date date) {
        ArrayList<Reservation> ReservationOnDate = new ArrayList<Reservation>();
        for(int i=0;i<ListOfReservations.size(); i++)
        {
            if(ListOfReservations.get(i).equals(date))
            {
                ReservationOnDate.add(ListOfReservations.get(i));
            }
        }
        return ReservationOnDate;
    }


    //Returns the total occupancy of people that have a reservation at the hotel
    public int TotalOcucpancy()
    {
        TotalOccupancy = 0;
        for(int i=0;i<ListOfReservations.size();i++)
        {
            TotalOccupancy += ListOfReservations.get(i).getNumberOfOccupants();
        }
        return TotalOccupancy;
    }

    //Given a range of dates, collect the revinue during that pime.
    //going to be given Day1 and Day2
    public ArrayList<Reservation> ReservationByDateRange(Date day1, Date day2)
    {
        //error checking for if day2 is before day1
        if(day2.isBefore(day1))
            throw new RuntimeException();

        //List will be holding all the reservations within the range given
        ArrayList<Reservation> List = new ArrayList<Reservation>();
        //CurrDayList will be holding the reservations for the current day
        ArrayList<Reservation> CurrDayList = new ArrayList<Reservation>();
        //Iterator for the Current Day's Reservations
        Iterator<Reservation> it;
        //The Current Reservation that I'm comparing
        Reservation CurrRes;

        for(int y=day1.getYear();y<=day2.getYear();y++)
        {
            for(int m=day1.getMonth();m<=day2.getMonth();m++)
            {
                for( int d=day1.getDay();d<=day2.getDay();d++)
                {
                    CurrDayList = ReservationByDate(new Date(d,day1.getMonth(),day1.getYear()));
                    it = CurrDayList.iterator();
                    while(it.hasNext())
                    {
                        CurrRes = it.next();
                        if(!List.contains(CurrRes))
                        {
                            List.add(CurrRes);
                        }
                    }
                }
            }
        }

        return List;
    }

    //Given a period of time, will add up all the revinue from the rooms throughout the period
    public double RevinueByPeriod(Date day1, Date day2)
    {
        Revinue = 0.0;
        //Same error checking as before
        if(day2.isBefore(day1))
            throw new RuntimeException();

        ArrayList<Reservation> CurrDayList = new ArrayList<Reservation>();
        //Iterator for the Current Day's Reservations
        Iterator<Reservation> it;
        //The Current Reservation that I'm comparing
        Reservation CurrRes;

        for(int y=day1.getYear();y<=day2.getYear();y++)
        {
            for(int m=day1.getMonth();m<=day2.getMonth();m++)
            {
                for( int d=day1.getDay();d<=day2.getDay();d++)
                {
                    CurrDayList = ReservationByDate(new Date(d,day1.getMonth(),day1.getYear()));
                    it = CurrDayList.iterator();
                    while(it.hasNext())
                    {
                        CurrRes = it.next();
                        Revinue += CurrRes.getRoomCost();
                    }
                }
            }
        }

        return Revinue;
    }
}
