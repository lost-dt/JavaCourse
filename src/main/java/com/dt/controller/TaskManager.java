package com.dt.controller;

import org.apache.log4j.Logger;

public class TaskManager {
    private static final Logger log = Logger.getLogger(TaskManager.class);

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
                    return;
                }
                case 2: {
                    if(!controller.checkEmptyArrayAnimals()) {
                        queryMenu(controller);
                    }
                    else {
                        controller.printEmptyListMessage();
                    }
                    return;
                }
                case 3: {
                    controller.showAnimalsInfo();
                    break;
                }
                case 4: {
                    return;

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
                    log.info("Add animal to model (from console).");
                    break;
                }
                case 3: {
                    controller.createAnimalsFromTextFile();
                    log.info("Add animals to model (from text file).");
                    break;
                }
                case 4: {
                    controller.writeAnimalsToTextFile();
                    log.info("Write animals to text file.");
                    break;
                }
                case 5: {
                    controller.createAnimalsFromJsonFile();
                    log.info("Add animals to model (from Json file).");
                    break;
                }
                case 6: {
                    controller.writeAnimalsToJsonFile();
                    log.info("Write animals to Json file.");
                    break;
                }
                case 7: {
                    startMenu(controller);
                    return;
                }
                case 8: {
                    return;
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
                    log.info("Query was finished successful (Older than query).");
                    break;
                }
                case 3: {
                    String queryFamily = controller.getFamilyQuery();
                    controller.getAndPrintFamilyResult(queryFamily);
                    log.info("Query was finished successful (Family query).");
                    break;
                }
                case 4: {
                    String species = controller.getSpeciesQuery();
                    String color = controller.getColorQuery();
                    controller.getAndPrintSpeciesAndColorResult(species, color);
                    log.info("Query was finished successful (Species ANd Color query).");
                    break;
                }
                case 5: {
                    startMenu(controller);
                    return;
                }
                case 6: {
                    return;
                }

            }

        }

    }
}
