package java;

import java.util.*;

public abstract class Quest {

    private String name;
    private ArrayList<String> rewardItems;

    private boolean complete;
    private boolean accepted;

    public String getName() {
        return this.name;
    }

    public ArrayList<String> getRewards() {
        return this.rewardItems;
    }

    public boolean isComplete() {
        return this.complete;
    }

    public void toggleComplete(boolean newValue) {
        this.complete = newValue;
    }

    public boolean isAccepted() {
        return this.accepted;
    }

    public void toggleAccepted(boolean newValue) {
        this.accepted = newValue;
    }

}
