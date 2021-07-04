/**
 * Program that reads data from a txt file and generates
 * a scenery from given data using StdDraw library
 *
 * @author Arda Serdar Pektezol
 * @since Date: 01.05.2021
 */

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment3Scenery {

    /**
     * Main method that stores the file path, arraylist's of objects
     * and calls loadData and plotScene methods with their parameters
     * @param args Main input arguments are not used
     */
    public static void main(String[] args) throws FileNotFoundException {

        String filename = "data1.txt"; // input file path
        // store scene elements in array lists
        ArrayList<Building> buildings = new ArrayList<>();
        ArrayList<Tree> trees = new ArrayList<>();
        loadData(filename, buildings, trees); // load scene elements from the input file
        plotScene(buildings, trees); // plot scene elements
    }

    /**
     * Draws the scenery from buildings and trees arrays containing their respective objects with StdDraw
     * This uses for each loop for both objects as specified in the assignment
     * @param buildings ArrayList containing Building objects
     * @param trees ArrayList containing Tree objects
     */
    private static void plotScene(ArrayList<Building> buildings, ArrayList<Tree> trees) {
        // Go through every element in buildings array with building object
        for (Building building : buildings) {
            building.drawBuilding(); // Call drawBuilding method from building class
        }
        // Go through every element in trees array with tree object
        for (Tree tree : trees) {
            tree.drawTree(); // Call drawTree method from tree class
        }
    }

    /**
     * Loads data from the given text file path, try catch is used in order to be prepared if an error happens
     * After all the data is read, it gets put into respective arraylists of objects
     * @param filename Path of the file that will get read through the scanner
     * @param buildings ArrayList that will contain Building objects
     * @param trees ArrayList that will contain Tree objects
     */
    private static void loadData(String filename, ArrayList<Building> buildings, ArrayList<Tree> trees) {
        // Getting the file location and opening up a scanner
        try { // Try catch is used in order to be prepared if an error happens
            java.io.File file = new java.io.File(filename); // Initialize file destination
            Scanner input = new Scanner(file); // Put scanner into file
            while (input.hasNext()) { // Starts to read the file
                String line = input.next(); // Getting string line
                String[] data = line.split(";"); // Split the line where there is ';' and put into array
                String obj = data[0]; // First element of array is object
                if (obj.equalsIgnoreCase("Building")) { // If object is equals to "Building"
                    int floorCount = Integer.parseInt(data[1]); // Turn second string element into int floorCount
                    double centerX = Double.parseDouble(data[2]); // Turn third string element into double centerX
                    double buildingWidth = Double.parseDouble(data[3]); // Turn fourth string element into double buildingWidth
                    Color buildingColor = StdDraw.BLACK; // Initialize color
                    //Check for string equivalent of colors and turn them into StdDraw colors
                    if (data[4].equalsIgnoreCase("Red")) {
                        buildingColor = StdDraw.RED;
                    } else if (data[4].equalsIgnoreCase("Yellow")) {
                        buildingColor = StdDraw.YELLOW;
                    } else if (data[4].equalsIgnoreCase("Orange")) {
                        buildingColor = StdDraw.PRINCETON_ORANGE;
                    } else if (data[4].equalsIgnoreCase("Blue")) {
                        buildingColor = StdDraw.BOOK_LIGHT_BLUE;
                    } else if (data[4].equalsIgnoreCase("Green")) {
                        buildingColor = StdDraw.GREEN;
                    } else {
                        System.out.println("Invalid color."); // If doesn't match print it's invalid
                    }
                    // Create new building object and add to arraylist
                    Building buildingObject = new Building(floorCount, centerX, buildingWidth, buildingColor);
                    buildings.add(buildingObject);
                    System.out.println("New building created.");
                } else if (obj.equalsIgnoreCase("Tree")) {
                    double centerX = Double.parseDouble(data[1]); // Turn second string element into double centerX
                    // Create new tree object and add to arraylist
                    Tree treeObject = new Tree(centerX);
                    trees.add(treeObject);
                    System.out.println("New tree created.");
                } else {
                    // If first word doesn't match building or tree, terminate program
                    System.out.println("Invalid object found. Terminating..");
                    break;
                }
            }
            input.close(); // Close the scanner
        } catch (FileNotFoundException e) {
            System.out.println("File could not be read."); // Error message for exception
        } finally {
            System.out.println("loadData method is finished."); // Print out that the method is finished regardless of the outcome
        }
    }
}