package com.dt;

import com.dt.controller.Controller;

import org.apache.log4j.Logger;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Start work.");

        Controller animalsController = new Controller(50);

        animalsController.startMenu();

        log.info("End work.\n");
    }
}


