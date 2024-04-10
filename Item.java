import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Item class representing a product/item in a store
public class Item {
    // Private member variables
    private double price; // Price of the item
    private String name; // Name of the item
    private List<String> type; // Type(s) of the item
    private int id; // Unique ID of the item

    // Constructor to initialize the item with given parameters
    public Item(int id, String name, double price, String... types) {
        this.id = id; // Initialize ID
        this.name = name; // Initialize name
        this.type = new ArrayList<>(); // Initialize type list
        this.type.addAll(Arrays.asList(types)); // Add types to the type list
        this.price = price; // Initialize price
    }

    // Method to check if the given ID matches the ID of the item
    public boolean match_id(int id) {
        return this.id == id; // Returns true if IDs match, otherwise false
    }

    // Method to check if the item matches the given type
    public boolean match_type(String type) {
        return this.type.contains(type); // Returns true if the type list contains the given type, otherwise false
    }

    // Getter method to retrieve the name of the item
    public String getName() {
        return this.name; // Returns the name of the item
    }

    // Getter method to retrieve the price of the item
    public double getPrice() {
        return price; // Returns the price of the item
    }

    // Getter method to retrieve the ID of the item
    public int getId() {
        return this.id; // Returns the ID of the item
    }
}
