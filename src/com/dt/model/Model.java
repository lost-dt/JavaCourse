package com.dt.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;

public class Model {
    private Animal[] animals;

    public Model() {
        int sizeArrayAnimals = 20;
        animals = new Animal[sizeArrayAnimals];
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

        ArrayList<String> arrayVariables = new ArrayList<>(variablesNames.length);
        for(int i = 0; i < variablesNames.length; i++) {
            arrayVariables.add(variablesNames[i].getName());
        }

        return arrayVariables;
    }

    // get variables values by point of array animals
    public ArrayList<String> getArrayAnimalValue(int point) {

        ArrayList<String> value = new ArrayList<>();
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

    public void addAnimal(Map<String, String> newAnimalInfo, int pointArray) {

        Animal newAnimal = new Animal();

        newAnimal.setPhylumAnimal(newAnimalInfo.get("phylum"));
        newAnimal.setClassAnimal(newAnimalInfo.get("class"));
        newAnimal.setFamilyAnimal(newAnimalInfo.get("family"));
        newAnimal.setGenusAnimal(newAnimalInfo.get("genus"));
        newAnimal.setSpeciesAnimal(newAnimalInfo.get("species"));
        newAnimal.setSubspeciesAnimal(newAnimalInfo.get("subspecies"));
        newAnimal.setAgeAnimal(Float.parseFloat(newAnimalInfo.get("age")));
        newAnimal.setColorAnimal(newAnimalInfo.get("color"));

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
