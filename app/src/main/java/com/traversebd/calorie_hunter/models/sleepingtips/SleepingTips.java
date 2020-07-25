package com.traversebd.calorie_hunter.models.sleepingtips;

public class SleepingTips {
    private String Age;
    private String HoursToSleep;

    public SleepingTips(String age, String hoursToSleep) {
        Age = age;
        HoursToSleep = hoursToSleep;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getHoursToSleep() {
        return HoursToSleep;
    }

    public void setHoursToSleep(String hoursToSleep) {
        HoursToSleep = hoursToSleep;
    }
}
