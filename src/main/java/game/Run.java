package game;

import characters.*;
import game.GameLogic;
import items.Item;
import items.QuestItem;
import quest_system.*;
import scene_system.Scene;

import java.util.*;

/**
 * Starts the game.
 */
public class Run {

    public static void main(String[] args) {

        PlayerCharacter bernie = new PlayerCharacter(10, "Bernie");


        String beginDialogue = "\"Hail, masked traveler! I am the wondering Nomad. Might I interest you in some of" +
                " my wares? You may purchase any of them for one silver coin.\" Says the Frog. You don't have" +
                " anything else to do, so you decide to buy from the frog. But where will you find a silver coin?";
        String duringDialogue = "\"You still don't have a coin for me.\" Says the frog.";
        String endingDialogue = "\"Ah! I see you have returned with some coin! Now give it here.\"";
        QuestItem coin = new QuestItem("coin", "a silver coin");
        FetchQuest coinQuest = new FetchQuest(coin);

        NonPlayerCharacter tim = new NonPlayerCharacter(1, "Tim", beginDialogue,
                duringDialogue, endingDialogue, coinQuest);

        String streetName = "Street";
        ArrayList<NonPlayerCharacter> streetNPCS = new ArrayList<>();
        streetNPCS.add(tim);
        String streetDescription = "You are in the city.";
        ArrayList<Item> streetItems = new ArrayList<>();

        Scene street = new Scene(streetName, streetNPCS, streetDescription, streetItems);


        String pizzaPlaceName = "Pizza Place";
        ArrayList<NonPlayerCharacter> pizzaNPCS = new ArrayList<>();
        String pizzaPlaceDescription = "This pizza joint is squeaky clean aside from a scrunched up disc" +
                " of aluminum foil dropped on one of the seats.";
        ArrayList<Item> pizzaPlaceItems = new ArrayList<>();
        pizzaPlaceItems.add(coin);
        Scene pizzaPlace = new Scene(pizzaPlaceName, pizzaNPCS, pizzaPlaceDescription, pizzaPlaceItems);

        street.addScene(pizzaPlace);
        pizzaPlace.addScene(street);

        GameLogic logic = new GameLogic();
        Inventory inventory = new Inventory();
        CharacterInventoryFacade bernieFacade = new CharacterInventoryFacade(inventory,bernie);
        logic.sceneLogic(street, bernieFacade);
    }
}