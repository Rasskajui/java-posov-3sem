package ru.spbu.arts.java.oop.time;

public class Time {
    private int hour;
    private int minutes;

    public Time(int hour, int minutes){
        this.hour = hour;
        this.minutes = minutes;
    }

    public String show(){
        String hourRes = Integer.toString(this.hour);
        if (this.hour < 10){
            hourRes = "0" + hourRes;
        }
        String minutesRes = Integer.toString(this.minutes);
        if (this.minutes < 10){
            hourRes = "0" + minutesRes;
        }
        return hourRes + ":" + minutesRes;
    }

    public boolean isDay(){
        return (this.hour > 12 && this.hour <= 19);
    }

    public boolean isMorning(){
        return (this.hour > 6 && this.hour <= 12);
    }

    public boolean isEvening(){
        return (this.hour > 19 && this.hour < 23);
    }

    public boolean isNight(){
        return (this.hour == 23 || this.hour <= 6 && this.hour >= 0);
    }

    public String sayHello(){
        if (this.isDay()){
            return "Good Day!";
        } else if (this.isMorning()){
            return "Good Morning!";
        } else if (this.isEvening()){
            return "Good Evening!";
        } else if (this.isNight()){
            return "Good Night!";
        }
        return "I'm not sure what time is it, but I hope it's good!";
    }

    public void add(int minToAdd){
        int min = this.minutes;
        int hours = this.hour;
        if (!(this.hour > 23 || this.minutes > 59)){
            hours += minToAdd / 60;
            min += minToAdd % 60;

            if (min > 59){
                hours += 1;
                min = min % 60;
            }

            this.hour = hours;
            this.minutes = min;
        }
    }
}
