package combat_system;
import characters.GameCharacter;
import java.util.*;
import java.util.concurrent.*;
public class CombatManager {
    private int round = 0;
    private ArrayList<GameCharacter> particpants = new ArrayList<>();
    private TreeMap<Double, GameCharacter> turnorder = new TreeMap<Double, GameCharacter>();


    /**
     * Applies a status effect if there is currently no status effect of that name applied or if there is a status
     * effect of that name but its duration is lower than the new application's.
     * @param target a reference to the target of the status effect
     * @param status the status effect to apply
     * @param duration the duration of the status effect to apply
     */
    public void statusEffect(GameCharacter target, StatusEffect status, int duration) {
        if(target.getStatusEffects().get(status) == null || target.getStatusEffects().get(status)
                < duration) {
            target.setStatusEffect(status, duration);
        }
    }
    public void endRound() {
        this.round += 1;
        for (GameCharacter participant : this.particpants) {
            for(Map.Entry<StatusEffect, Integer> entry : participant.getStatusEffects().entrySet()) {
                {participant.setStatusEffect(entry.getKey(), entry.getValue()-1);}
            }
        }
    }

    /**
     * Calculates if an attack hits and the amount of damage it deals
     * @return the string description of damage being delt
     */
    public String damage(int toHit, GameCharacter target, GameCharacter attacker) {
        if(toHit >= target.getArmor().getDefense()) {
            target.setCurrentHealth(target.getCurrentHealth()-attacker.getWeapon().getDamage());
            return "The attack hits, dealing " + attacker.getWeapon().getDamage() + " damage!";
        }
        else {
            return "The attack misses!";
        }
    }

    public void take_turn(GameCharacter participant) {
    }

    public void combatLoop() {
        boolean combat = true;
        Random rand = new Random();
        for (GameCharacter participant : this.particpants) {
            turnorder.put(rand.nextDouble(), participant);
        }

        while (combat) {
            for (Map.Entry<Double, GameCharacter> partcipant : this.turnorder.entrySet()) {
                take_turn(partcipant.getValue());
            }
            endRound();

        }
    }
}
