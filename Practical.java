import java.util.ArrayList;

import static utils.*;
/**
 * Write a description of class Practical here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Practical
{
    public static void main(String[] args) throws InterruptedException {
        boolean is_continuing = true;
        Computer computer = new Computer();
        while (is_continuing){



            
            String ask_continue = "";
            while (ask_continue.isEmpty()) {
                cls();
                ask_continue = utils.getStringInput("Would you like to continue?\n (Y/N)", 10);
                if (Character.toString(ask_continue.charAt(0)).equalsIgnoreCase("y")) {
                    typewriter("We will keep going!",10);
                    sleep(1000);
                } else if (Character.toString(ask_continue.charAt(0)).equalsIgnoreCase("n")){
                    ArrayList<Item> receipt = computer.getReciept();
                    sleep(500);
                    typewriter("You bought",10);
                    for (Item item : receipt){
                        typewriter(item.getName()+" ----- "+ item.getPrice(), 10);
                    }
                    typewriter("Thank you for joining us!",10);
                    is_continuing=false;
                } else {
                    typewriter("Please give a valid value (Y/N)",10);
                    sleep(500);
                }
            }
            cls();
        }
    }
}
