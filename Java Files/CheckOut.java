/*
 * CheckOut.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the where checking out of customer happens.
 */

public class CheckOut {
	private Reservation rsvp;

	public CheckOut(Reservation rsvp)
	{
		this.rsvp = rsvp;
	}

	public CheckOut checkOut(Date date) {//When the customer is finished with the stay sets the room to unoccupied and checked in to false
		if (rsvp.isCheckedIn() && rsvp.getDates().get(rsvp.getDates().size()-1).equals(date))
		{
			// Check-out the user and finish the booking
			rsvp.setCheckedIn(false);
			rsvp.setStayFinished(true);
			rsvp.getRoom().setOccupied(false);
			return this;
		}
		return null;
	}

	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("== Check-Out ==\n");
		str.append("Reservation ID: " + rsvp.getRsvpID() + "\n");
		str.append("Customer Name: " + rsvp.getReservedTo().getFullName() + "\n");
		str.append("==============\n");
		return str.toString();
	}
}
