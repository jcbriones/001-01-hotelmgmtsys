/*
 * Users.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is where all the logins of user, staff, and admin is stored.
 */

public class Users {
	// UNIQUE ID (Increments by 1)
	private static int UNIQUE_ID = 0;
	
	// Instance variables
	private int userID;
	private String username;
	private String password;
	private String name;
	private int accountType;	// 0 = User, 1 = Staff, 2 = Admin
	private boolean isBanned;
	
	public Users(String user, String pass, int type)
	{
		userID = UNIQUE_ID++;
		username = user;
		password = pass;
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
