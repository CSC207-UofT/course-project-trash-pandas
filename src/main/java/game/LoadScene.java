package game;

import characters.CharacterInventoryFacade;
import items.Item;
import scene_system.Scene;
import scene_system.SceneManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LoadScene {
    try{
        BufferedReader br = new BufferedReader(new FileReader("save_game.txt"));
        startSceneName = br.readLine();
        br.close();

        for (String sceneName : sceneManager.getSceneList()) {
            BufferedReader br = new BufferedReader(new FileReader(sceneName+"_scene.txt"));
            String name = br.readline();
            String[] parts1 = br.readline().split(",");
            ArrayList<String> NPCS = new ArrayList<>();
            for(int i=0; i < parts1.length();i++) {
                NPCS.add.parts1[i];
            }
            String description = br.readLine();
            String[] parts2 = br.readline().split(",");
            ArrayList<String> items = new ArrayList<>();
            for(int i=0; i < parts2.length();i++) {
                items.add.parts2[i];
            }
        }
    }
        catch (Exception e){

        }
    }

