import java.awt.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab6 {
    /**
     * Gets the file from absolute path, reads the file;
     * first it gets the arraySize number and creates an array for products
     * then goes through every line and adding up the product name and prices to product object
     * finally it printes every object with toString() method and after the loop, plots the prodcuts with plotProdcuts() method
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Getting the file location and opening up a scanner
        java.io.File file = new java.io.File("product.txt");
        Scanner input = new Scanner(file);
        int arraySize = input.nextInt(); // Reads the first line in order to get array size
        Lab6_Product[] products = new Lab6_Product[arraySize]; // Creates the array with given array size number
        // Read data from a file
        while (input.hasNext()) { // Continues to read the file
            for(int i = 0; i < arraySize; i++){
                String name = input.next(); // Product name
                int price = input.nextInt(); // Product price
                Lab6_Product p = new Lab6_Product(name, price); // Create product object with these values
                products[i] = p; // Add this product to the products array with index i
                System.out.println(p); // Print out the object
            }
        }
        input.close(); // Close the scanner
        plotProducts(products); // Plot the products list
    }

    /**
     * Method that plots the given product list with StdDraw.
     * All drawings/sizes are relative (enough) to 'canvasEdge' variable.
     * @param productList
     */
    public static void plotProducts(Lab6_Product[] productList){
        int canvasEdge = 500; // Initializing an edge of the canvas as it will be a square.
        StdDraw.setCanvasSize(canvasEdge, canvasEdge); // Setting up
        StdDraw.setScale(0, canvasEdge);
        double x = canvasEdge * 0.06; // Starting x point
        double y = 0; // Starting y point - this is always 0 because we want it to touch the canvas
        double halfWidth = canvasEdge * 0.04; // Half width of one column bar.
        double halfHeight = 0; // This will get initialized for every product uniquely
        int lineCount = productList.length;
        Font font = new Font("Arial", Font.PLAIN, (canvasEdge*12)/500); // Setting up font
        StdDraw.setFont(font);
        for(int i = 0; i < lineCount; i++){ // Loop for every product
            halfHeight = (productList[i].getPrice()/1.5)*(canvasEdge)/500; // Bar height relative to price value
            StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE); // Orange
            StdDraw.filledRectangle(x, y, halfWidth, halfHeight); // Drawing the rectangle
            StdDraw.setPenColor(StdDraw.BLACK); // Black
            StdDraw.text(x, halfHeight+10, productList[i].getName()); // Writing the product name
            StdDraw.show();
            x += canvasEdge * 0.11; // Increase x value for next product
        }
    }
}
