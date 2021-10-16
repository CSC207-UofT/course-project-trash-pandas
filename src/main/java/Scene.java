package java;

import java.util.ArrayList;

public class Scene {
    private String name;
    private ArrayList<Character> npc;
    private String area_description;
    private ArrayList<String> connected_areas;


    Scene(String name, ArrayList<Character> npc, String area, ArrayList<String> connected_areas) {
        this.name = name;
        this.npc = npc;
        this.area_description = area;
        this.connected_areas = connected_areas;
    }

    public String getDescription() {
        return this.area_description;
    }
}
