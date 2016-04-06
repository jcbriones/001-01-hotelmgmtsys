/**
 * Created by Lvovich on 4/5/2016.
 */
public class Date {
    private int day,month,year;

    public Date(int day, int month, int year)
    {
        this.day = day;
        this.month = month;
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

    public boolean equals(Date day2)
    {
        return this.getDay() == day2.getDay() &&
                this.getMonth() == day2.getMonth() &&
                this.getYear() == day2.getYear();
    }

    public boolean isBefore(Date date)
    {
        return (this.year <= date.year) &&
                (this.month <= date.month) &&
                (this.day < date. day);

    }

    public int maxDays()
    {
        //30 days
        if(this.getMonth() == 4 ||
                this.getMonth() == 6 ||
                this.getMonth() == 9 ||
                this.getMonth() == 11)
            return 30;

        //28 days (not counting leap year because F that, can change later
        if(this.getMonth() == 2)
            return 28;

        //Everything else has 31 days
        return 31;
    }

    public String toString()
    {
        return String.format("%d/%d/%d",this.month,this.day,year);
    }
}
