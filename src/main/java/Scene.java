package java;

import java.util.ArrayList;

public class Scene{
    private String name;
    private ArrayList<NonPlayerCharacter> npc;
    private String area_description;
    private ArrayList<Scene> connected_areas;
    private ArrayList<String> items;


    Scene(String name, ArrayList<NonPlayerCharacter> npc, String area,
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

    public ArrayList<Scene> getConnected_areas() {
        return connected_areas;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public ArrayList<NonPlayerCharacter> getNpc() {
        return npc;
    }

    public void removeItem(String item){
        this.items.remove(item);
    }

    public void addScene(Scene scene){
        this.connected_areas.add(scene);
    }
}
