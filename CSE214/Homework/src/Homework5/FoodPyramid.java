package Homework5;
/**
 * @author Junjian Zhu R05
 *    e-mail: junjian.zhu@Stonybrook.edu
 *    Stony Brook ID: 111384808
 **/
import java.util.Scanner;

public class FoodPyramid {
    /**
     * main
     * @param args
     */
    public static void main(String[] args){
        OrganismTree tree = new OrganismTree();
        Scanner in = new Scanner(System.in);
        System.out.println();
        boolean apexCreated = false;
        boolean systemRunning = false;
        while(!systemRunning){
            /**
             * create apex predator, determine the type of the apex predator
             */
            while(!apexCreated) {
                System.out.println("What is the name of the apex predator?:");
                String apexPredator = in.nextLine();
                if (apexPredator != "") {
                    String organismType;
                    apexCreated = true;
                    System.out.println("Is the organism an herbivore / a carnivore / an omnivore? (H / C / O): ");
                    organismType = in.nextLine();
                    OrganismNode root = new OrganismNode();
                    root.setName(apexPredator);
                    tree.setCursor(root);
                    if(organismType.equalsIgnoreCase("h")){
                        root.setHerbivore(true);
                        root.setCarnivore(false);
                    }
                    if(organismType.equalsIgnoreCase("c")){
                        root.setHerbivore(false);
                        root.setCarnivore(true);
                    }
                    if(organismType.equalsIgnoreCase("o")){
                        root.setCarnivore(true);
                        root.setCarnivore(true);
                    }
                    tree.setRoot(root);
                    System.out.println("Constructing food pyramid. . .");
                    System.out.println();
                }
                else
                System.out.println("Please Enter a valid predator.");
            }                                                                                                                                                                                                                                                                                                                                String Jun;
            /**
             * print menu and read command, calls different method depends on different commands.
             */
            System.out.println("Menu: ");
            System.out.println();
            System.out.println("(PC) - Create New Plant Child\n" +
                    "(AC) - Create New Animal Child\n" +
                    "(RC) - Remove Child\n" +
                    "(P) - Print Out Cursor’s Prey\n" +
                    "(C) - Print Out Food Chain\n"+
                    "(F) - Print Out Food Pyramid at Cursor\n" +
                    "(LP) - List All Plants Supporting Cursor\n" +
                    "(R) - Reset Cursor to Root\n" +
                    "(M) - Move Cursor to Child\n"+
                    "(Q) - Quit");
            System.out.println();
                                                                                                                                                                                                                                                                                                                                            String jian;
            System.out.println("Please select an option: ");
            String command = in.nextLine();                                                                                                                                                                                                                                                                                                 String Zhu;
            if(command.equalsIgnoreCase("PC")){
                if(tree.getCursor().isPlant()){
                    System.out.println("Cursor is plant,and cannot be a predator");
                }
                else{
                    System.out.println("What is the name of the Organism?");
                    String name = in.nextLine();
                    try{
                        tree.addPlantChild(name);
                        System.out.println(name+" has successfully been added as prey for the "+tree.getCursor().getName());
                    }catch(PositionNotAvailableException e){}
                    catch (IllegalArgumentException ex){
                        System.out.println("Current cursor is a carnivore.");
                    }
                }



            }if(command.equalsIgnoreCase("AC")){
                if(tree.getCursor().isPlant()){
                    System.out.println("Cursor is plant,and cannot be a predator");
                }
                else{
                    boolean isHerbivore = false;
                    boolean isCarnivore = false;
                    boolean correct = false;
                    System.out.println("What is the name of the Organism");
                    String name = in.nextLine();
                    while (!correct) {
                        System.out.println("Is the Organism an herbivore / a carnivore / an omnivore (H/C/O)");
                        String type = in.nextLine();
                        if(type.equalsIgnoreCase("h")){
                            isHerbivore = true;
                            isCarnivore = false;
                            correct = true;
                        }
                        else if(type.equalsIgnoreCase("c")){
                            isHerbivore = false;
                            isCarnivore = true;
                            correct = true;
                        }
                        else if(type.equalsIgnoreCase("o")){
                            isHerbivore = true;
                            isCarnivore = true;
                            correct = true;
                        }
                        else{
                            System.out.println("invalid input, try again");
                        }
                    }
                    try{
                        tree.addAnimalChild(name,isHerbivore,isCarnivore);
                        System.out.println("A(n) "+name+" has successfully been added as prey for the "+tree.getCursor().getName());
                    }catch (IllegalArgumentException e){
                        System.out.println("cursor is herbivore");
                    }
                    catch (PositionNotAvailableException ex){}
                }



            }if(command.equalsIgnoreCase("RC")){
                System.out.println("What is the name of the organism to be removed?");
                String name = in.nextLine();
                try{
                    tree.removeChild(name);
                    System.out.println("A(n) "+name+" has successfully removed as prey for the "+tree.getCursor().getName());
                }catch (IllegalArgumentException e){}

            }if(command.equalsIgnoreCase("P")){
                try{
                    String prey = tree.listPrey();
                    System.out.println(prey);
                }catch (IsPlantException e){}

            }if(command.equalsIgnoreCase("C")){
//                String foodchain = tree.listFoodChain();
//                System.out.println(foodchain);
                System.out.println("This function is not available.");

            }if(command.equalsIgnoreCase("F")){
                tree.printOrganismTree();

            }if(command.equalsIgnoreCase("LP")){
                String allPlants = tree.listAllPlants();
                System.out.println(allPlants);

            }if(command.equalsIgnoreCase("R")){
                tree.cursorReset();
            }if(command.equalsIgnoreCase("M")){
                System.out.println("Move to?");
                String name = in.nextLine();
                try{
                    tree.moveCursor(name);
                }catch(IllegalArgumentException e){
                    System.out.println("Name not found");
                }

            }
            if(command.equalsIgnoreCase("Q")){
                systemRunning =true;
            }
        }

    }
}
