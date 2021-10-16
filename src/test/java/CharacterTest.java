package java;

import org.junit.*;
import static org.junit.Assert.*;

public class CharacterTest {
    @Test(timeout = 50)
    public void testCheckItem() {
        NonPlayerCharacter bernie = new NonPlayerCharacter(10, "Bernie");
        bernie.addItem("Foil");
        assertTrue(bernie.checkItem("Foil"));
    }
}
