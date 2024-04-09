public class Item
{
    private float price;
    private String name;
    private String type;
    private int id;
    public Item(int id, String name, String type, float price)
    {
        this.id=id;
        this.name=name;
        this.type=type;
        this.price=price;
    }
    public boolean match_id(int id){
        return this.id==id;
    }
    public boolean match_type(String type){
        return this.type.equalsIgnoreCase(type);
    }

    public String getName(){
        return this.name;
    }

    public float getPrice() {
        return price;
    }
}
