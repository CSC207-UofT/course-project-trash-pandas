package game;

import scene_system.SceneManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;

public class Save {

    public void save(String currentScene, SceneManager sceneManager) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("save_game.txt"));
            bw.write(currentScene);
            bw.close();

            for (String sceneName : sceneManager.getSceneList()) {
                BufferedWriter bw1 = new BufferedWriter(new FileWriter(sceneName + "_scene.txt"));
                bw.write(sceneName);
                bw.newLine();
                for (String npc : sceneManager.getNpcNames(sceneName)) {
                    bw.write(npc + ",");
                }
                bw.newLine();
                bw.write(sceneManager.displayScene(sceneName));
                bw.newLine();
                for (String item : sceneManager.getItems(sceneName)) {
                    bw.write(item + ',');
                }
                }
            bw.close();
            }
        catch(Exception e){
        }
    }
}
