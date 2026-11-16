package re.forestier.edu;

import org.junit.jupiter.api.*;

import re.forestier.edu.rpg.UpdatePlayer;
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
/* 
    @Test 
    @DisplayName ("test d'affichage de la classe du joueur'")
    void testAvatarClass(){
        player p = new player("Florian", "Grognak", "ADVENTURER", 100, new ArrayList<>());
        assertThat(p.getAvatarClass(),is("ADVENTURER"));

    }

*/

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
    @DisplayName ("test de removeMoney")
    void testRemoveMoney(){
        player p = new player("Florian", "Grognak", "ADVENTURER", 100, new ArrayList<>());
        p.removeMoney(10);
        assertThat(p.money,is(90));
        }


     @Test 
     @DisplayName ("test de addMoney()")
     void addMoney(){
        player player = new player("Florian", "Grognak le barbare", "ADVENTURER", 100, new ArrayList<>());
    
        player.addMoney(100);
        assertThat(player.money,is (equalTo(200)));
     }

    @Test
    @DisplayName("test de retreiveLevel() pour tout les niveaux")
    void testRetrieveLevel() {
        player p = new player("Florian", "Grognak", "ADVENTURER", 100, new ArrayList<>());
        
    
        assertThat(p.retrieveLevel(), is(1));

        
        UpdatePlayer.addXp(p, 15);
        assertThat(p.retrieveLevel(), is(2));

        
        UpdatePlayer.addXp(p, 15);
        assertThat(p.retrieveLevel(), is(3));


        UpdatePlayer.addXp(p, 30);
        assertThat(p.retrieveLevel(), is(4));

        UpdatePlayer.addXp(p, 60);
        assertThat(p.retrieveLevel(), is(5));
    }

    @Test
    @DisplayName ("test d'affichage des XP'") 
    void testGetXP(){
        player p = new player("Florian", "Grognak", "ADVENTURER", 100, new ArrayList<>()); 
        UpdatePlayer.addXp(p, 17);
        assertThat(p.getXp(),is(17));
    }

  // tests pour UpdatePlayer
@Test
@DisplayName("test joueur mort")
void testMort() {
    player p = new player("Florian", "Grognak le barbare", "ADVENTURER", 0, new ArrayList<>());
    p.healthpoints = 100;
    p.currenthealthpoints = 0;
    UpdatePlayer.majFinDeTour(p);
    assertThat(p.currenthealthpoints, is(0));
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
