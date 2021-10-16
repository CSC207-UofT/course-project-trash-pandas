package java;

public class FetchQuest extends Quest {

    private String goalItem;

    public FetchQuest(String goalItem) {
        this.goalItem = goalItem;
    }

    public boolean checkDone(PlayerCharacter player) {
        return player.checkItem(this.goalItem);
    }

}
