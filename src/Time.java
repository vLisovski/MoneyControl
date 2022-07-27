
import java.util.Date;
import java.util.function.BiFunction;

public class Time {

    private Date dateOfOperation;
    private String stringDate;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int min;

    public Time() {
        dateOfOperation = new Date();
        year = dateOfOperation.getYear();
        month = dateOfOperation.getMonth();
        day = dateOfOperation.getDay();
        hour = dateOfOperation.getHours();
        min = dateOfOperation.getMinutes();
    }

    private int monthToInt(String month){

        switch (month){
            case "Jan":return 0;
            case "Feb":return 1;
            case "Mar":return 2;
            case "Apr":return 3;
            case "May":return 4;
            case "Jun":return 5;
            case "Jul":return 6;
            case "Aug":return 7;
            case "Sep":return 8;
            case "Oct":return 9;
            case "Nov":return 10;
            case "Dec":return 11;
        }
        return 0;
    }

    public Time(String date) {

        stringDate=date;
        year = Integer.parseInt(date.substring(24, 27));
        month = monthToInt(date.substring(4,6));
        day = Integer.parseInt(date.substring(8, 10));
        hour = Integer.parseInt(date.substring(11, 13));
        min = Integer.parseInt(date.substring(14, 16));

    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }

    public Date getDateOfOperation(){

        if(dateOfOperation!=null){
            return dateOfOperation;
        }else{
            return new Date();
        }
    }

    public String getStringDate() {
        return stringDate;
    }

    public boolean isLess(Time time) {

        if (this.year == time.getYear() && this.month == time.getMonth() && this.day == time.getDay()
                && this.hour == time.getHour() && this.min < time.getMin()) {

            return true;

        } else if (this.year == time.getYear() && this.month == time.getMonth() && this.day == time.getDay()
                && this.hour < time.getHour()) {

            return true;

        } else if (this.year == time.getYear() && this.month == time.getMonth() && this.day < time.getDay()) {

            return true;

        } else if (this.year == time.getYear() && this.month < time.getMonth()) {

            return true;

        } else if (this.year < time.getYear()) {

            return true;
        }

        return false;
    }
}
