package java;

public class FetchQuest extends Quest {

    private String goalItem;

    public FetchQuest(String goalItem) {
        this.goalItem = goalItem;
    }

    public boolean checkItems(Character player) {
        return player.checkItem(this.goalItem);
    }

}
