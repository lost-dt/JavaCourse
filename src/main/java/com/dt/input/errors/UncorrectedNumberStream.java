package com.dt.input.errors;

import java.io.*;

public class UncorrectedNumberStream extends java.lang.RuntimeException {

    UncorrectedNumberStream(String message) {
        System.out.println(message);
    }

}
