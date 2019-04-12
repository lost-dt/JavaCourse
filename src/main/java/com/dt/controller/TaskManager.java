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
            int key = controller.readKeyFromConsole(1, 8);
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
                    controller.createAnimalsFromTextFile();
                    break;
                }
                case 4: {
                    controller.writeAnimalsToTextFile();
                    break;
                }
                case 5: {
                    controller.createAnimalsFromJsonFile();
                    break;
                }
                case 6: {
                    controller.writeAnimalsToJsonFile();
                    break;
                }
                case 7: {
                    startMenu(controller);
                    break;
                }
                case 8: {
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
