package com.desenv2.emailpi.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogService {
    private static Logger log;

    public static void logInfo(String msg, Class aClass) {
        log = LoggerFactory.getLogger(aClass);
        log.info(msg);
    }

    public static void logWarn(String msg, Class aClass) {
        log = LoggerFactory.getLogger(aClass);
        log.warn(msg);
    }

    public static void logError(String msg, Class aClass) {
        log = LoggerFactory.getLogger(aClass);
        log.error(msg);
    }

    public static void logError(Exception exception, Class aClass) {
        log = LoggerFactory.getLogger(aClass);
        log.error(exception.getMessage());
    }

    public static void logError(String identify, Exception exception, Class aClass) {
        log = LoggerFactory.getLogger(aClass);
        log.error(String.format("%s\t--\t%s", identify, exception.getMessage()));
    }
}
