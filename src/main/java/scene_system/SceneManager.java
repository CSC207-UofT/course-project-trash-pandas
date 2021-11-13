package scene_system;

import scene_system.Scene;

public class SceneManager {


    public SceneManager(){}
    public String displayScene(Scene scene) {
        return scene.getDescription();
    }
}
