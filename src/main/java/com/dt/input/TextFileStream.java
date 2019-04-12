package com.dt.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class TextFileStream {

    private final String pathToFile;


    public TextFileStream(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public ArrayList<Map<String, String>> animalsFromFile() {

        ArrayList<Map<String, String>> resultInfo = new ArrayList<Map<String, String>>(20);

        BufferedReader br = null;
        FileReader fr = null;

        try {

            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new FileReader(pathToFile);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {


                String[] value_split = sCurrentLine.split("\\|");

                Map<String, String> newAnimalInfo = new HashMap<String, String>();

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

    public void animalsToFile(ArrayList<Map<String, String>> animalsInfo) {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            fw = new FileWriter(this.pathToFile);
            bw = new BufferedWriter(fw);

            for(Map<String, String> animalInfo : animalsInfo) {
                bw.write(String.format("%s|%s|%s|%s|%s|%s|%f|%s\n",
                        animalInfo.get("phylum"), animalInfo.get("class"), animalInfo.get("family"), animalInfo.get("genus"),
                        animalInfo.get("species"), animalInfo.get("subspecies"), Float.parseFloat(animalInfo.get("age")), animalInfo.get("color")));
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        } finally {
            try {
                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                System.err.format("IOException: %s%n", ex);
            }
        }
    }
}
