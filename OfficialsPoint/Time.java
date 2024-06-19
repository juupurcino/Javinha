public class Time {
    
    int hour = 0;
    int minute = 0;
    int day = 0;
    int month = 0;
    int year = 0;
    
    public void addTime(int hour, int minute) {

        this.minute += minute;
        this.hour += hour;
        
        if (this.minute > 59) {
            hour += this.minute / 60;
            this.minute %= 60;
        }

        if (this.hour > 23) {
            this.hour %= 24;
        }
    }

    public void addDate(int day, int month, int year) {
        
        this.year += year;
        this.month += month;
        this.day += day;

        if (this.day > 30) {
            this.month += this.day / 30;
            this.day %= 30;
        }

        if (this.month > 12) {
            this.year += this.month / 12;
            this.month %= 12;
        }
    }

}
    



