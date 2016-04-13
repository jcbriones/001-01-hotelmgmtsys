/**
 * ProcessPayment.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the where all the payments are being processed through the use of functions.
 */

public final class ProcessPayment {
	
	/**
	 * Description: This is where the credit card is getting charged.
	 * 
	 * @param card
	 * @param amount
	 * @return boolean
	 * @author Ken Matsuda
	 */
	public static boolean processPayment(CreditCard card, double amount) {
		// if the card balance is less than 0 or isn't found then it returns false
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
