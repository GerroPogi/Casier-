package error;
/*
    A runtime error to check if an item is in the reciept
 */
public class ItemInReciept extends RuntimeException{
    public ItemInReciept(String ItemName){
        super("Item name: "+ItemName+" already in reciept");
    }
}
