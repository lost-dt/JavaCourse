package com.dt.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleStream {

    public static String stringFromConsole() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public static float floatFromConsole() {

        Scanner scanner = new Scanner(System.in);

        boolean correct;
        String inputString = "";
        do {
            try {

                inputString = scanner.nextLine();
                InputValidator.validationFloatNumber(inputString);
                correct = true;

            } catch (UncorrectedNumberStream e) {
                correct = false;
            }
        } while (!correct);

        return Float.parseFloat(inputString);
    }


}
