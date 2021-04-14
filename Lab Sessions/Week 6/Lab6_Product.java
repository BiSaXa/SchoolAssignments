public class Lab6_Product {

    private String name;
    private int price;

    public Lab6_Product(String name, int price){ // Constructor with name and price parameters
        this.name = name;
        this.price = price;
    }

    public String toString() { // To string function so we can print objects properly
        return "Product: " + name + ", Price: " + price;
    }

    public String getName(){ // Getter method for product name
        return this.name;
    }

    public int getPrice(){ // Getter method for product price
        return this.price;
    }

}
