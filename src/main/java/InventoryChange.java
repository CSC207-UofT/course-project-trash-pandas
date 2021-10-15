package java;

public class InventoryChange {

    public void addItem(String item, Character chara){
        chara.addItem(item);
    }

    public boolean checkItem(String item, Character chara){
        return chara.checkItem(item);
    }

    public boolean removeItem(String item, Character chara){
        return chara.removeItem(item);
    }

}
