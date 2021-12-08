package game;

import scene_system.SceneManager;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Save {

    public void save(String currentScene, SceneManager sceneManager) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("save_game.txt"));
            bw.write(currentScene);
            bw.close();
            BufferedWriter bw1 = new BufferedWriter(new FileWriter("street_scene.txt"));
            bw.write("Street");
            bw.newLine();
            for(String npc: sceneManager.getNpcNames("Street")) {
                bw.write(npc+",");}
            bw.newLine();
            bw.write(sceneManager.displayScene("Street"));
            bw.newLine();
            for(String item: sceneManager.getItems("Street")) {
                bw.write(item+',');

        } catch (Exception e) {
        }
    }
}
