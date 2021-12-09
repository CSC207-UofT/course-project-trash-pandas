package game;

import GUI.MainFrame;
import characters.CharacterInventoryFacade;
import items.Item;
import items.ItemList;
import quest_system.QuestManager;
import scene_system.Scene;
import scene_system.SceneManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LoadScene {
    private ItemList itemList;

    public void LoadCurrentScene() {
        String startSceneName = "Street";
        try {
            BufferedReader br = new BufferedReader(new FileReader("save_game.txt"));
            startSceneName = br.readLine();
            br.close();
        } catch (Exception ignored) {
        }
    }

    public SceneManager LoadScenes(QuestManager questManager) {
        ArrayList<String> scenes = new ArrayList<>();
        HashMap<String, Scene> sceneMap = new HashMap<String, Scene>();
        scenes.add("Street");
        scenes.add("Pizza Place");
        for (String sceneName : scenes) {
            String line = "";
            String splitBy = ",";
            try {
                BufferedReader br = new BufferedReader(new FileReader(sceneName + "_scene.txt."));
                String name = "";
                name = br.readLine();
                line = br.readLine();
                String[] parts1 = null;
                if (line != null){
                    parts1 = line.split(splitBy);}
                ArrayList<String> NPCS = new ArrayList<>();
                assert parts1 != null;
                Collections.addAll(NPCS, parts1);
                String description = br.readLine();
                line = br.readLine();
                String[] parts2 = null;
                if (line != null){
                    parts2 = line.split(splitBy);}
                ArrayList<Item> items = new ArrayList<>();
                assert parts2 != null;
                for(String item: parts2) {
                    Item item1 = itemList.getItem(item);
                    items.add(item1);}
                Scene scene = new Scene(name, NPCS, description, items, List.of(questManager));
                sceneMap.put(sceneName, scene);
                } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new SceneManager(sceneMap);
    }
}

