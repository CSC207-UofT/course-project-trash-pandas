package quest_system;

import characters.CharacterInventoryFacade;
import characters.Inventory;
import characters.NonPlayerCharacter;
import constants.Constants;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CombatQuestTest {
    private CombatQuest cQ;
    private NonPlayerCharacter npc;

    @Before
    public void before() throws Exception {
        NonPlayerCharacter npc = new NonPlayerCharacter(5, "tim");
        this.npc = npc;
        this.cQ = new CombatQuest("combat", Set.of(this.npc));
    }

    @After
    public void after() throws Exception {
        this.cQ = null;
    }

    @Test
    public void testCheckDoneAndUpdate(){
        cQ.update(this.npc);
        cQ.checkDone();
        Assert.assertEquals(0,cQ.getCompletion());
    }
}