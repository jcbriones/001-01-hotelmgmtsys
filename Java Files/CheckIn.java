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

	public CheckIn checkIn(Date date) {
		if (!rsvp.isCheckedIn() && rsvp.getDates().get(0).equals(date) && rsvp.getBalance() == 0)
		{
				rsvp.setCheckedIn(true);
				rsvp.setGuaranteed(true);
				rsvp.getRoom().setOccupied(true);
				return this;
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
