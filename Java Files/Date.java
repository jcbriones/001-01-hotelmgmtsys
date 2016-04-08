/*
 * Date.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the Date class which holds the days in our Calendar.
 */

public class Date {
	private int month,day,year;
	private Room rm;

	public Date(Room rm, int month, int day, int year)
	{
		this.month = month;
		this.day = day;
		this.year = year;
		this.rm = rm;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean equals(Date that)
	{
		return this.rm == that.rm &&
				this.month == that.month &&
				this.day == that.day &&
				this.year == that.year;
	}

	public String toString()
	{
		return String.format("%d/%d/%d",this.month,this.day,year);
	}
}
