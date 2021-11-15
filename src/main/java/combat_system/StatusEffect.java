package combat_system;

public class StatusEffect {
    private String ID;
    private String description;

    public StatusEffect(String id, String description){
        this.ID = id;
        this.description = description;
    }

    public String getID() { return this.ID; }
}
