package java;
import java.util.ArrayList;
import java.util.Scanner;

public class CommandLine {

    private final SceneManager scenes = new SceneManager();
    private final Scanner scanner = new Scanner(System.in);
    private final DisplayDialogue dialogue = new DisplayDialogue();

    public void sceneUI(Scene currentScene, PlayerCharacter player){
        System.out.println(scenes.displayScene(currentScene));
        System.out.println("\n\ntype in the number of what you want to do\n1. travel\n2. talk to people nearby\n" +
                "3. look around");
        String input = scanner.nextLine();
        switch (input){
            case "1":
                this.travelUI(currentScene, player);

            case "2":
                this.talkUI(currentScene, player);

            case "3":
                this.itemUI(currentScene, player);

            default:
                System.out.println("That's not an option, try again");
                this.sceneUI(currentScene, player);
        }
    }

    public void travelUI(Scene currentScene, PlayerCharacter player) {
        boolean answer = false;
        while (true) {
            ArrayList<Scene> locations = currentScene.getConnected_areas();
            System.out.println("where would you like to go. (enter the number)");
            for (int i = 0; i <= locations.size(); i++) {
                System.out.println(String.valueOf(i + 1) +". " + ((Scene) locations.get(i)).getName());

            }
            String input = scanner.nextLine();
            for (int i = 0; i<= locations.size(); i++){
                if (i == Integer.parseInt(input)-1){
                    this.sceneUI(((Scene)locations.get(i)), player);
                    answer = true;
                    break;
                }
            }
            if(answer){
                break;
            }
            System.out.println("That's not an option, try again");
        }

    }

    public void talkUI(Scene currentScene, PlayerCharacter player){
        boolean answer = false;
        while(true) {
            ArrayList<NonPlayerCharacter> npc = currentScene.getNpc();
            if(npc.size() == 0){
                System.out.println("no one's here");
                break;
            }
            System.out.println("Who would you like to talk to. (enter the number)");
            for (int i = 0; i <= npc.size(); i++) {
                System.out.println(String.valueOf(i + 1) + ". " + (npc.toString()));
            }

            int input = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i <= npc.size(); i++) {
                if (i == input-1) {
                    System.out.println(dialogue.dialogue(npc.get(i), player));
                    this.sceneUI(currentScene, player);
                    answer = true;
                }
            }
            if(answer){
                break;
            }
            System.out.println("That's not an option, try again");
        }

    }

    public void itemUI(Scene currentScene, PlayerCharacter player){

        outerLoop:
        while(true){
            ArrayList<String> items = currentScene.getItems();
            if(items.size() == 0){
                System.out.println("you can't see anything important around here.");
                this.sceneUI(currentScene, player);
                break;
            }

            System.out.println("you found some objects, what would you like to pick up. (enter the number");
            for (int i = 0; i <= items.size(); i++) {
                System.out.println(String.valueOf(i + 1) + ". " + (items.toString()));
            }

            int input = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i <= items.size(); i++) {
                if (i == input-1) {
                    player.addItem(items.get(i));
                    currentScene.removeItem(items.get(i));
                    this.sceneUI(currentScene, player);
                    break outerLoop;
                }
            }
            System.out.println("That's not an option, try again");
        }
    }
}


