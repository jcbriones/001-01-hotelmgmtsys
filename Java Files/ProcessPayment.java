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
	public boolean processPayment(CreditCard card, int amount) {
		if (amount < 0 || card == null)
			return false;
		else
			return true;
	}
}
