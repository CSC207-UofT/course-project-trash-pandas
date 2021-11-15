package game;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import characters.GameCharacter;
import quest_system.QuestManager;
import scene_system.SceneManager;
import game.Run;

public class Save {

    private static final String filePath = "a.json";

    public static void save(GameCharacter player,  ) {

        try{
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            JSONObject stateObj = jsonObject.get("States");
            stateObj.put("player_health", player.getCurrentHealth());
            stateObj.put("inventory", player.getInventory());
            stateObj.put("equipped_weapon", player.getWeapon());
            stateObj.put("equpped_armor", player.getArmor());
            stateObj.put("npcs", .getNpcs());
            stateObj.put("quests", .getQuests());
            stateObj.put("scene", currentscene);

        } catch (IOException | ParseException | NullPointerException ex) {
            ex.printStackTrace();
        }
    }
}