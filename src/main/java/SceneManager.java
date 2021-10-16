package java;

public class SceneManager {

    private DisplayScene displayer;

    SceneManager(){
        DisplayScene displayer = new DisplayScene();
    }
    public String displayScene(Scene scene) {
        return scene.getDescription();
    }
}
