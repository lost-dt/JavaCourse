package com.dt.view;


import com.dt.utils.TablePrinter;
import com.dt.input.InputStream;
import com.dt.input.UncorrectedKey;
import com.dt.input.InputValidator;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class View {
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

    public Map<String, String>  createAnimalFromConsole() {

        Map<String, String> mapAnimalValues = new HashMap<>();

        System.out.println("Enter phylum of an animal: ");
        mapAnimalValues.put("phylum", InputStream.stringFromConsole());


        System.out.println("Enter class of an animal: ");
        mapAnimalValues.put("class", InputStream.stringFromConsole());


        System.out.println("Enter family of an animal: ");
        mapAnimalValues.put("family", InputStream.stringFromConsole());


        System.out.println("Enter genus of an animal: ");
        mapAnimalValues.put("genus", InputStream.stringFromConsole());


        System.out.println("Enter species of an animal");
        mapAnimalValues.put("species", InputStream.stringFromConsole());


        System.out.println("Enter subspecies of an animal");
        mapAnimalValues.put("subspecies", InputStream.stringFromConsole());


        System.out.println("Enter age of an animal");
        mapAnimalValues.put("age", Float.toString(InputStream.floatFromConsole()));

        System.out.println("Enter color of an animal");
        mapAnimalValues.put("color", InputStream.stringFromConsole());

        this.cleanConsole();

        return mapAnimalValues;

    }

    public void emptyListMessage() {
        System.out.println("List of Animals in empty.");
    }



    public void workInfo() {
        System.out.println("\t\t\tLab_1\n\tTsylyuryk_Dmytro_IS_72\n\n");

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

                inputString = InputStream.stringFromConsole();
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
        System.out.println("\t3. Read Animals from file (quickly).");
        System.out.println("\t4. Go back");
        System.out.println("\t5. Exit");
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

        return InputStream.floatFromConsole();
    }

    public String getFamilyQuery() {
        System.out.println("Write family: ");

        return InputStream.stringFromConsole();
    }

    public String getSpeciesQuery() {
        System.out.println("Write species: ");

        return InputStream.stringFromConsole();
    }

    public String getColorQuery() {
        System.out.println("Write color: ");

        return InputStream.stringFromConsole();
    }
}
