package com.dt.controller;

import com.dt.input.file.SerializationFileStream;
import com.dt.input.file.TextFileStream;
import com.dt.model.Model;
import com.dt.view.View;
import org.apache.log4j.Logger;

import java.util.ArrayList;


public class Controller {

    private static final Logger log = Logger.getLogger(Controller.class);


    private Model model;
    private View view;

    private TextFileStream textFileStream = new TextFileStream("/Users/x/Documents/JavaCourse/input/AnimalInfoFile/AnimalTextFormat.txt");
    private SerializationFileStream serializationFileStream = new SerializationFileStream("/Users/x/Documents/JavaCourse/input/AnimalInfoFile/AnimalSerializationFormat.txt");
    // variable to more in array
    private int pointArray = 0;
    private int maxSizeAnimals;

    public Controller() {
        model = new Model();
        view = new View();
        maxSizeAnimals = 100;
        log.info("Controller object was created.");
    }

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        maxSizeAnimals = 100;
        log.info("Controller object was created.");
    }

    public Controller(int sizeArrayAnimals) {
        maxSizeAnimals = sizeArrayAnimals - 1;
        model = new Model(sizeArrayAnimals);
        view = new View();
        log.info("Controller object was created.");
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


    private void updateAllView(){

        ArrayList<String> arrayVariables = this.model.getAnimalNameVariables();

        ArrayList<ArrayList<String>> values = new ArrayList<ArrayList<String>>(arrayVariables.size());

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

        String newAnimalInfo = this.view.createAnimalFromConsole();

        this.model.addAnimal(newAnimalInfo, this.pointArray);

        if(this.pointArray > this.maxSizeAnimals - 1) {
            this.view.printMessage("Sorry, but size of animals max now!");
            log.warn("Try add animal to max filled model.");
        }
        else {

            this.pointArray++;
        }

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
        this.view.printMessage("List of Animals in empty.");
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
            this.view.printMessage("List of Animals in empty.");
        }

    }

    void createAnimalsFromTextFile() {

        String[] animalInfo = textFileStream.animalsFromFile();

        for(String item : animalInfo) {

            this.model.addAnimal(item, this.pointArray);

            if(this.pointArray > this.maxSizeAnimals - 1) {
                this.view.printMessage("Sorry, but array of animals have max size now!");
                log.warn("Try add animal to max filled model.");
                break;
            }
            else {

                this.pointArray++;
            }

        }

    }

    void writeAnimalsToTextFile() {

        String[] animalsInfoMapFormat = this.model.getAnimalsInfoMapFormat(this.pointArray);

        textFileStream.animalsToFile(animalsInfoMapFormat, this.pointArray);

    }

    void createAnimalsFromJsonFile() {
        String[] animalInfo = serializationFileStream.animalsFromFile();

        for(int i = 0; i < animalInfo.length - 2; i ++) {

            this.model.addAnimal(animalInfo[i], this.pointArray);

            if(this.pointArray > this.maxSizeAnimals - 1) {
                this.view.printMessage("Sorry, but size of animals max now!");
                log.warn("Try add animal to max filled model.");
                break;
            }
            else {

                this.pointArray++;
            }

        }

    }

    void writeAnimalsToJsonFile() {

        String[] animalsInfoMapFormat = this.model.getAnimalsInfoMapFormat(this.pointArray);

        serializationFileStream.animalsToFile(animalsInfoMapFormat);
    }

    void getAndPrintOlderResult(Float queryAge) {

        ArrayList<ArrayList<String>> resultValues = new ArrayList<ArrayList<String>>();

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
            this.view.printMessage("List of Animals in empty.");
        }

    }

    void getAndPrintFamilyResult(String queryFamily) {

        ArrayList<ArrayList<String>> resultValues = new ArrayList<ArrayList<String>>();

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
            this.view.printMessage("List of Animals in empty.");
        }

    }

    void getAndPrintSpeciesAndColorResult(String querySpecies, String color) {

        ArrayList<ArrayList<String>> resultValues = new ArrayList<ArrayList<String>>();

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
            this.view.printMessage("List of Animals in empty.");
        }

    }

}
