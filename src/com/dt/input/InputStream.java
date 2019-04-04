package com.dt.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputStream {

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

    public static ArrayList<Map<String, String>> animalInfoFromFile(String pathToFile) {

        ArrayList<Map<String, String>> resultInfo = new ArrayList<>(20);

        BufferedReader br = null;
        FileReader fr = null;

        try {

            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new FileReader(pathToFile);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {


                String[] value_split = sCurrentLine.split("\\|");

                Map<String, String> newAnimalInfo = new HashMap<>();

                newAnimalInfo.put("phylum", value_split[0]);
                newAnimalInfo.put("class", value_split[1]);
                newAnimalInfo.put("family", value_split[2]);
                newAnimalInfo.put("genus", value_split[3]);
                newAnimalInfo.put("species", value_split[4]);
                newAnimalInfo.put("subspecies", value_split[5]);
                newAnimalInfo.put("age", value_split[6]);
                newAnimalInfo.put("color", value_split[7]);

                resultInfo.add(newAnimalInfo);

            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

        return resultInfo;

    }
}
