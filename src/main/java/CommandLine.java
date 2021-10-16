package java;
import java.util.Scanner;

public class CommandLine {

    SceneManager scenes = new SceneManager();

    public void sceneUI(Scene currentScene){
        System.out.println(scenes.displayScene(currentScene));
        System.out.println("""

                type in the number of what you want to do
                1. travel\s
                2. talk to people nearby\s
                3. look around""".indent(1));
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input){
            case "1":
                Object[] locations = currentScene.getConnected_areas();
                System.out.println("where would you like to go");
                for (int i = 0; i <= locations.length; i++){
                    assert locations[i] instanceof Scene;
                    System.out.println(String.valueOf(i+1) + ((Scene) locations[i]).getName());
                }
        }

    }

    public void
}
