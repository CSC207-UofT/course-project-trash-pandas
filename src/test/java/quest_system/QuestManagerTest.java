package quest_system;

import characters.CharacterInventoryFacade;
import characters.Inventory;
import characters.NonPlayerCharacter;
import characters.PlayerCharacter;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class QuestManagerTest{

    private CombatQuest cQ;
    private NonPlayerCharacter npc;
    private QuestManager qm;
    private CharacterInventoryFacade cIF;

    @Before
    public void before() throws Exception {
        this.npc = new NonPlayerCharacter(10,"tim" );
        this.cQ = new CombatQuest("quest", Set.of(npc));
        this.qm = new QuestManager();
        this.cIF = new CharacterInventoryFacade(new Inventory(), new PlayerCharacter(10,"tim"), List.of());
    }

    @After
    public void tearDown() throws Exception {
        this.npc = null;
        this.cQ = null;
        this.qm = null;
    }

    @Test
    public void testAddQuest() {
        qm.addQuest(cQ);
        Assert.assertEquals(this.cQ,qm.getQuest("quest"));
    }

    @Test
    public void testAddReward(){
        qm.addQuest(cQ);
        qm.addReward("potion","quest");
        ArrayList<String> rewards = new ArrayList<>();
        rewards.add("potion");
        Assert.assertEquals(rewards, cQ.getRewards());
    }

    @Test
    public void testCompleteQuest() {
        qm.addQuest(cQ);
        qm.completeQuest(this.cIF,this.cQ);
        Assert.assertEquals(2,this.cQ.getCompletion());
    }

    @Test
    public void testAcceptQuest() {
        qm.acceptQuest(cQ);
        Assert.assertEquals(1,cQ.getCompletion());
    }

    @Test
    public void testUpdate() {
        qm.addQuest(cQ);
        qm.update(npc);
        qm.acceptQuest(cQ);
        cQ.checkDone();
        Assert.assertEquals(2,this.cQ.getCompletion());
    }
}