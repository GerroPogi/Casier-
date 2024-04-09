package error;

public class ItemNotInReciept extends RuntimeException{
    public ItemNotInReciept(String ItemName){
        super("Item name: "+ItemName+" not in reciept");
    }
}
