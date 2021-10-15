package java;

public class FetchQuest extends Quest {

    private String goalItem;

    public boolean checkItems(Character player) {
        return player.checkItem(this.goalItem);
    }

}
