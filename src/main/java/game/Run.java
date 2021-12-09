package game;

import characters.*;
import constants.Constants;
import items.Item;
import items.QuestItem;
import quest_system.*;
import scene_system.Scene;
import GUI.MainFrame;
import scene_system.SceneManager;


import java.util.*;
import java.util.Set;

/**
 * Starts the game.
 */
public class Run {

    public static void main(String[] args) {

        PlayerCharacter bernie = new PlayerCharacter(10, "Bernie");

        bernie.addAbility(Constants.ABILITY_LIST.get("trash"));

        String beginDialogue = "\"Hail, masked traveler! I am the wondering Nomad. Might I interest you in some of" +
                " my wares? You may purchase any of them for one silver coin.\" Says the Frog. You don't have" +
                " anything else to do, so you decide to buy from the frog. But where will you find a silver coin?";
        String duringDialogue = "\"You still don't have a coin for me.\" Says the frog.";
        String endingDialogue = "\"Ah! I see you have returned with some coin! Now give it here.\"";
        FetchQuest coinQuest = new FetchQuest("Find the coin",
                Set.of((QuestItem)Constants.ITEM_LIST.get("coin")));
        QuestManager questManager = new QuestManager();
        questManager.addQuest(coinQuest);
        String combatDialogue = "Tim: You wish to fight? So be it.";

        NonPlayerCharacter timC = new NonPlayerCharacter(1, "Tim", beginDialogue,
                duringDialogue, endingDialogue, coinQuest, combatDialogue);
        NonPlayerCharacter evanC = new NonPlayerCharacter(1, "Evan", beginDialogue,
                duringDialogue, endingDialogue, coinQuest, combatDialogue);
        Inventory timInventory = new Inventory();
        CharacterInventoryFacade tim = new CharacterInventoryFacade(timInventory, timC, List.of());

        CombatQuest combatQuest = new CombatQuest("kill tim",Set.of(timC));
        NonPlayerCharacter target = new NonPlayerCharacter(1, "target", "help, tim punched me, kill him",
                "i believe in you","thank you for killing tim", combatQuest, "good luck");
        Inventory targetInventory = new Inventory();
        CharacterInventoryFacade targetFacade = new CharacterInventoryFacade(targetInventory, target, List.of());
        CharacterInventoryFacade evan = new CharacterInventoryFacade(timInventory, evanC, List.of());

        questManager.addQuest(combatQuest);
        String streetName = "Street";
        ArrayList<String> streetNPCS = new ArrayList<>();
        streetNPCS.add(tim.getName());
        streetNPCS.add(evanC.getName());
        String streetDescription = "You are in the city.";
        ArrayList<Item> streetItems = new ArrayList<>();

        Scene street = new Scene(streetName, streetNPCS, streetDescription, streetItems, List.of(questManager));


        String pizzaPlaceName = "Pizza Place";
        ArrayList<String> pizzaNPCS = new ArrayList<>();
        pizzaNPCS.add(target.getName());
        String pizzaPlaceDescription = "This pizza joint is squeaky clean aside from a scrunched up disc" +
                " of aluminum foil dropped on one of the seats.";
        ArrayList<Item> pizzaPlaceItems = new ArrayList<>();
        pizzaPlaceItems.add(Constants.ITEM_LIST.get("coin"));
        Scene pizzaPlace = new Scene(pizzaPlaceName, pizzaNPCS, pizzaPlaceDescription, pizzaPlaceItems,
                List.of(questManager));

        street.addScene(pizzaPlace);
        pizzaPlace.addScene(street);

        HashMap<String, Scene> scenes = new HashMap<>();
        scenes.put(street.getName(), street);
        scenes.put(pizzaPlace.getName(), pizzaPlace);

        SceneManager sceneManager = new SceneManager(scenes);

        Inventory inventory = new Inventory();
        CharacterInventoryFacade bernieFacade = new CharacterInventoryFacade(inventory,bernie, List.of(questManager));

        HashMap<String, CharacterInventoryFacade> characters = new HashMap<>();
        characters.put(bernie.getName(), bernieFacade);
        characters.put(target.getName(), targetFacade);
        characters.put(evanC.getName(), evan);
        characters.put(timC.getName(), tim);

        CharacterInventoryFacadeManager cifManager = new CharacterInventoryFacadeManager(characters);

        MainFrame frame = new MainFrame("Street", bernieFacade, sceneManager, cifManager);
        frame.titleFrame();
    }
}