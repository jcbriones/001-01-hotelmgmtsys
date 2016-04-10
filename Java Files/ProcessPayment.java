/*
 * ProcessPayment.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the where all the payments are being processed through the use of functions.
 */

public final class ProcessPayment {
	public static boolean processPayment(CreditCard card, double amount) {
		if (amount < 0 || card == null)
			return false;
		else
		{
			// Charge the card with the specified amount
			card.setAmount(amount);
			return true;
		}
	}
}
