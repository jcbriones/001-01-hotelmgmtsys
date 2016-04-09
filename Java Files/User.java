/*
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
	private boolean isBanned;
	private ArrayList<CreditCard> creditCards;
	private CreditCard defaultCard;

	public User(String user, String pass, String name, int type)
	{
		userID = UNIQUE_ID++;
		username = user;
		password = pass;
		fullName = name;
		accountType = type;
		isBanned = false;
		creditCards = new ArrayList<CreditCard>();
		defaultCard = null;
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

}
