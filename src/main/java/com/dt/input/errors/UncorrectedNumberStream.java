package com.dt.input.errors;

import org.apache.log4j.Logger;


public class UncorrectedNumberStream extends java.lang.RuntimeException {

    private static final Logger log = Logger.getLogger(UncorrectedNumberStream.class);

    UncorrectedNumberStream(String message) {
        log.error(message);
    }

}
