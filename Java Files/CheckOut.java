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

	public CheckOut checkOut() {
		if (rsvp.isCheckedIn())
		{
			// Check-out the user and finish the booking
			rsvp.setCheckedIn(false);
			rsvp.setBookingCompleted(true);
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
