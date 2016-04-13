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
	private int month, day, year;

	public Date(int month, int day, int year)
	{
		if (month < 1 || month > 12)
			throw new IndexOutOfBoundsException("Invalid month");
		if (day < 1 || day > maxDayInMonth(month,year))
			throw new IndexOutOfBoundsException("Invalid day for month " + month + " with the given year");
		if (year < 1970)
			throw new IndexOutOfBoundsException("Can't go below year 1970");

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
		String month;
		switch(this.month)
		{
		case 1:
			month = "January";
			break;
		case 2:
			month = "February";
			break;
		case 3:
			month = "March";
			break;
		case 4:
			month = "April";
			break;
		case 5:
			month = "May";
			break;
		case 6:
			month = "June";
			break;
		case 7:
			month = "July";
			break;
		case 8:
			month = "August";
			break;
		case 9:
			month = "September";
			break;
		case 10:
			month = "October";
			break;
		case 11:
			month = "November";
			break;
		case 12:
			month = "December";
			break;
		default:
			month = "Unknown";
			break;
		}
		return String.format("%s %d, %d",month, this.day, this.year);
	}


	/*
	 * Pseudocode for this method:
	 * 
	 * getDifferenceFrom(Date this, Date that) {
	 * 		if (this == that)		//If they're the same date
	 * 			return 0
	 * 		
	 * 		boolean swapped = false	
	 * 		if (this > that) {		//If this is further in the future than that, swap them
	 * 			swap(this, that)
	 * 			swapped = true
	 * 		}
	 * 
	 * 		counter = 0
	 * 		day = this.day
	 * 		month = this.month
	 * 		year = this.year
	 * 		while (day, month, and year != that.year, that.month, that.day) {		//The day, month, and year from this need to equal that's fields for the loop to terminate 
	 * 			if (month is over) {
	 * 				if (month == December) {	//Special case for the end of the year
	 * 					month = 1
	 * 					day = 1
	 * 					year++
	 * 				} else {	//If the month is over and it isn't December, do this 
	 * 					month++
	 * 					day = 1
	 * 				}
	 * 			} else {	//If the month isn't over, do this
	 * 				day++
	 * 			}
	 * 			counter++	//Do this everytime you move forward a day
	 * 		}
	 * 		
	 * 		//If this > that, then you return a negative count. Otherwise, it's positive
	 * 		if (swapped) {
	 * 			return -counter
	 * 		} else {
	 * 			return counter
	 * 		}
	 * }
	 */

	public int getDifferenceFrom(Date that) {
		if (this.year == that.year && this.month == that.month && this.day == that.day)
			return 0;

		Date day1 = this;
		Date day2 = that;
		boolean reversed = false;
		if ((this.year > that.year) || (this.year == that.year && this.month > that.month) || 
				(this.year == that.year && this.month == that.month && this.day > that.day))
		{
			day1 = that;
			day2 = this;
			reversed = true;
		}

		int count = 0;
		int month = day1.month;
		int day = day1.day;
		int year = day1.year;
		while (!(year == day2.year && month == day2.month && day == day2.day)) {
			if (day == maxDayInMonth(month, year)) {
				if (month == 12) {
					month = 1;
					day = 1;
					year++;
				} else {
					month++;
					day = 1;
				}
			}
			else
				day++;
			count++;
		}
		if (reversed)
			return -count;
		return count;
	}

	/*
	 * Pseudocode for maxDayInMonth()
	 * 
	 * maxDayInMonth(month, year) {
	 * 		if (month == 1,3,5,7,8,10,12) {
	 * 			return 31
	 * 		} else if (month == 4,6,9,11) {
	 * 			return 30
	 * 		} else if (month == 2) {
	 * 			if (isLeapYear(year)) {
	 * 				return 29
	 * 			} else {
	 * 				return 28
	 * 			}
	 * 		} else {
	 * 			return -1
	 *		}
	 * }
	 */
	public int maxDayInMonth(int month, int year) {
		switch(month)
		{
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			// Check for Leap Year
			if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
				return 29;
			else
				return 28;
		default:
			return -1;
		}
	}

	/*
	 * Pseudocode for isBefore()
	 * 
	 * isBefore(this, that) {
	 * 		return that.getMonth() - this.getMonth() >= 0 && that.getDay() - this.getDay() > 0 && that.getYear() - this.getYear() >= 0
	 * }
	 */
	public boolean isBefore(Date that) {
		return that.month - this.month >= 0 && that.day - this.day > 0 && that.year - this.year >= 0;
	}
	
	public static void main(String[] args) {
		//Test Cases for getDifferenceFrom()
		//Test1
		Date test11 = new Date(10,11,1994);
		Date test12 = new Date(10,12,1994);
		System.out.println("Test1: " + test11.getDifferenceFrom(test12));
		
		//Test2
		Date test21 = new Date(10,11,1994);
		Date test22 = new Date(10,12,1995);
		System.out.println("Test2: " + test21.getDifferenceFrom(test22));
		
		//Test3
		Date test31 = new Date(10,11,1994);
		Date test32 = new Date(10,12,2000);
		System.out.println("Test3: " + test31.getDifferenceFrom(test32));
		
		//Test4
		Date test41 = new Date(10,11,2000);
		Date test42 = new Date(10,12,1994);
		System.out.println("Test4: " + test41.getDifferenceFrom(test42));
		
		//Test5
		Date test51 = new Date(10,11,3000);
		Date test52 = new Date(10,12,4000);
		System.out.println("Test5: " + test51.getDifferenceFrom(test52));
		
		//Test Cases for maxDayInMonth()
		//Test1
		System.out.println("Test1: " + test11.maxDayInMonth(1, 2016));
		//Test2
		System.out.println("Test2: " + test11.maxDayInMonth(2, 2016));
		//Test3
		System.out.println("Test3: " + test11.maxDayInMonth(3, 2016));
		//Test4
		System.out.println("Test4: " + test11.maxDayInMonth(4, 2016));
		//Test5
		System.out.println("Test5: " + test11.maxDayInMonth(5, 2016));
		//Test6
		System.out.println("Test6: " + test11.maxDayInMonth(6, 2016));
		//Test7
		System.out.println("Test7: " + test11.maxDayInMonth(7, 2016));
		//Test8
		System.out.println("Test8: " + test11.maxDayInMonth(8, 2016));
		//Test9
		System.out.println("Test9: " + test11.maxDayInMonth(9, 2016));
		//Test10
		System.out.println("Test10: " + test11.maxDayInMonth(10, 2016));
		//Test11
		System.out.println("Test11: " + test11.maxDayInMonth(11, 2016));
		//Test12
		System.out.println("Test12: " + test11.maxDayInMonth(12, 2016));
		//Test13
		System.out.println("Test13: " + test11.maxDayInMonth(2, 2015));
	}

}
