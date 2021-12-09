package items;

/**
 * A class representing equipable weapons.
 */
public class WeaponItem extends Item {

    private int damage;

    public WeaponItem(String name, String description, int damage){
        super(name, description);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }


    @Override
    public String toString(){

        return super.toString() +
                " Damage: " +
                damage;
    }
}
