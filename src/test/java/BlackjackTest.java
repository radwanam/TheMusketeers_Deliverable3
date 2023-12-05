/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mycompany.blackjack.StartBlackjack;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author amrra
 */
public class BlackjackTest {

    public BlackjackTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testIsPlayerHandBustGood() {
        System.out.println("IsPlayerHandBust Good");
        int handVal = 26;
        boolean expResult = true;
        boolean result = StartBlackjack.isPlayerHandBust(handVal);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsPlayerHandBustBad() {
        System.out.println("IsPlayerHandBust Bad");
        int handVal = 5;
        boolean expResult = false;
        boolean result = StartBlackjack.isPlayerHandBust(handVal);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsPlayerHandBustBoundary() {
        System.out.println("IsPlayerHandBust Boundary");
        int handVal = 21;
        boolean expResult = false;
        boolean result = StartBlackjack.isPlayerHandBust(handVal);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsDealerHandBustGood() {
        System.out.println("IsDealerrHandBust Good");
        int handVal = 26;
        boolean expResult = true;
        boolean result = StartBlackjack.isDealerHandBust(handVal);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsDealerHandBustBad() {
        System.out.println("IsDealerrHandBust Bad");
        int handVal = 5;
        boolean expResult = false;
        boolean result = StartBlackjack.isDealerHandBust(handVal);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsDealerHandBustBoundary() {
        System.out.println("IsDealerrHandBust Boundary");
        int handVal = 21;
        boolean expResult = false;
        boolean result = StartBlackjack.isDealerHandBust(handVal);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsPlayerHandBlackjackGood() {
        System.out.println("IsPlayerHandBlackjack Good");
        int playerHandVal = 21;
        int dealerHandVal = 19;
        boolean expResult = true;
        boolean result = StartBlackjack.isPlayerHandBlackjack(playerHandVal, dealerHandVal);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsPlayerHandBlackjackBad() {
        System.out.println("IsPlayerHandBlackjack Bad");
        int playerHandVal = 12;
        int dealerHandVal = 19;
        boolean expResult = false;
        boolean result = StartBlackjack.isPlayerHandBlackjack(playerHandVal, dealerHandVal);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsPlayerHandBlackjackBoundary() {
        System.out.println("IsPlayerHandBlackjack Boundary");
        int playerHandVal = 21;
        int dealerHandVal = 21;
        boolean expResult = false;
        boolean result = StartBlackjack.isPlayerHandBlackjack(playerHandVal, dealerHandVal);
        assertEquals(expResult, result);
    }
}
