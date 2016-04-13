/**
 * User.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is where all the logins of user, staff, and admin is stored.
 */
import java.util.ArrayList;

public class User {
	// UNIQUE ID (Increments by 1)
	private static int UNIQUE_ID = 0;

	// Instance variables
	private int userID;
	private int accountType;	// 0 = User, 1 = Staff, 2 = Admin
	private String username;
	private String password;
	private String fullName;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private int zip;
	private boolean isBanned;
	private ArrayList<CreditCard> creditCards;
	private CreditCard defaultCard;
	
	/**
	 * Description: Constructor for a creating a User.
	 * 
	 * @param user
	 * @param pass
	 * @param name
	 * @param type
	 * @param address1
	 * @param address2
	 * @param city
	 * @param state
	 * @param zip
	 * @author Matt Edwards
	 */
	public User(String user, String pass, String name, int type, String address1, String address2, String city, String state, int zip)
	{
		this.userID = UNIQUE_ID++;
		this.username = user;
		this.password = pass;
		this.fullName = name;
		this.accountType = type;
		this.isBanned = false;
		this.creditCards = new ArrayList<CreditCard>();
		this.defaultCard = null;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("== Account Details ==\n");
		str.append("User ID:\t" + userID + "\n");
		str.append("Username:\t" + username + "\n");
		str.append("Password:\t" + password + "\n");
		str.append("Full Name:\t" + fullName + "\n");
		str.append("Account Type:\t" + (accountType > 0 ? (accountType > 1 ? "Admin" : "Staff") : "Customer") + "\n");
		str.append("=====================\n");
		return str.toString();
	}

	/* =======================================
	 * Setters and Getters
	 * =======================================
	 */
	public int getUserID() {
		return userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String name) {
		this.fullName = name;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public boolean isBanned() {
		return isBanned;
	}

	public void setBanned(boolean isBanned) {
		this.isBanned = isBanned;
	}

	public ArrayList<CreditCard> getCreditCards() {
		return creditCards;
	}

	public CreditCard getDefaultCard() {
		return defaultCard;
	}

	public void setDefaultCard(CreditCard defaultCard) {
		this.defaultCard = defaultCard;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String printAddress() {
		return address1 + ", " + address2 + ", " + city + ", " + state + ", " + zip;
	}
}
