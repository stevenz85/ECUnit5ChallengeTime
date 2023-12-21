public class Time {
    private int hour;
    private int minute;
    private int second;
    public Time (int hours, int minutes, int seconds) {
        this.hour = hours;
        this.minute = minutes;
        this.second = seconds;
    }

    public String info() {
        String returnStr = "";
        if (hour > 9) {
            returnStr += hour;
        } else {
            returnStr += "0" + hour;
        }
        returnStr += ":";
        if (minute > 9) {
            returnStr += minute;
        } else {
            returnStr += "0" + minute;
        }
        returnStr += ":";
        if (second > 9) {
            returnStr += second;
        } else {
            returnStr += "0" + second;
        }
        return returnStr;
    }
    public void tick() {
        second += 1;
        if (second == 60) {
            second = 0;
            minute += 1;
            if (minute == 60) {
                minute = 0;
                hour += 1;
                if (hour == 24) {
                    hour = 0;
                }
            }
        }
    }
    public void add(Time time){
        int num = (time.hour * 3600) + (time.minute * 60) + time.second;
        for (int i = 0; i < num; i ++) {
            tick();
        }
    }
    public void add(String str){
        int hours = Integer.parseInt(str.substring(0, 2));
        int minutes = Integer.parseInt(str.substring(3, 5));
        int seconds = Integer.parseInt(str.substring(6, 8));
        int num = seconds + (minutes * 60) + (hours * 3600);
        for (int i = 0; i < num; i ++) {
            tick();
        }
    }
}
