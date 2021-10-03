package com.kamijoucen.kirauid.util;

public class Utils {

    public static long tilNextMillis(long lastTimestamp) {
        long time = timeGen();
        while (time <= lastTimestamp) {
            time = timeGen();
        }
        return time;
    }

    public static long timeGen() {
        return System.currentTimeMillis();
    }


}
