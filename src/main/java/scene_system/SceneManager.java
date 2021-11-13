package scene_system;

import scene_system.Scene;

public class SceneManager {


    public SceneManager(){}

    /**
     * returns the description of the scene
     * @param scene the scene_system.Scene to be returned
     * @return a string description of the scene
     */
    public String displayScene(Scene scene) {
        return scene.getDescription();
    }
}
