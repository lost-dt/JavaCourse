package com.dt.input.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class TextFileStream {

    private final String pathToFile;


    public TextFileStream(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    private int readLenArray() {
        int sizeOfArrayAnimals = 0;
        BufferedReader br = null;
        FileReader fr = null;

        try {

            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new FileReader(pathToFile);
            br = new BufferedReader(fr);

            String sCurrentLine = br.readLine();
            sizeOfArrayAnimals = Integer.parseInt(sCurrentLine);


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
        return sizeOfArrayAnimals;
    }

    public String[] animalsFromFile() {

        int sizeOfArrayAnimals = this.readLenArray();

        String[] animalsInfo = new String[sizeOfArrayAnimals];
        BufferedReader br = null;
        FileReader fr = null;

        try {

            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new FileReader(pathToFile);
            br = new BufferedReader(fr);

            String sCurrentLine;

            sCurrentLine = br.readLine();
            int sizeOfArray = Integer.parseInt(sCurrentLine);

            animalsInfo = new String[sizeOfArray];
            int countArray = 0;

            while ((sCurrentLine = br.readLine()) != null) {

                animalsInfo[countArray++] = sCurrentLine;
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

        return animalsInfo;

    }

    public void animalsToFile(String[] animalsInfo, int sizeAnimals) {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            fw = new FileWriter(this.pathToFile);
            bw = new BufferedWriter(fw);

            bw.write(sizeAnimals + "\n");

            for(String animalInfo : animalsInfo) {

                String[] valueSplit = animalInfo.split("\\|");

                bw.write(String.format("%s|%s|%s|%s|%s|%s|%s|%s",
                        valueSplit[0], valueSplit[1], valueSplit[2], valueSplit[3],
                        valueSplit[4], valueSplit[5], Float.parseFloat(valueSplit[6]), valueSplit[7]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
