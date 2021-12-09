package quest_system;


import characters.NonPlayerCharacter;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.util.Set;

public class CombatQuestTest {
    private CombatQuest cQ;
    private NonPlayerCharacter npc;

    @Before
    public void before() {
        NonPlayerCharacter npc = new NonPlayerCharacter(5, "tim");
        this.npc = npc;
        this.cQ = new CombatQuest("combat", Set.of(this.npc));
    }

    @After
    public void after() {
        this.cQ = null;
    }

    @Test
    public void testCheckDoneAndUpdate(){
        cQ.update(this.npc);
        cQ.checkDone();
        Assert.assertEquals(0,cQ.getCompletion());
    }
}