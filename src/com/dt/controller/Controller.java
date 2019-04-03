package com.dt.controller;

import com.dt.model.Model;
import com.dt.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Controller {
    private Model model;
    private View view;
    // variable to more in array
    private int pointArray = 0;

    public Controller() {
        model = new Model();
        view = new View();
    }

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public Controller(int sizeArrayAnimals) {
        model = new Model(sizeArrayAnimals);
        view = new View();
    }


    public void setAnimalPlylum(int point, String animalPhylum) {this.model.setAnimalPlylum(point, animalPhylum);}

    public String getAnimalPhylum(int point) {return this.model.getAnimalPhylum(point);}


    public void setAnimalClass(int point, String animalClass) {this.model.setAnimalClass(point, animalClass);}

    public String getAnimalClass(int point) {return this.model.getAnimalClass(point);}


    public void setAnimalFamily(int point, String animalFamily) {this.model.setAnimalFamily(point, animalFamily);}

    public String getAnimalFamily(int point) {return this.model.getAnimalFamily(point);}


    public void setAnimalGenus(int point, String animalGenus) {this.model.setAnimalGenus(point, animalGenus);}

    public String getAnimalGenus(int point) {return this.model.getAnimalGenus(point);}


    public void setAnimalSpecies(int point, String animalSpecies) {this.model.setAnimalSpecies(point, animalSpecies);}

    public String getAnimalSpecies(int point) {return this.model.getAnimalSpecies(point);}


    public void setAnimalSubspecies(int point, String animalSubspecies) {this.model.setAnimalSubspecies(point, animalSubspecies);}

    public String getAnimalSubspecies(int point) {return this.model.getAnimalSubspecies(point);}


    public void setAnimalAge(int point, Float animalAge) {this.model.setAnimalAge(point, animalAge);}

    public Float getAnimalAge(int point) {return this.model.getAnimalAge(point);}


    public void setAnimalColor(int point, String animalColor) {this.model.setAnimalColor(point, animalColor);}

    public String getAnimalColor(int point) {return this.model.getAnimalColor(point);}


    private public void updateAllView(){

        ArrayList<String> arrayVariables = this.model.getAnimalNameVariables();

        ArrayList<ArrayList<String>> values = new ArrayList<>(arrayVariables.size());

        for(int i = 0; i < this.pointArray; i++) {

            ArrayList<String> value = this.model.getArrayAnimalValue(i);

            values.add(value);
        }

        this.view.printAnimalsInfo(arrayVariables, values);
    }

    public void updateViewByAnimal(int point){
        // get variables names
        ArrayList<String> arrayVariables = this.model.getAnimalNameVariables();

        ArrayList<String> value = this.model.getArrayAnimalValue(point);

        this.view.printAnimalInfo(arrayVariables, value);
    }

    void addAnimalFromConsole() {

        Map<String, String> newAnimalInfo = this.view.createAnimalFromConsole();

        this.model.addAnimal(newAnimalInfo, this.pointArray);

        this.pointArray ++;

    }

    public void startMenu() {

        TaskManager.startMenu(this);

    }

    void printWorkInfo() {
        this.view.workInfo();
    }

    void printStartMenuMessage() {
        this.view.startMenuMessage();

    }

    int readKeyFromConsole(int start, int end) {
        return this.view.readKeyFromConsole(start, end);
    }

    boolean checkEmptyArrayAnimals() {
        boolean empty = true;
        if(this.pointArray > 0) {
            empty = false;
        }

        return empty;
    }

    void printEmptyListMessage() {
        this.view.emptyListMessage();
    }

    void printManipulationManagerMessage() {
        this.view.manipulationManagerMessage();
    }

    void printQueryMenuMessage() {
        this.view.queryMenuMessage();
    }

    Float getAgeQuery() {
        return this.view.getAgeQuery();
    }

    String getFamilyQuery() {
        return this.view.getFamilyQuery();
    }

    String getSpeciesQuery() {
        return this.view.getSpeciesQuery();
    }

    String getColorQuery() {
        return this.view.getColorQuery();
    }

    void showAnimalsInfo(){
        if (this.pointArray> 0) {
           this.updateAllView();
        }
        else {
            this.view.emptyListMessage();
        }

    }

    void createAnimalsFromFile(String pathToFile) {

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

                this.model.addAnimal(newAnimalInfo, this.pointArray);

                this.pointArray ++;

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

    }

    void getAndPrintOlderResult(Float queryAge) {

        ArrayList<ArrayList<String>> resultValues = new ArrayList<>();

        for(int i = 0; i < this.pointArray; i++) {
            if(this.model.checkOlderThenByPoint(i, queryAge)) {
                resultValues.add(this.model.getArrayAnimalValue(i));
            }
        }

        if(resultValues.size() > 0) {
            ArrayList<String> arrayVariables = this.model.getAnimalNameVariables();
            this.view.printAnimalsInfo(arrayVariables, resultValues);
        }
        else {
            this.view.emptyListMessage();
        }

    }

    void getAndPrintFamilyResult(String queryFamily) {

        ArrayList<ArrayList<String>> resultValues = new ArrayList<>();

        for(int i = 0; i < this.pointArray; i++) {
            if(this.model.checkEqualFamilyByPoint(i, queryFamily)) {
                resultValues.add(this.model.getArrayAnimalValue(i));
            }
        }


        if(resultValues.size() > 0) {
            ArrayList<String> arrayVariables = this.model.getAnimalNameVariables();
            this.view.printAnimalsInfo(arrayVariables, resultValues);
        }
        else {
            this.view.emptyListMessage();
        }

    }

    void getAndPrintSpeciesAndColorResult(String querySpecies, String color) {

        ArrayList<ArrayList<String>> resultValues = new ArrayList<>();

        for(int i = 0; i < this.pointArray; i++) {
            if(this.model.checkEqualSpeciesByPoint(i, querySpecies) && this.model.checkEqualColorByPoint(i, color)) {
                resultValues.add(this.model.getArrayAnimalValue(i));
            }
        }


        if(resultValues.size() > 0) {
            ArrayList<String> arrayVariables = this.model.getAnimalNameVariables();
            this.view.printAnimalsInfo(arrayVariables, resultValues);
        }
        else {
            this.view.emptyListMessage();
        }

    }

}
