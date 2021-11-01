package scene_system;

import scene_system.Scene;

public class SceneManager {

    private DisplayScene displayer = new DisplayScene();

    public SceneManager(){
        DisplayScene displayer = new DisplayScene();
    }
    public String displayScene(Scene scene) {
        return displayer.displayScene(scene);
    }
}
