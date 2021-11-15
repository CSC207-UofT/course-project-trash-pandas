package worldstate_system;

import java.util.HashMap;

public class WorldManager {
    private final WorldState world;

    /**
     * Initialises the worldstate manager, and creates a worldstate.
     *
     * @param time The ingame time when the game is started or loaded
     * @param initial_npc_list A hashmap of npcs and their current life status, dead (false) or alive (true)
     */
    public WorldManager(int time, HashMap<String, Boolean> initial_npc_list){
        this.world = new WorldState(time, initial_npc_list);
    }

    /**
     * Checks whether the character is alive or dead.
     *
     * @param charName the name of the character that is being checked for in string form.
     * @return returns true if the character is alive, false if it is dead.
     */
    public Boolean checkLifeStatus(String charName){
        return this.world.getLifeStatus(charName);
    }

    /**
     * Sets the npc's life status to whatever it is not currently. (Alive->Dead, and vice versa)
     *
     * @param charName The name of the NonPlayerCharacter in string form.
     */
    public void changeLifeStatus(String charName){
        this.world.setNpc_life(charName, !this.world.getLifeStatus(charName));
    }

    /**
     * Returns the time in the form XX:XX am/pm
     *
     * @return the current time in string form to display in game.
     */
    public String getDisplayTime(){
        int time = this.world.getTime();
        int minutes = time%60;
        int hours = (time - minutes)/60;
        String ampm;
        if(hours>12){
            hours = hours - 12;
            ampm = "pm";
        }else if(hours == 12){
            ampm = "pm";
        }else{ ampm = "am";
        }
        if(minutes<10){
            return hours + ":0" + minutes + " " + ampm;
        }else{
            return hours + ":" + minutes + " " + ampm;
        }
    }

    /**
     * Progresses the game time by the amount of minutes given.
     *
     * @param minutes the number of minutes to move time forward by.
     */
    public void progressTime(int minutes){
        int newtime = this.world.getTime() + minutes;
        if(newtime >= 1440){
            this.world.changeTime(newtime - 1440);
        }else{
            this.world.changeTime(newtime);
        }
    }
}
