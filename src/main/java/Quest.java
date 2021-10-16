import java.util.*;

public abstract class Quest {

    private String name;
    private ArrayList<String> rewardItems = new ArrayList<>();

    private int completion;

    public String getName() {
        return this.name;
    }

    public ArrayList<String> getRewards() {
        return this.rewardItems;
    }

    public boolean isComplete() {
        return this.completion == 2;
    }

    public void toggleComplete() {
        this.completion = 2;
    }

    public boolean isAccepted() {
        return this.completion == 1;
    }

    public void toggleAccepted() {
        this.completion = 1;
    }

    public int getCompletion(){
        return completion;
    }

    public abstract boolean checkDone(PlayerCharacter player);

}
