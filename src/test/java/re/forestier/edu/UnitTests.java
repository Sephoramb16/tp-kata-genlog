package re.forestier.edu;

import org.junit.jupiter.api.*;
import re.forestier.edu.rpg.player;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

public class UnitTests {
    // TEST PLAYER.JAVA 
    @Test
    @DisplayName("Sample test")
    void testPlayerName() {
        player player = new player("Florian", "Grognak le barbare", "ADVENTURER", 100, new ArrayList<>());
        assertThat(player.playerName, is("Florian"));
    }
    // modifier ce test pour qu'il soit complet
    @Test
    @DisplayName("Impossible to have negative money")
    void testNegativeMoney() {
        player p = new player("Florian", "Grognak le barbare", "ADVENTURER", 100, new ArrayList<>());

        try {
            p.removeMoney(200);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();
    }
    

     @Test 
     void addMoney(){
        player player = new player("Florian", "Grognak le barbare", "ADVENTURER", 100, new ArrayList<>());
    
        player.addMoney(100);
        assertThat(player.money,is (equalTo(200)));
     }

   /* @Test
    void testRetrieveLevel(){
        player p = new player("Florian", "Grognak le barbare", "ADVENTURER", 100, new ArrayList<>());
        p.level(2);
        getXp()<p.levels.get;
        assertThat(p.retrieveLevel(), is(1));

        p.level=3;
        assertThat(p.retrieveLevel(), is(2));
        p.level=4;
        assertThat(p.retrieveLevel(), is(3));
        p.level=5;
        assertThat(p.retrieveLevel(), is(4));
       






    }

   @Test 
   void
   


   */

}
