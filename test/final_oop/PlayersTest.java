/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_oop;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author norbulama
 */
public class PlayersTest {
    
    public PlayersTest() {
    }

    /**
     * Test of setRole method, of class Players.
     */
    @Test
    public void testSetRole() {
        System.out.println("setRole");
        Players instance = new Players();
        instance.setRole("Sheriff");
        assertEquals("Sheriff",instance.role);
        
    }

    /**
     * Test of setCharacter method, of class Players.
     */
    @Test
    public void testSetCharacter() {
        System.out.println("setCharacter");
        
        Players instance = new Players();
        instance.setCharacter("Pablo");
        assertEquals("Pablo", instance.character);
    }

    /**
     * Test of getRole method, of class Players.
     */
    @Test
    public void testGetRole() {
        Players instance = new Players();
        String expResult = "Gundaa";
        instance.setRole(expResult);
        String result = instance.getRole();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of getCharacter method, of class Players.
     */
    @Test
    public void testGetCharacter() {
        System.out.println("getCharacter");
        Players instance = new Players();
        String expResult = "Rajesh Hamal";
        instance.setCharacter(expResult);
        String result = instance.getCharacter();
        assertEquals(expResult, result);
    }
    
}