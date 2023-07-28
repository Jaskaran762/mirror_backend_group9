package com.group9.group09.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

public class LoggerFactoryImpl {

    private static LoggerFactoryImpl instance;
    private Logger logger;

    private LoggerFactoryImpl() {
        logger = LoggerFactory.getLogger(LoggerFactoryImpl.class);
    }

    public static Logger getLogger() {
        if (instance == null) {
            // Create the instance if it doesn't exist.
            instance = new LoggerFactoryImpl();
        }
        return instance.logger;
    }
}
