import error.ItemInReciept; // Importing necessary classes

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main class
public class Practical {

    // Constructor
    public Practical() {
    }

    // Method to print text with typewriter effect
    public static void typewriter(String text, int milliseconds) throws InterruptedException {
        for (int i = 0; i < text.length(); i++) {
            System.out.printf("%c", text.charAt(i));
            Thread.sleep(milliseconds);
        }
        System.out.println();
    }

    // Method to get string input with typewriter effect
    public static String getStringInput(String text, int milliseconds) throws InterruptedException {
        typewriter(text, milliseconds);
        return new Scanner(System.in).nextLine();
    }

    // Method to clear console screen
    public static void cls() {
        System.out.print("\f");
    }

    // Method to pause execution for given milliseconds
    public static void sleep(int milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }

    // Creating a Computer instance
    static Computer computer;

    static {
        // Initializing Computer instance within a static block
        try {
            computer = new Computer();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Main method
    public static void main(String[] args) throws InterruptedException {
        boolean is_continuing = true;
        while (is_continuing) {
            main_menu(); // Call main menu method
            String ask_continue = "";
            while (ask_continue.isEmpty()) {
                cls();
                // Ask user if they want to continue
                ask_continue = getStringInput("Would you like to continue?\n (Y/N)", 10);
                if (Character.toString(ask_continue.charAt(0)).equalsIgnoreCase("y")) {
                    typewriter("We will keep going!", 10);
                    sleep(1000);
                } else if (Character.toString(ask_continue.charAt(0)).equalsIgnoreCase("n")) {
                    // If user chooses not to continue, display the receipt
                    ArrayList<Item> receipt = computer.getReciept();
                    sleep(500);
                    if (receipt.isEmpty()) {
                        typewriter("You bought nothing!", 10);
                    } else {
                        typewriter("You bought", 10);
                    }
                    for (Item item : receipt) {
                        typewriter(item.getName() + " ----- " + item.getPrice(), 10);
                    }
                    sleep(2000);
                    is_continuing = false;
                } else {
                    // Prompt user for valid input
                    typewriter("Please give a valid value (Y/N)", 10);
                    ask_continue = "";
                    sleep(2000);
                }
            }
            cls();
        }
        typewriter("Thank you for joining us!", 10);
    }

    // Method for main menu
    public static void main_menu() throws InterruptedException {
        String mode = "";
        cls();
        String[] popular_modes = {"Horror", "Multiplayer", "VisualNovel", "HTML5", "Simulation", "macOS", "Rougelinke", "Linux"};
        while (mode.isEmpty()) {
            // Display popular tags and prompt user to choose a game
            typewriter("Welcome to Itch.io!", 10);
            sleep(1000);
            typewriter("We have a lot of Games to choose today.", 50);
            typewriter("--------------------\n" +
                    "POPULAR TAGS\n[1] Horror games\n" +
                    "[2] Multiplayer\n" +
                    "[3] Visual Novels\n" +
                    "[4] HTML5 games\n" +
                    "[5] Simulation\n" +
                    "[6] macOS games\n" +
                    "[7] Roguelike\n" +
                    "[8] Linux games\n" +
                    "[9] Browse all tags\n" +
                    "--------------------", 1);
            sleep(1000);
            mode = getStringInput("Please choose a game of your liking! \n(Say check to check your cart.)", 50);
            cls();
            try {
                if (mode.equalsIgnoreCase("check")) {
                    check();
                } else if (Integer.parseInt(mode) <= 8 && Integer.parseInt(mode) > 0) {
                    showGames(popular_modes[Integer.parseInt(mode) - 1]);
                } else if (mode.equalsIgnoreCase("9")) {
                    more();
                } else {
                    typewriter("Please give a valid selection! \n(1-9)", 10);
                    mode = "";
                }
            } catch (NumberFormatException e) {
                typewriter("Please give a number!", 10);
                mode = "";
            }
        }
    }

    // Method to check the cart
    public static void check() throws InterruptedException {
        if (computer.getReciept().isEmpty()) {
            typewriter("You have added nothing!", 100);
            sleep(2000);
            return;
        }
        String checking = "";
        while (checking.isEmpty()) {
            // Display items in the cart and prompt user for action
            typewriter("You have ordered: ", 10);
            int i = 1;
            for (Item game : computer.getReciept()) {
                if (game.getPrice() == 0) {
                    typewriter("[" + i + "] " + game.getName() + " --- Free", 10);
                } else {
                    typewriter("[" + i + "] " + game.getName() + " --- $" + game.getPrice(), 10);
                }
                i++;
            }
            checking = getStringInput("What do you want to do for your cart?\n(r to remove an on object on this list)\n(c to cancel this transaction)\n(ok to confirm this transaction)", 10);
            if (checking.equalsIgnoreCase("r")) {
                // Remove item from cart
                String remove = "";
                while (remove.isEmpty()) {
                    try {
                        remove = getStringInput("What would you like to remove?", 50);
                        if (Integer.parseInt(remove) - 1 < computer.getReciept().size() && Integer.parseInt(remove) > 0) {
                            Item game = computer.getReciept().get(Integer.parseInt(remove) - 1);
                            typewriter("Removing " + game.getName() + ".", 10);
                            computer.cancel(game.getId());
                            sleep(1000);
                        } else {
                            typewriter("Please give a valid number (1-" + computer.getReciept().size() + ")", 10);
                            remove = "";
                        }
                    } catch (NumberFormatException e) {
                        typewriter("Please give a number!", 10);
                        remove = "";
                    }
                }
            } else if (checking.equalsIgnoreCase("c") || checking.equalsIgnoreCase("ok")) {
                // Continue or cancel transaction
            } else {
                // Prompt for valid selection
                typewriter("Please give a valid selection", 150);
                sleep(1000);
                checking = "";
            }
        }
    }

    // Method to display more tags
    private static void more() throws InterruptedException {
        String[] more_tags = {"Horror", "2d", "Singleplayer", "PixelArt", "Adventure", "3d", "Short", "Retro", "VisualNovel", "Simulation", "Multiplayer", "HTML5", "macOS", "Rougelike", "Linux"};
        String mode = "";
        while (mode.isEmpty()) {
            cls();
            typewriter("More tags:", 100);
            sleep(1000);
            typewriter("--------------------\n" +
                    "[1] Horror\n" +
                    "[2] 2D\n" +
                    "[3] Singleplayer\n" +
                    "[4] Pixel Art\n" +
                    "[5] Adventure\n" +
                    "[6] 3D\n" +
                    "[7] Short\n" +
                    "[8] Retro\n" +
                    "[9] Visual Novel\n" +
                    "[10] Simulation\n" +
                    "[11] Multiplayer\n" +
                    "[12] HTML5 Games\n" +
                    "[13] macOS Games\n" +
                    "[14] Rougelike\n" +
                    "[15] Linux\n" +
                    "--------------------", 1);
            mode = getStringInput("Please choose a game of your liking! (Say cancel to return to main menu)", 50);
            cls();
            try {
                if (mode.equalsIgnoreCase("cancel")) {
                    // Return to main menu
                } else if (Integer.parseInt(mode) <= 15 && Integer.parseInt(mode) > 0) {
                    showGames(more_tags[Integer.parseInt(mode) - 1]);
                } else if (mode.equalsIgnoreCase("9")) {
                    more();
                } else {
                    typewriter("Please give a valid selection! \n(1-15)", 10);
                    mode = "";
                }
            } catch (NumberFormatException e) {
                typewriter("Please give a number!", 10);
                mode = "";
            }
        }
    }

    // Method to show games based on selected type
    private static void showGames(String type) throws InterruptedException {
        typewriter("You have selected the mode for " + type + " games.\nThese are the games for that mode!", 50);
        int i = 1;
        String chosenGame = "";
        while (chosenGame.isEmpty()) {
            // Display games of selected type and prompt user for choice
            List<Item> games = computer.getItemsByType(type, computer.menu);
            for (Item game : games) {
                if (game.getPrice() == 0) {
                    typewriter("[" + i + "] " + game.getName() + " --- Free", 10);
                } else {
                    typewriter("[" + i + "] " + game.getName() + " --- $" + game.getPrice(), 10);
                }
                i++;
            }
            chosenGame = getStringInput("Choose game of your choice. \n(say cancel to return to main menu.)", 10);
            try {
                if (chosenGame.equalsIgnoreCase("cancel")) {
                    // Return to main menu
                } else if (Integer.parseInt(chosenGame) < i && Integer.parseInt(chosenGame) > 0) {
                    Item game = games.get(Integer.parseInt(chosenGame) - 1);
                    typewriter("Ok, adding to cart: " + game.getName(), 10);
                    try {
                        computer.buy(game.getId());
                    } catch (ItemInReciept e) {
                        typewriter(String.valueOf(e), 10);
                        sleep(1000);
                    }
                    sleep(1000);
                } else {
                    typewriter("Please give a number within the range", 10);
                    chosenGame = "";
                }
            } catch (NumberFormatException e) {
                typewriter("Please give a number!", 10);
                chosenGame = "";
            }
        }
        main_menu(); // Return to main menu after selecting game
    }
}
