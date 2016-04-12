/*
 * CheckIn.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the where checking in of customer happens.
 */

public class CheckIn {
	private Reservation rsvp;

	public CheckIn(Reservation rsvp)
	{
		this.rsvp = rsvp;
	}

	public CheckIn checkIn() {
		if (!rsvp.isCheckedIn() && !rsvp.isStayFinished())
		{
			// Charge the remaining balance of the reservation, if payment doesn't go through then checking-in of user
			// is not successful. Credit Card is invalid. Otherwise, complete checking-in of user
			if (rsvp.validatePayment(rsvp.getBalance()))
			{
				rsvp.setBalance(0);
				rsvp.setCheckedIn(true);
				rsvp.getRoom().setOccupied(true);
				return this;
			}
		}
		return null;
	}

	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("== Check-In ==\n");
		str.append("Reservation ID: " + rsvp.getRsvpID() + "\n");
		str.append("Customer Name: " + rsvp.getReservedTo().getFullName() + "\n");
		str.append("Credit Card Used:\n\n");
		str.append(rsvp.getReservedTo().getDefaultCard().toString() + "\n");
		str.append("==============\n");
		return str.toString();
	}
}
