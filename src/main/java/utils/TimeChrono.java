package utils;

import java.util.concurrent.TimeUnit;

public class TimeChrono {

    public static String millisecondsToTime(long milliseconds) {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds);
        return  minutes + " mn : " + seconds +" s";
    }
}
