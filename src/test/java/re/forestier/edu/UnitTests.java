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
        player player = new player("Florian", "Grognak le barbare", "ADVENTURER", 0, new ArrayList<>());
        addMoney(100);
        assertThat(player.money, is (value: 100));

     }

      @Test
    @DisplayName("Impossible de faire baisser le niveau")
    void testRetrieveLevel(){
        player player = new player("Florian", "Grognak le barbare", "ADVENTURER", 100, new ArrayList<>(),level:3);


    }

    @Test
    @DisplayName("Impossible de faire baisser le niveau")
    void testRetrieveLevelV2(){
        player player = new player("Florian", "Grognak le barbare", "ADVENTURER", 100, new ArrayList<>(),level:4);
    }
    @Test 
    @DisplayName ("Impossible d'afficher le nombre d'XP ")
    void testDisplayXP(){

    }


    // TEST UPDATEPLAYER.JAVA //

    @Test 
    @DisplayName ("le joueur est ko")
    void testJoueurMort(){
        player player = new player("Florian", "Grognak le barbare", "ADVENTURER", 0, new ArrayList<>(),currenthealthpoints:0);


    }

   @Test 
    @DisplayName ("")
    void (){


    }


}
