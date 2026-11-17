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

    @Test
    @DisplayName("test d'une classe invalide")
    void testInvalidAvatarClass() {
    player p = new player("Florian", "Grognak", "MAGE", 100, new ArrayList<>());
    assertThat(p.playerName, is(nullValue()));
}

  // tests pour UpdatePlayer
@Test 
void level(){
    player p = new player("Florian", "Grognak", "ADVENTURER", 0, new ArrayList<>());
    boolean leveledUp = UpdatePlayer.addXp(p, 2);
    assertThat(leveledUp, is(false));
}  
@Test
@DisplayName("test joueur mort")
void testMort() {
    player p = new player("Florian", "Grognak le barbare", "ADVENTURER", 0, new ArrayList<>());
    p.healthpoints = 100;
    p.currenthealthpoints = 0;
    UpdatePlayer.majFinDeTour(p);
    assertThat(p.currenthealthpoints, is(0));
}

@Test 
void testRessucite(){
    player p1 = new player("Player1", "Cas1", "ADVENTURER", 0, new ArrayList<>());
    player p2 = new player("Player2", "Cas2", "DWARF", 0, new ArrayList<>());
    player p3 = new player("Player3", "Cas3", "ARCHER", 0, new ArrayList<>());
    player p4 = new player("Player4", "Cas4", "ARCHER", 0, new ArrayList<>());
    player p5 = new player("Player5", "Cas5", "ADVENTURER", 0, new ArrayList<>());
    player p6 = new player("Player6", "Cas6", "ADVENTURER", 0, new ArrayList<>());
    player p7 = new player("Player7", "Cas7", "DWARF", 0, new ArrayList<>());
    player p8 = new player("Player8", "Cas8", "ADVENTURER", 0, new ArrayList<>());

    p1.healthpoints = 100;
    p1.currenthealthpoints = 1;
    p1.inventory.add("Holy Elixir");

    p2.healthpoints = 100;
    p2.currenthealthpoints = 1;
    p2.inventory.add("Holy Elixir");

    p3.healthpoints = 100;
    p3.currenthealthpoints = 1;

    p4.healthpoints = 200;
    p4.currenthealthpoints = 8;
    p4.inventory.add("Magic Bow");

    p5.healthpoints = 10;
    p5.currenthealthpoints = 10;

    p6.healthpoints = 10;
    p6.currenthealthpoints = 20;

    p7.healthpoints = 100;
    p7.currenthealthpoints = 1;

    p8.currenthealthpoints = 1;
    UpdatePlayer.addXp(p8, 30);

    UpdatePlayer.majFinDeTour(p1);
    UpdatePlayer.majFinDeTour(p2);
    UpdatePlayer.majFinDeTour(p3);
    UpdatePlayer.majFinDeTour(p4);
    UpdatePlayer.majFinDeTour(p5);
    UpdatePlayer.majFinDeTour(p6);
    UpdatePlayer.majFinDeTour(p7);
    UpdatePlayer.majFinDeTour(p8);

    assertThat(p1.currenthealthpoints, is(2));
    assertThat(p2.currenthealthpoints, is(3));
    assertThat(p3.currenthealthpoints, is(2));
    assertThat(p4.currenthealthpoints, is(9));
    assertThat(p5.currenthealthpoints,is(10));
    assertThat(p6.currenthealthpoints,is(10));




}
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


