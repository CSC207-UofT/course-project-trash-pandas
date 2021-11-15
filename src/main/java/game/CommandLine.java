package game;

import characters.CharacterInventoryFacade;
import characters.NonPlayerCharacter;
import characters.PlayerCharacter;
import scene_system.DisplayDialogue;
import scene_system.Scene;
import scene_system.SceneManager;

import java.util.ArrayList;
import java.util.Scanner;

public class CommandLine {

    private final SceneManager scenes = new SceneManager();
    private final Scanner scanner = new Scanner(System.in);
    private final DisplayDialogue dialogue = new DisplayDialogue();

    public String sceneUI(Scene currentScene){
        System.out.println('\n'+ scenes.displayScene(currentScene));
        System.out.println("\n\ntype in the number of what you want to do\n1. travel\n2. talk to people nearby\n" +
                "3. look around \n4. Start combat");
        return scanner.nextLine();

    }

    public String travelUI(ArrayList<Scene> locations) {
        System.out.println("where would you like to go. (enter the number)");
        for (int i = 0; i < locations.size(); i++) {
            System.out.println(String.valueOf(i + 1) +". " + ((Scene) locations.get(i)).getName());

        }
        return scanner.nextLine();

    }

    public String talkUI(ArrayList<NonPlayerCharacter> npc){

        if(npc.size() == 0){
            System.out.println("no one's here");
            return "";
        }
        System.out.println("Who would you like to talk to. (enter the number)");
        for (int i = 0; i < npc.size(); i++) {
            System.out.println(i + 1 + ". " + (npc.get(i).getName()));
        }

        return scanner.nextLine();
    }

    public void dialogue(NonPlayerCharacter npc, CharacterInventoryFacade player){
        System.out.println(dialogue.dialogue(npc, player));
    }

    public String itemUI(ArrayList<String> items){

        if(items.size() == 0){
            System.out.println("you can't see anything important around here.");
            return "";
        }

        System.out.println("you found some objects, what would you like to pick up. (enter the number)");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + 1 + ". " + (items.get(i)));
        }
        return scanner.nextLine();
    }
    public void fail(){
        System.out.println("That's not an option, try again");
    }
}





