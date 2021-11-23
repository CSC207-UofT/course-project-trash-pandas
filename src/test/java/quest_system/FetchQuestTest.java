package quest_system;

import items.QuestItem;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;

public class FetchQuestTest extends TestCase {
    FetchQuest quest;

    @Before
    public void before() throws Exception {
        QuestItem coin = new QuestItem("coin", "shiny");
        this.quest = new FetchQuest(Set.of(coin));
    }

    @After
    public void after() throws Exception {
    }

    public void testGetName() {
        assertEquals("coin",quest.getName());
    }

    public void testGetRewards() {
        assertEquals(new ArrayList<String>(), quest.getRewards());
    }

    public void testIsComplete() {
        assertFalse(quest.isComplete());
    }

    public void testToggleComplete() {
        quest.toggleComplete();
        assertTrue(quest.isComplete());
    }

    public void testIsAccepted() {
        assertFalse(quest.isAccepted());
    }

    public void testToggleAccepted() {
        quest.toggleAccepted();
        assertTrue(quest.isAccepted());
    }

    public void testGetCompletion() {
        assertEquals(1, quest.getCompletion());
    }
}