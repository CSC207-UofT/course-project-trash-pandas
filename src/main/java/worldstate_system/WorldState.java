package worldstate_system;

import characters.NonPlayerCharacter;

import java.util.HashMap;

public class WorldState {
    private int time;
    private HashMap<String, Boolean> npc_life;

    /**
     * Initialises the World State.
     *
     * @param initial_time The initial time of the game when started or loaded
     * @param initial_npc_life The initial state of life for all npcs when started or loaded
     */
    public WorldState(int initial_time, HashMap<String, Boolean> initial_npc_life){
        this.time = initial_time;
        this.npc_life = initial_npc_life;
    }

    /**
     * Gets the in game time.
     *
     * @return returns the current time in the game.
     */
    public int getTime(){
        return this.time;
    }

    public void changeTime(int newtime){
        this.time = newtime;
    }
    /**
     * Returns whether the npc is alive or dead.
     *
     * @param npc_name the string name of the npc you want to check
     * @return returns the state of living or dead, true for living, false for dead, NULL for if we want something else.
     */
    public Boolean getLifeStatus(String npc_name){
        return this.npc_life.get(npc_name);
    }

    /**
     * Changes the npc to the specified life status, living or dead.
     *
     * @param npc_name the name of the npc in string form.
     * @param lifestatus the state of living (true) or dead (false) of the npc.
     */
    public void setNpc_life(String npc_name, Boolean lifestatus){
        this.npc_life.put(npc_name, lifestatus);
    }


}

