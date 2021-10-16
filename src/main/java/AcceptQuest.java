package java;

public class AcceptQuest {

    public void accept(Character player, Quest quest) {
        assert !quest.isAccepted();

        quest.toggleAccepted(true);
    }

}
