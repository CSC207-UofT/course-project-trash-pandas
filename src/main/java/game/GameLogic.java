package game;

import characters.NonPlayerCharacter;
import characters.PlayerCharacter;
import game.CommandLine;
import scene_system.DisplayDialogue;
import scene_system.Scene;
import scene_system.SceneManager;

import java.util.ArrayList;
import java.util.Scanner;

public class GameLogic {

    private final SceneManager scenes = new SceneManager();
    private final Scanner scanner = new Scanner(System.in);
    private final DisplayDialogue dialogue = new DisplayDialogue();
    private final CommandLine ui = new CommandLine();

    public void sceneLogic(Scene currentScene, PlayerCharacter player){
        String input = ui.sceneUI(currentScene);
        switch (input){
            case "1":
                this.travelLogic(currentScene, player);

            case "2":
                this.talkLogic(currentScene, player);

            case "3":
                this.itemLogic(currentScene, player);

            case "4":
                currentScene.start_combat(player);

            default:
                ui.fail();
                this.sceneLogic(currentScene, player);
        }
    }

    public void travelLogic(Scene currentScene, PlayerCharacter player) {
        ArrayList<Scene> locations = currentScene.getConnectedAreas();
        outerLoop:
        while (true) {
            String input = ui.travelUI(locations);
            if(input.equals("")){
                this.sceneLogic(currentScene, player);
                break;
            }
            try {
                int inputInt = Integer.parseInt(input);
                for (int i = 0; i< locations.size(); i++){
                    if (i == inputInt-1){
                        this.sceneLogic(locations.get(i), player);
                        break outerLoop;
                    }
                }
                ui.fail();
            }
            catch (NumberFormatException e){
                ui.fail();
            }
        }

    }

    public void talkLogic(Scene currentScene, PlayerCharacter player){
        ArrayList<NonPlayerCharacter> npc = currentScene.getNpc();
        outerLoop:
        while(true) {
            String input = ui.talkUI(npc);
            if(input.equals("")){
                this.sceneLogic(currentScene, player);
                break;
            }
            try{
                int inputInt = Integer.parseInt(input);
                for (int i = 0; i < npc.size(); i++) {
                    if (i == inputInt-1) {
                        ui.dialogue(npc.get(i), player);
                        this.sceneLogic(currentScene, player);
                        break outerLoop;
                    }
                }
                ui.fail();
            }
            catch (NumberFormatException e){
                ui.fail();
            }
        }
    }

    public void itemLogic(Scene currentScene, PlayerCharacter player){
        ArrayList<String> items = currentScene.getItems();
        outerLoop:
        while(true){
            String input = ui.itemUI(items);
            if(input.equals("")){
                this.sceneLogic(currentScene, player);
                break;
            }
            try {
                int inputInt = Integer.parseInt(input);
                for (int i = 0; i < items.size(); i++) {
                    if (i == inputInt - 1) {
                        player.addItem(items.get(i));
                        currentScene.removeItem(items.get(i));
                        this.sceneLogic(currentScene, player);
                        break outerLoop;
                    }
                }
                ui.fail();
            }
            catch (NumberFormatException e){
                ui.fail();
            }
        }
    }
}

