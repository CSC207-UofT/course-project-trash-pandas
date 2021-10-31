public class InventoryChange {

    public void addItem(String item, GameCharacter chara){
        chara.addItem(item);
    }

    public boolean checkItem(String item, GameCharacter chara){
        return chara.checkItem(item);
    }

    public boolean removeItem(String item, GameCharacter chara){
        return chara.removeItem(item);
    }

}
