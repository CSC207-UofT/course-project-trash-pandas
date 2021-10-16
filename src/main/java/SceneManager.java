package java;

public class SceneManager {

    private DisplayScene displayer;

    public SceneManager(){
        DisplayScene displayer = new DisplayScene();
    }

    public String displayScene(Scene scene) {
        return displayer.displayScene(scene);
    }
}
