/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_oop;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author norbulama
 */
public class Final_oopTest {
    
    public Final_oopTest() {
    }
    

    /**
     * Test of setcharacter method, of class Final_oop.
     */
    @Test
    public void testSetcharacter() {
        ArrayList<String> characters = null;
        Final_oop.setcharacter(characters);
        assertEquals(characters, Final_oop.getcharacters());
        
    }

    /**
     * Test of getcharacters method, of class Final_oop.
     */
    @Test
    public void testGetcharacters() {
        ArrayList<String> expResult = new ArrayList<>(Arrays.asList("Black Jack","El Cringo","Apacke Kid"));
        Final_oop.setcharacter(expResult);
        ArrayList<String> result = Final_oop.getcharacters();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setroles method, of class Final_oop.
     */
    @Test
    public void testSetroles() {
        ArrayList<String> roles = null;
        Final_oop.setroles(roles);
        assertEquals(roles, Final_oop.gteroles());
    }

    /**
     * Test of gteroles method, of class Final_oop.
     */
    @Test
    public void testGteroles() {
        ArrayList<String> expResult = new ArrayList<>(Arrays.asList("one","Two"));
        Final_oop.setroles(expResult);
        ArrayList<String> result = Final_oop.gteroles();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setHP method, of class Final_oop.
     */
    @Test
    public void testSetHP() {
        ArrayList<Integer> HP = new ArrayList<>(Arrays.asList(2,3,4));
        Final_oop.setHP(HP);
        assertEquals(HP, Final_oop.getHP());
    }

    /**
     * Test of getHP method, of class Final_oop.
     */
    @Test
    public void testGetHP() {
        ArrayList<Integer> expResult = new ArrayList<>(Arrays.asList(2,3,4));
        Final_oop.setHP(expResult);
        ArrayList<Integer> result = Final_oop.getHP();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setDice method, of class Final_oop.
     */
    @Test
    public void testSetDice() {
        ArrayList<String> dice = new ArrayList<>(Arrays.asList("one","Two"));
        Final_oop.setDice(dice);
        assertEquals(dice,Final_oop.getDice());
    }

    /**
     * Test of getDice method, of class Final_oop.
     */
    @Test
    public void testGetDice() {
        ArrayList<String> expResult = new ArrayList<>(Arrays.asList("one","Two"));
        Final_oop.setDice(expResult);
        ArrayList<String> result = Final_oop.getDice();
        assertEquals(expResult, result);
        
    }

    
}
