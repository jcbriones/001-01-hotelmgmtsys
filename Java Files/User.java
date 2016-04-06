/*
 * User.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is where all the logins of user, staff, and admin is stored.
 */

public class User {
	// UNIQUE ID (Increments by 1)
	private static int UNIQUE_ID = 0;
	
	// Instance variables
	private int userID;
	private String username;
	private String password;
	private String fullName;
	private int accountType;	// 0 = User, 1 = Staff, 2 = Admin
	private boolean isBanned;
	
	public User(String user, String pass, String name, int type)
	{
		userID = UNIQUE_ID++;
		username = user;
		password = pass;
		fullName = name;
		accountType = type;
		isBanned = false;
	}
	
	// Setters and Getters
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
}
