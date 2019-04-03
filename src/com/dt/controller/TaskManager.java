package com.dt.controller;

public class TaskManager {

    public TaskManager() {

    }

    static void startMenu(Controller controller) {
        controller.printWorkInfo();

        while (true) {
            controller.printStartMenuMessage();
            int key = controller.readKeyFromConsole(1, 4);
            switch (key) {
                case 1: {
                    manipulationManager(controller);
                    break;
                }
                case 2: {
                    if(!controller.checkEmptyArrayAnimals()) {
                        queryMenu(controller);
                    }
                    else {
                        controller.printEmptyListMessage();
                    }
                    break;
                }
                case 3: {
                    controller.showAnimalsInfo();
                    break;
                }
                case 4: {
                    System.exit(0);
                    break;
                }

            }

        }
    }

    private static void manipulationManager(Controller controller) {
        while (true) {
            controller.printManipulationManagerMessage();
            int key = controller.readKeyFromConsole(1, 5);
            switch (key) {
                case 1: {
                    controller.showAnimalsInfo();
                    break;
                }
                case 2: {
                    controller.addAnimalFromConsole();
                    break;
                }
                case 3: {
                    controller.createAnimalsFromFile("C:\\Users\\lost\\IdeaProjects\\JavaCourse\\input\\AnimalInfoFile\\AnimalInputFile.txt");
                    break;
                }
                case 4: {
                    startMenu(controller);
                }
                case 5: {
                    System.exit(0);
                    break;
                }

            }
        }
    }

    private static void queryMenu(Controller controller) {
        while (true) {
            controller.printQueryMenuMessage();
            int key = controller.readKeyFromConsole(1, 6);
            switch (key) {
                case 1: {
                    controller.showAnimalsInfo();
                    break;
                }
                case 2: {
                    Float queryAge = controller.getAgeQuery();
                    controller.getAndPrintOlderResult(queryAge);
                    break;
                }
                case 3: {
                    String queryFamily = controller.getFamilyQuery();
                    controller.getAndPrintFamilyResult(queryFamily);

                    break;
                }
                case 4: {
                    String species = controller.getSpeciesQuery();
                    String color = controller.getColorQuery();
                    controller.getAndPrintSpeciesAndColorResult(species, color);
                    break;
                }
                case 5: {
                    startMenu(controller);
                    break;
                }
                case 6: {
                    System.exit(0);
                    break;
                }

            }

        }

    }
}
