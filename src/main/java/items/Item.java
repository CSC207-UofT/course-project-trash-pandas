package items;

/**
 * This is an abstract class representing an Items.Item.
 */
public abstract class Item {
    private String name;
    private String description;

    public Item(String name, String description){
        this.name = name;
        this.description = description;

    }
    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }



    @Override
    public String toString() {

        return name +
                " " +
                description;

    }
}
