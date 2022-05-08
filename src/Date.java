public class Date{

    private int month, day, year;

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public String displayDate(){
        return getMonth() + "/" + getDay() + "/" + getYear();
    }

    public int getDate(){
        return getMonth() + getDay() +  getYear();
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }
}
