package com.dt.input.errors;

import org.apache.log4j.Logger;

public class UncorrectedKey extends java.lang.RuntimeException {

    private static final Logger log = Logger.getLogger(UncorrectedKey.class);

    UncorrectedKey(String message) {
        log.error(message);

    }
}
