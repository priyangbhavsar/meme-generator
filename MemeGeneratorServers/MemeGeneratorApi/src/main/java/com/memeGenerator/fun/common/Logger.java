package com.memeGenerator.fun.common;


public class Logger {
    public static void debugLog(String ... args) {
        String outputString = "";
        for (String arg : args) {
            outputString += arg;
        }
        System.out.println(outputString);
    }

    public static void errorLog(String ... args) {
        String outputString = "";
        for (String arg : args) {
            outputString += arg;
        }
        System.err.println(outputString);
    }
}
