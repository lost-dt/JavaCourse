package com.dt.input;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SerializationFileStream {
    private final String pathToFile;

    public SerializationFileStream(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public ArrayList<Map<String, String>> animalsFromFile() {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        ArrayList<Map<String, String>> resultInfo = new ArrayList<Map<String, String>>(20);

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
                }

                Map<String, String> newAnimalInfo = new HashMap<String, String>();

                newAnimalInfo.put("phylum", (String) animalInfo.get("phylum"));
                newAnimalInfo.put("class", (String) animalInfo.get("class"));
                newAnimalInfo.put("family", (String) animalInfo.get("family"));
                newAnimalInfo.put("genus", (String) animalInfo.get("genus"));
                newAnimalInfo.put("species", (String) animalInfo.get("species"));
                newAnimalInfo.put("subspecies", (String) animalInfo.get("subspecies"));
                newAnimalInfo.put("age", (String) animalInfo.get("age"));
                newAnimalInfo.put("color", (String) animalInfo.get("color"));

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

            for(Map<String, String> animalInfo: animalsInfo) {
                JSONObject animalJson = new JSONObject();

                animalJson.put("phylum", animalInfo.get("phylum"));
                animalJson.put("class", animalInfo.get("class"));
                animalJson.put("family", animalInfo.get("family"));
                animalJson.put("genus", animalInfo.get("genus"));
                animalJson.put("species", animalInfo.get("species"));
                animalJson.put("subspecies", animalInfo.get("subspecies"));
                animalJson.put("age", animalInfo.get("age"));
                animalJson.put("color", animalInfo.get("color"));
                bw.write(String.format("%s\n", animalJson.toJSONString()));

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