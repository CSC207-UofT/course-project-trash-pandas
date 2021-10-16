package java;

public class CharacterManager {

    private InventoryChange changer;

    public CharacterManager(){
        InventoryChange changer = new InventoryChange();
    }

    public void addItem(String item, Character chara){
        changer.addItem(item, chara);
    }

    public boolean checkItem(String item, Character chara){
        return changer.checkItem(item, chara);
    }

    public boolean removeItem(String item, Character chara){
        return changer.removeItem(item, chara);
    }

}
