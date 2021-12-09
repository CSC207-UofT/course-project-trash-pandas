package game;

import GUI.MainFrame;
import characters.CharacterInventoryFacade;
import items.Item;
import quest_system.QuestManager;
import scene_system.Scene;
import scene_system.SceneManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LoadScene {
    ArrayList<String> scenes = new ArrayList<>();

    public void LoadCurrentScene() {
        scenes.add("street");
        scenes.add("pizzaPlace");

        String startSceneName = "street";
        try {
            BufferedReader br = new BufferedReader(new FileReader("save_game.txt"));
            startSceneName = br.readLine();
            br.close();
        } catch (Exception e) {
        }
    }

    public SceneManager LoadScenes(QuestManager questManager) {
        HashMap<String, Scene> sceneMap = new HashMap<String, Scene>();
        for (String sceneName : scenes) {
            String line = "";
            String splitBy = ",";
            try {
                BufferedReader br = new BufferedReader(new FileReader(sceneName + "_scene.txt."));
                String name = "";
                name = br.readLine();
                line = br.readLine();
                String[] parts1 = line.split(splitBy);
                ArrayList<String> NPCS = new ArrayList<>();
                for(String npc: parts1) {
                    NPCS.add(npc);}
                String description = br.readLine();
                line = br.readLine();
                String[] parts2 = line.split(splitBy);
                ArrayList<Item> items = new ArrayList<>();
                for(String item: parts2) {
                    NPCS.add(item);}
                Scene scene = new Scene(name, NPCS, description, items, List.of(questManager));
                sceneMap.put(sceneName, scene);
                } catch (IOException e) {
                e.printStackTrace();
            }
        }
        SceneManager sceneManager = new SceneManager(sceneMap);
        return sceneManager;
    }
}

