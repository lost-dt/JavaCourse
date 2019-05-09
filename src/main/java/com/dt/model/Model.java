package com.dt.model;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Model {

    private static final Logger log = Logger.getLogger(Model.class);

    private Animal[] animals;

    public Model() {
        int sizeArrayAnimals = 20;
        animals = new Animal[sizeArrayAnimals];
        log.info("Model object was created.");
    }

    public Model(int sizeArrayAnimals) {
        animals = new Animal[sizeArrayAnimals];
    }

    // set and get variables by point of array
    public void setAnimalPlylum(int point, String animalPhylum) {this.animals[point].setPhylumAnimal(animalPhylum);}

    public String getAnimalPhylum(int point) {return this.animals[point].getPhylumAnimal();}


    public void setAnimalClass(int point, String animalClass) {this.animals[point].setClassAnimal(animalClass);}

    public String getAnimalClass(int point) {return this.animals[point].getClassAnimal();}


    public void setAnimalFamily(int point, String animalFamily) {this.animals[point].setFamilyAnimal(animalFamily);}

    public String getAnimalFamily(int point) {return this.animals[point].getFamilyAnimal();}


    public void setAnimalGenus(int point, String animalGenus) {this.animals[point].setGenusAnimal(animalGenus);}

    public String getAnimalGenus(int point) {return this.animals[point].getGenusAnimal();}


    public void setAnimalSpecies(int point, String animalSpecies) {this.animals[point].setSpeciesAnimal(animalSpecies);}

    public String getAnimalSpecies(int point) {return this.animals[point].getSpeciesAnimal();}


    public void setAnimalSubspecies(int point, String animalSubspecies) {this.animals[point].setSubspeciesAnimal(animalSubspecies);}

    public String getAnimalSubspecies(int point) {return this.animals[point].getSubspeciesAnimal();}


    public void setAnimalAge(int point, Float animalAge) {this.animals[point].setAgeAnimal(animalAge);}

    public Float getAnimalAge(int point) {return this.animals[point].getAgeAnimal();}


    public void setAnimalColor(int point, String animalColor) {this.animals[point].setColorAnimal(animalColor);}

    public String getAnimalColor(int point) {return this.animals[point].getColorAnimal();}

    // get variable names of class Animals
    public ArrayList<String> getAnimalNameVariables() {

        Field[] variablesNames = Animal.class.getDeclaredFields();

        ArrayList<String> arrayVariables = new ArrayList<String>(variablesNames.length);
        for(int i = 0; i < variablesNames.length; i++) {
            arrayVariables.add(variablesNames[i].getName());
        }

        return arrayVariables;
    }

    // get variables values by point of array animals
    public ArrayList<String> getArrayAnimalValue(int point) {

        ArrayList<String> value = new ArrayList<String>();
        value.add(this.animals[point].getPhylumAnimal());
        value.add(this.animals[point].getClassAnimal());
        value.add(this.animals[point].getFamilyAnimal());
        value.add(this.animals[point].getGenusAnimal());
        value.add(this.animals[point].getSpeciesAnimal());
        value.add(this.animals[point].getSubspeciesAnimal());
        value.add(Float.toString(this.animals[point].getAgeAnimal()));
        value.add(this.animals[point].getColorAnimal());

        return value;
    }

    public String[] getAnimalsInfoMapFormat(int sizeModel) {

         String[] mapAnimalValues = new String[sizeModel];


        for(int i = 0; i < sizeModel; i ++) {

            String animalInfo = String.format("%s|%s|%s|%s|%s|%s|%s|%s\n",
                    this.animals[i].getPhylumAnimal(), animals[i].getClassAnimal(), animals[i].getFamilyAnimal(), animals[i].getGenusAnimal(),
                    animals[i].getSpeciesAnimal(), animals[i].getSubspeciesAnimal(), animals[i].getAgeAnimal(), animals[i].getColorAnimal());

            mapAnimalValues[i] = animalInfo;

        }

        return mapAnimalValues;

    }

    public void addAnimal(String newAnimalInfo, int pointArray) {

        String[] valueSplit = newAnimalInfo.split("\\|");

        Animal newAnimal = new Animal();

        newAnimal.setPhylumAnimal(valueSplit[0]);
        newAnimal.setClassAnimal(valueSplit[1]);
        newAnimal.setFamilyAnimal(valueSplit[2]);
        newAnimal.setGenusAnimal(valueSplit[3]);
        newAnimal.setSpeciesAnimal(valueSplit[4]);
        newAnimal.setSubspeciesAnimal(valueSplit[5]);
        newAnimal.setAgeAnimal(Float.parseFloat(valueSplit[6]));
        newAnimal.setColorAnimal(valueSplit[7]);

        this.animals[pointArray] = newAnimal;

    }

    public boolean checkOlderThenByPoint(int point, float queryAge) {

        boolean resultCheck = false;

        if(this.animals[point].checkOlderThen(queryAge)) {

            resultCheck = true;
        }

        return resultCheck;
    }

    public boolean checkEqualFamilyByPoint(int point, String queryFamily) {

        boolean resultCheck = false;

        if(this.animals[point].checkEqualFamily(queryFamily)) {

            resultCheck = true;
        }

        return resultCheck;

    }

    public boolean checkEqualSpeciesByPoint(int point, String querySpecies) {

        boolean resultCheck = false;

        if(this.animals[point].checkEqualSpecies(querySpecies)) {

            resultCheck = true;
        }

        return resultCheck;
    }

    public boolean checkEqualColorByPoint(int point, String color) {

        boolean resultCheck = false;

        if(this.animals[point].checkEqualColor(color)) {

            resultCheck = true;
        }

        return resultCheck;
    }

}
