package com.dt.view;


import com.dt.utils.TablePrinter;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);

        Map<String, String> mapAnimalValues = new HashMap<>();

        System.out.println("Enter phylum of an animal: ");
        mapAnimalValues.put("phylum", scanner.nextLine());


        System.out.println("Enter class of an animal: ");
        mapAnimalValues.put("class", scanner.nextLine());


        System.out.println("Enter family of an animal: ");
        mapAnimalValues.put("family", scanner.nextLine());


        System.out.println("Enter genus of an animal: ");
        mapAnimalValues.put("genus", scanner.nextLine());


        System.out.println("Enter species of an animal");
        mapAnimalValues.put("species", scanner.nextLine());


        System.out.println("Enter subspecies of an animal");
        mapAnimalValues.put("subspecies", scanner.nextLine());


        System.out.println("Enter age of an animal");
        mapAnimalValues.put("age", Float.toString(scannerFloat()));

        System.out.println("Enter color of an animal");
        mapAnimalValues.put("color", scanner.nextLine());

        this.cleanConsole();

        return mapAnimalValues;

    }

    public void emptyListMessage() {
        System.out.println("List of Animals in empty.");
    }

    private Float scannerFloat() {

        Scanner scanner = new Scanner(System.in);

        Float result = 0.0f;
        boolean correct;
        do {
            try {

                result = Float.parseFloat(scanner.nextLine());
                correct = true;

            } catch (NumberFormatException e) {
                correct = false;
                System.out.println("Please, try again!");
            }
        } while (!correct);
        return result;
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
        int resultKey = -1;

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Write key number: ");
            try {


                resultKey = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Please, try again!");
            }


        } while (resultKey > end || resultKey < start);

        this.cleanConsole();
//        scanner.close();

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
        System.out.println("\t4. Get a list of animals given type and color.");
        System.out.println("\t5. Go back");
        System.out.println("\t6. Exit");
    }

    public Float getAgeQuery() {
        System.out.println("Write age: ");

        return this.scannerFloat();
    }

    public String getFamilyQuery() {
        System.out.println("Write family: ");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public String getSpeciesQuery() {
        System.out.println("Write species: ");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public String getColorQuery() {
        System.out.println("Write color: ");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }
}
