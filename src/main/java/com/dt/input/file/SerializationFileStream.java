package com.dt.input.file;

import org.apache.log4j.Logger;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SerializationFileStream {

    private static final Logger log = Logger.getLogger(SerializationFileStream.class);

    private final String pathToFile;

    public SerializationFileStream(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public String[] animalsFromFile() {


        String[] animals = new String[1000];
        int arrayCount = 0;
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        BufferedReader br = null;
        FileReader fr = null;

        try {

            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new FileReader(pathToFile);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {

                JSONObject animalInfo = new JSONObject();

                try {
                    animalInfo = (JSONObject) jsonParser.parse(sCurrentLine);
                } catch (ParseException e) {
                    e.printStackTrace();
                    log.error(e);
                }


                String oneAnimalInfo = String.format("%s|%s|%s|%s|%s|%s|%s|%sn",
                        (String) animalInfo.get("phylum"), (String) animalInfo.get("class"), (String) animalInfo.get("family"), (String) animalInfo.get("genus"),
                        (String) animalInfo.get("species"), (String) animalInfo.get("subspecies"), (String) animalInfo.get("age"), (String) animalInfo.get("color"));


                animals[arrayCount++] = oneAnimalInfo;

            }

        } catch (IOException e) {

            e.printStackTrace();
            log.error(e);

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();
                log.error(ex);
            }

        }

        String[] resultAnimalInfo = new String[arrayCount - 1];
        for(int i = 0; i < arrayCount - 1; i++) {
            resultAnimalInfo[i] = animals[i];
        }

        return resultAnimalInfo;

    }

    public void animalsToFile(String[] animalsInfo) {


        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            fw = new FileWriter(this.pathToFile);
            bw = new BufferedWriter(fw);

            for(String animalInfo: animalsInfo) {
                animalInfo = animalInfo.replace("\n", "");

                String[] valueSplit = animalInfo.split("\\|");

                JSONObject animalJson = new JSONObject();

                animalJson.put("phylum", valueSplit[0]);
                animalJson.put("class", valueSplit[1]);
                animalJson.put("family", valueSplit[2]);
                animalJson.put("genus", valueSplit[3]);
                animalJson.put("species", valueSplit[4]);
                animalJson.put("subspecies", valueSplit[5]);
                animalJson.put("age", valueSplit[6]);
                animalJson.put("color", valueSplit[7]);
                bw.write(String.format("%s\n", animalJson.toJSONString()));

            }

        } catch (IOException e) {

            e.printStackTrace();
            log.error(e);

        } finally {
            try {
                if (bw != null)

                    bw.close();

                if (fw != null)

                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();
                log.error(ex);
            }
        }


    }

}