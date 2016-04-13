/**
 * Staff.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the CreditCard class which holds the data of a credit card such as name,
 * credit card number, exp date, etc...
 */

public class CreditCard {
	/**
	 * Class Variables
	 */
	private String nameOnCard;
	private String type;
	private String cardNumber;
	private int CCV;
	private int expDateM;
	private int expDateY;
	private String billingAddress1;
	private String billingAddress2;
	private String billingCity;
	private String billingState;
	private int billingZip;
	private double amount=0.00;

	/**
	 * Description: Constructor for CreditCard
	 * 
	 * @param nameOnCard
	 * @param type
	 * @param cardNumber
	 * @param CCV
	 * @param expDateM
	 * @param expDateY
	 * @param billingAddress1
	 * @param billingAddress2
	 * @param billingCity
	 * @param billingState
	 * @param billingZip
	 * @author Ken Matsuda
	 */
	public CreditCard(String nameOnCard, String type, String cardNumber, int CCV, int expDateM, int expDateY, String billingAddress1, String billingAddress2, String billingCity, String billingState, int billingZip) {
		this.nameOnCard = nameOnCard;
		this.type = type;
		this.cardNumber = cardNumber;
		this.CCV = CCV;
		this.expDateM = expDateM;
		this.expDateY = expDateY;
		this.billingAddress1 = billingAddress1;
		this.billingAddress2 = billingAddress2;
		this.billingCity = billingCity;
		this.billingState = billingState;
		this.billingZip = billingZip;
		this.amount = 0;
	}
	
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("== Credit Card ==\n");
		str.append("Name on Card: " + nameOnCard + "\n");
		str.append("Card Type: " + type + "\n");
		str.append("Card Number: " + cardNumber + "\n");
		str.append("CCV: " + CCV + "\n");
		str.append("Exp Date: " + expDateM + "/" + expDateY + "\n");
		str.append("Billing Address: " + billingAddress1 + ", " + billingAddress2 + ", " + billingCity + ", " + billingState + ", " + billingZip + "\n");
		str.append("Total Amount Charged: " + amount + "\n");
		str.append("=================\n");
		return str.toString();
	}

	/* =======================================
	 * Setters and Getters
	 * =======================================
	 */
	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCCV() {
		return CCV;
	}

	public void setCCV(int cCV) {
		CCV = cCV;
	}

	public int getExpDateM() {
		return expDateM;
	}

	public void setExpDateM(int expDateM) {
		this.expDateM = expDateM;
	}

	public int getExpDateY() {
		return expDateY;
	}

	public void setExpDateY(int expDateY) {
		this.expDateY = expDateY;
	}

	public String getBillingAddress1() {
		return billingAddress1;
	}

	public void setBillingAddress1(String billingAddress1) {
		this.billingAddress1 = billingAddress1;
	}

	public String getBillingAddress2() {
		return billingAddress2;
	}

	public void setBillingAddress2(String billingAddress2) {
		this.billingAddress2 = billingAddress2;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getBillingState() {
		return billingState;
	}

	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}

	public int getBillingZip() {
		return billingZip;
	}

	public void setBillingZip(int billingZip) {
		this.billingZip = billingZip;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}