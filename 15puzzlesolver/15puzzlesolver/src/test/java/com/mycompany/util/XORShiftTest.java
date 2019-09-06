
package com.mycompany.util;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testing class for XORShift-RNG
 */
public class XORShiftTest {

    /**
     * Tests that XORShifts NextInt() and constructor works, and same seed 
     * produces same result
    */
   
    @Test
    public void testXORShiftNextInt() {
        XORShift rand1 = new XORShift(1324L);
        int r1 = rand1.nextInt();
        
        XORShift rand2 = new XORShift(1324L);
        int r2 = rand2.nextInt();
        
        assertTrue(r1 == r2);
    }
    
    /**
        * Tests that XORShifts NextLong() and constructor works, and same seed 
     * produces same result
     */
    @Test
    public void testXORShiftNextLong() {
        XORShift rand1 = new XORShift(123456789L);
        long r1 = rand1.nextLong();
        
        XORShift rand2 = new XORShift(123456789L);
        long r2 = rand2.nextLong();
        
        assertTrue(r1 == r2);
    }
    
    /**
     * Test that both constructor without seed works, and that there aren't any
     * values outside of set limit.
     */
    @Test
    public void testXORShiftNextIntParam1() {
       double a = 0;
       XORShift rand = new XORShift();
       
       int n = 256;
       boolean error = false;
       
        for (int i = 0; i < 1e8; i++) {
            int r = rand.nextInt(n);
            
            if (r < 0 || r >= n) {
                error = true;
                break;
            }
        }
        
        assertTrue(!error);
    }
    
    /**
     * Test that both constructor with seed works, and that there aren't any
     * values outside of set limit.
     */
    @Test
    public void testXORShiftNextIntParam2() {
       double a = 0;
       XORShift rand = new XORShift(987654321L);
       
       int n = 300;
       boolean error = false;
       
        for (int i = 0; i < 1e8; i++) {
            int r = rand.nextInt(n);
            
            if (r < 0 || r >= n) {
                error = true;
                break;
            }
        }
        
        assertTrue(!error);
    }  
    
    /**
     * Test that of nextInt:s parmaeter is les or equal to 0 return is -1 denoting
     * failure
     */
    @Test
    public void testXORShiftNextIntIvalidPram() {
       XORShift rand = new XORShift(987654321L);
       
       int res = rand.nextInt(0);
       
        assertEquals(-1, res);
    } 
}
