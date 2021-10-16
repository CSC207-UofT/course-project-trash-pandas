public class SceneManager {

    private DisplayScene displayer = new DisplayScene();

    SceneManager(){
        DisplayScene displayer = new DisplayScene();
    }
    public String displayScene(Scene scene) {
        return displayer.displayScene(scene);
    }
}
