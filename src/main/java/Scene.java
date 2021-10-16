package java;

import java.util.ArrayList;

public class Scene{
    private String name;
    private ArrayList<Character> npc;
    private String area_description;
    private ArrayList<Scene> connected_areas;
    private ArrayList<String> items;


    Scene(String name, ArrayList<Character> npc, String area,
          ArrayList<String> items) {
        this.name = name;
        this.npc = npc;
        this.area_description = area;
        this.connected_areas = new ArrayList<>();
    }

    public String getDescription() {
        return this.area_description;
    }

    public String getName() {
        return this.name;
    }

    public Object[] getConnected_areas() {
        return connected_areas.toArray();
    }

    public Object[] getItems(){
        return items.toArray();
    }

    public Object[] getNpc(){
        return npc.toArray();
    }

    public void addScene(Scene scene){
        this.connected_areas.add(scene);
    }
}
