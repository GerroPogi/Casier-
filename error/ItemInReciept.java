package error;

public class ItemInReciept extends RuntimeException{
    public ItemInReciept(String ItemName){
        super("Item name: "+ItemName+" already in reciept");
    }
}
