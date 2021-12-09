package combat_system;

import java.util.List;

public class StatusEffect {
    private String ID;
    private List<String> subeffects;

    public StatusEffect(String id, List<String> subeffects){
        this.ID = id;
        this.subeffects = subeffects;
    }

    public String getID() { return this.ID; }

    public List<String> getSubeffects() { return this.subeffects; }

    public boolean is ( String id ) { return id.equals(this.ID); }

}
