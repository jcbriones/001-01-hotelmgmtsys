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

	public Date(int month, int day, int year)
	{
		this.month = month;
		this.day = day;
		this.year = year;
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
		return this.month == that.month && this.day == that.day && this.year == that.year;
	}

	public String toString()
	{
		return String.format("%d/%d/%d",this.month,this.day,year);
	}

	// TODO: Get the difference between two dates. Example: this-> 02/01/16, that 01/29/16 has the dates 29,30,31,1 so it would return 4
	public int getDifferenceFrom(Date that) {
		int monthDiff = this.getMonth() - that.getMonth();
		int dayDiff = this.getDay() - that.getDay();
		int dayYear = this.getYear() - that.getYear();
		return dayDiff + 1;
	}

	public boolean isBefore(Date that) {
		return this.getMonth() - that.getMonth() >= 0 && this.getDay() - that.getDay() >= 0 || this.getYear() - that.getYear() >= 0;
	}
}
