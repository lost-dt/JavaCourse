package com.dt.view;


import com.dt.utils.TablePrinter;
import com.dt.input.console.ConsoleStream;
import com.dt.input.errors.UncorrectedKey;
import com.dt.input.errors.InputValidator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class View {
    private static final Logger log = Logger.getLogger(View.class);
    public View() {
        log.info("View object was created.");
    }

    public void printAnimalInfo(ArrayList<String> field, ArrayList<String> row) {
        TablePrinter table = new TablePrinter(field);
        table.addRow(row);

        table.print();
    }

    public void printAnimalsInfo(ArrayList<String> field, ArrayList<ArrayList<String>> rows) {
        TablePrinter table = new TablePrinter(field);
        for(ArrayList<String> row : rows) {
            table.addRow(row);
        }

        table.print();
    }

    public String createAnimalFromConsole() {

        String mapAnimalValues = "";

        System.out.println("Enter phylum of an animal: ");
        mapAnimalValues += ConsoleStream.stringFromConsole() + "|";



        System.out.println("Enter class of an animal: ");
        mapAnimalValues += ConsoleStream.stringFromConsole() + "|";



        System.out.println("Enter family of an animal: ");
        mapAnimalValues += ConsoleStream.stringFromConsole() + "|";



        System.out.println("Enter genus of an animal: ");
        mapAnimalValues += ConsoleStream.stringFromConsole() + "|";



        System.out.println("Enter species of an animal");
        mapAnimalValues += ConsoleStream.stringFromConsole() + "|";



        System.out.println("Enter subspecies of an animal");
        mapAnimalValues += ConsoleStream.stringFromConsole() + "|";



        System.out.println("Enter age of an animal");
        mapAnimalValues += Float.toString(ConsoleStream.floatFromConsole())+ "|";


        System.out.println("Enter color of an animal");
        mapAnimalValues += ConsoleStream.stringFromConsole() + "|";


        this.cleanConsole();

        return mapAnimalValues;

    }


    public void workInfo() {
        System.out.println("\t\t\tLab_1\n\tTsylyuryk_Dmytro_IS_72\n\n");

    }

    public void printMessage(String message) {
        System.out.println(message + "\n");
    }

    public void startMenuMessage() {
        System.out.println("\t1. Manipulation on List of Animals.");
        System.out.println("\t2. Do task query.");
        System.out.println("\t3. Show List of Animals.");
        System.out.println("\t4. Exit");

    }

    public int readKeyFromConsole(int start, int end){
        int resultKey;
        String inputString;
        do {
            System.out.println("Write key number: ");
            try {

                inputString = ConsoleStream.stringFromConsole();
                InputValidator.validationIntNumber(inputString);

                resultKey = Integer.parseInt(inputString);
                InputValidator.validationIntKey(resultKey, start, end);
                break;

            } catch (UncorrectedKey e) {
                System.out.println("Please, try again!");
            }

        } while (true);

        this.cleanConsole();

        return resultKey;

    }

    private void cleanConsole() {
        for(int i = 0; i < 1000; i++) {
            System.out.println("\b");
        }
    }

    public void manipulationManagerMessage() {
        System.out.println("\t1. Show List of Animals.");
        System.out.println("\t2. Add node from console.");
        System.out.println("\t3. Read Animals from text formatted file.");
        System.out.println("\t4. Write Animals to text formatted file.");
        System.out.println("\t5. Read Animals from JSON formatted file.");
        System.out.println("\t6. Write Animals to JSON formatted file.");
        System.out.println("\t7. Go back");
        System.out.println("\t8. Exit");
    }

    public void queryMenuMessage() {
        System.out.println("\t1. Show List of Animals.");
        System.out.println("\t2. Get a list of all the animals older than the given age.");
        System.out.println("\t3. Get a list of animals given family.");
        System.out.println("\t4. Get a list of animals given phylum and color.");
        System.out.println("\t5. Go back");
        System.out.println("\t6. Exit");
    }

    public float getAgeQuery() {
        System.out.println("Write age: ");

        return ConsoleStream.floatFromConsole();
    }

    public String getFamilyQuery() {
        System.out.println("Write family: ");

        return ConsoleStream.stringFromConsole();
    }

    public String getSpeciesQuery() {
        System.out.println("Write species: ");

        return ConsoleStream.stringFromConsole();
    }

    public String getColorQuery() {
        System.out.println("Write color: ");

        return ConsoleStream.stringFromConsole();
    }
}
