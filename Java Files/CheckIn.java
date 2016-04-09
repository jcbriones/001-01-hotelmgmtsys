/*
 * CheckIn.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the where checking in of customer happens.
 */

public final class CheckIn {
	private static Reservation rsvp;
	public static boolean checkInUser(Reservation reservation) {
		rsvp = reservation;
		
		if (!rsvp.isCheckedIn() && !rsvp.isBookingCompleted())
		{
			// Charge the remaining balance of the reservation, if payment doesn't go through then checking-in of user
			// is not successful. Credit Card is invalid. Otherwise, complete checking-in of user
			if (ProcessPayment.processPayment(rsvp.getReservedTo().getCreditCard(),rsvp.getBalance()))
			{
				rsvp.setBalance(0);
				rsvp.setCheckedIn(true);
			}
		}
		return false;
	}
	
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("== Check-In ==\n");
		str.append("Reservation ID: " + rsvp.getRsvpID() + "\n");
		str.append("Customer Name: " + rsvp.getReservedTo().getFullName() + "\n");
		str.append("Credit Card Used:\n");
		str.append(rsvp.getReservedTo().getCreditCard().toString() + "\n");
		str.append("==============\n");
		return str.toString();
	}
}
