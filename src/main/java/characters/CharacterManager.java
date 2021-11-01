package characters;

import characters.GameCharacter;

public class CharacterManager {

    private InventoryChange changer;


    public CharacterManager(){
        InventoryChange changer = new InventoryChange();
    }
    public void addItem(String item, GameCharacter chara){
        changer.addItem(item, chara);
    }

    public boolean checkItem(String item, GameCharacter chara){
        return changer.checkItem(item, chara);
    }

    public boolean removeItem(String item, GameCharacter chara){
        return changer.removeItem(item, chara);
    }
}
