package ces22;

class Time {

    private int hour;
    private int minute;

    public Time() {
    }

    ;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

}

class Exercicio3 {

    public static void main(String arg[]) {
        Time time = new Time();
        time.setHour(3);
        time.setMinute(25);
        System.out.println("The time now is " + time.getHour() + ":" + time.getMinute());
    }
}
