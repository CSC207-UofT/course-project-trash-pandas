public class CompleteQuest {

    public void complete(GameCharacter player, Quest quest) {
        assert !quest.isComplete();

        for (String item : quest.getRewards()) {
            player.addItem(item);
        }

        quest.toggleComplete();


    }

}
