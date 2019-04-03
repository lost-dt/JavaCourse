package com.dt.model;

public class Animal {
    private String phylumAnimal; // Тип
    private String classAnimal; // Клас
    private String familyAnimal; // Сімейство
    private String genusAnimal; // Рід
    private String speciesAnimal; // Вид
    private String subspeciesAnimal; // Підвид
    private Float ageAnimal; // Вік
    private String colorAnimal; // Окрас

    Animal() {

        this.phylumAnimal = "NONE";
        this.classAnimal = "NONE";
        this.familyAnimal = "NONE";
        this.genusAnimal = "NONE";
        this.speciesAnimal = "NONE";
        this.subspeciesAnimal = "NONE";
        this.ageAnimal = 0.0f;
        this.colorAnimal = "NONE";

    }

    public Animal(String phylumAnimal, String classAnimal, String familyAnimal, String genusAnimal,
                  String speciesAnimal, String subspeciesAnimal, Float ageAnimal, String colorAnimal) {

        this.phylumAnimal = phylumAnimal;
        this.classAnimal = classAnimal;
        this.familyAnimal = familyAnimal;
        this.genusAnimal = genusAnimal;
        this.speciesAnimal = speciesAnimal;
        this.subspeciesAnimal = subspeciesAnimal;
        this.ageAnimal = ageAnimal;
        this.colorAnimal = colorAnimal;
    }

    String getPhylumAnimal() {
        return phylumAnimal;
    }

    void setPhylumAnimal(String phylumAnimal) {
        this.phylumAnimal = phylumAnimal;
    }

    String getClassAnimal() {
        return classAnimal;
    }

    void setClassAnimal(String classAnimal) {
        this.classAnimal = classAnimal;
    }

    String getFamilyAnimal() {
        return familyAnimal;
    }

    void setFamilyAnimal(String familyAnimal) {
        this.familyAnimal = familyAnimal;
    }

    String getGenusAnimal() {
        return genusAnimal;
    }

    void setGenusAnimal(String genusAnimal) {
        this.genusAnimal = genusAnimal;
    }

    String getSpeciesAnimal() {
        return speciesAnimal;
    }

    void setSpeciesAnimal(String speciesAnimal) {
        this.speciesAnimal = speciesAnimal;
    }

    String getSubspeciesAnimal() {
        return subspeciesAnimal;
    }

    void setSubspeciesAnimal(String subspeciesAnimal) {
        this.subspeciesAnimal = subspeciesAnimal;
    }

    Float getAgeAnimal() {
        return ageAnimal;
    }

    void setAgeAnimal(Float ageAnimal) {
        this.ageAnimal = ageAnimal;
    }

    String getColorAnimal() {
        return colorAnimal;
    }

    void setColorAnimal(String colorAnimal) {
        this.colorAnimal = colorAnimal;
    }

    public String toString(){
        return String.format(
                "ANIMAL_INFO:\n\t" +
                        "phylum: %s\n\t" +
                        "class: %s\n\t" +
                        "family: %s\n\t" +
                        "genus: %s\n\t" +
                        "species: %s\n\t" +
                        "subspecies: %s\n\t" +
                        "age: %f\n\t" +
                        "color: %s\n\t",
                this.phylumAnimal, this.classAnimal, this.familyAnimal, this.genusAnimal,
                this.speciesAnimal, this.subspeciesAnimal, this.ageAnimal, this.colorAnimal);
    }

    boolean checkOlderThen(Float age) {

        boolean resultCheck = false;

        if (this.ageAnimal > age) {
            resultCheck = true;
        }
        return resultCheck;

    }

    boolean checkEqualFamily(String family) {

        boolean resultCheck = false;

        if(this.familyAnimal.equals(family)) {
            resultCheck = true;
        }
        return resultCheck;
    }

    boolean checkEqualSpecies(String species) {

        boolean resultCheck = false;

        if(this.speciesAnimal.equals(species)) {
            resultCheck = true;
        }
        return resultCheck;

    }

    boolean checkEqualColor(String color) {

        boolean resultCheck = false;

        if(this.colorAnimal.equals(color)) {
            resultCheck = true;
        }
        return resultCheck;

    }
}
