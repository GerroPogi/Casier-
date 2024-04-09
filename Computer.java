import error.ItemInReciept;
import error.ItemNotInReciept;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Computer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Computer
{
    // instance variables - replace the example below with your own
    ArrayList<Item> menu = new ArrayList<>();

    ArrayList<Item> reciept = new ArrayList<>();

    public Computer() throws InterruptedException {
        utils.typewriter("starting computer",10);
        menu.add(new Item(0,"Gladihoppers","Fighting",0));
    }

    public void buy(int id){
        for(Item item : reciept){
            if (item.match_id(id)){
                throw new ItemInReciept(item.getName());
            }
        }
        for (Item item : menu){
            if (item.match_id(id)){
                reciept.add(item);
            }
        }
    }
    public void cancel(int id){
        Item item= getItemByID(id,reciept);
        if (item != null ){
            reciept.remove(item);
            return;
        }
        throw new ItemNotInReciept(getItemByID(id,reciept).getName());
    }
    public Item getItemByID(int id,ArrayList<Item> list){
        for (Item item : list){
            if (item.match_id(id)){
                return item;
            }
        }
        return null;
    }
    public List<Item> getItemsByType(String type,ArrayList<Item> list){
        List<Item> T_list = new ArrayList<>();
        for (Item item : list){
            if (item.match_type(type)){
                T_list.add(item);
            }
        }
        return T_list;
    }
    public ArrayList<Item> getReciept(){
        return reciept;
    }
}
