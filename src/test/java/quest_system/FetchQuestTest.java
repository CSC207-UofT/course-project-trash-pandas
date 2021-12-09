package quest_system;

import constants.Constants;
import items.QuestItem;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;

public class FetchQuestTest{
    private FetchQuest quest;

    @Before
    public void before() throws Exception {
        this.quest = new FetchQuest("coin",Set.of((QuestItem)Constants.ITEM_LIST.get("coin")));
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("coin",quest.getName());
    }

    @Test
    public void testGetRewards() {
        Assert.assertEquals(new ArrayList<String>(), quest.getRewards());
    }

    @Test
    public void testIsComplete() {
        Assert.assertFalse(quest.isComplete());
    }

    @Test
    public void testToggleComplete() {
        quest.toggleComplete();
        Assert.assertTrue(quest.isComplete());
    }

    @Test
    public void testIsAccepted() {
        Assert.assertFalse(quest.isAccepted());
    }

    @Test
    public void testToggleAccepted() {
        quest.toggleAccepted();
        Assert.assertTrue(quest.isAccepted());
    }

    @Test
    public void testGetCompletion() {
        Assert.assertEquals(0, quest.getCompletion());
    }

    @Test
    public void testCheckDoneAndUpdate(){
        quest.toggleAccepted();
        quest.update(Constants.ITEM_LIST.get("coin"));
        quest.checkDone();
        Assert.assertEquals(2,quest.getCompletion());
    }
}
