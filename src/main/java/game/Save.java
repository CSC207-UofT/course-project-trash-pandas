package game;

import quest_system.QuestManager;
import scene_system.SceneManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;

public class Save {

    public void saveFile(String currentScene, SceneManager sceneManager) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("save_game.txt"));
            bw.write(currentScene);
            bw.close();

            for (String sceneName : sceneManager.getSceneList()) {
                BufferedWriter bw1 = new BufferedWriter(new FileWriter(sceneName + "_scene.txt"));
                bw1.write(sceneName);
                bw1.newLine();
                for (String npc : sceneManager.getNPC(sceneName)) {
                    bw1.write(npc + ",");
                }
                bw1.newLine();
                bw1.write(sceneManager.displayScene(sceneName));
                bw1.newLine();
                for (String item : sceneManager.getItems(sceneName)) {
                    bw1.write(item + ',');
                }
                bw1.close();
                }
            }
        catch(Exception e){
        }
    }
}
