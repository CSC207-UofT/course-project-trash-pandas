package java;

public class AcceptQuest {

    public void accept(Quest quest) {
        assert !quest.isAccepted();

        quest.toggleAccepted();
    }

}
