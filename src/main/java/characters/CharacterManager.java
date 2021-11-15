package characters;

import characters.GameCharacter;
import org.json.simple.JSONObject;
import quest_system.Quest;

import java.util.HashMap;

public class CharacterManager {

    private InventoryChange changer;
    private HashMap<String, NonPlayerCharacter> npcs = new HashMap<>();
    private PlayerCharacter player;

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

    public Object getNpcs() {
        return new JSONObject(this.npcs);
}
