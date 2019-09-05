
package com.mycompany.util;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testing class for XORShift-RNG
 */
public class XORShiftTest {

    /**
     * Tests that XORShifts NextInt() output average remains at least within 1e-4
     * times ints max value
     */
    @Test
    public void testXORShiftNextInt() {
        double a = 0;
        XORShift rand = new XORShift();
        
        for (int i = 0; i < 1e8; i++) {
            a += (double)rand.nextInt() / (double)1e8;
        }
        
        assertTrue(Math.abs(a) < Integer.MAX_VALUE*1e-4);
    }
    
    /**
     * Tests that XORShifts NextLong output average remains at least within 1e-4
     * times longs max value 
     */
    @Test
    public void testXORShiftNextLong() {
        double a = 0;
        XORShift rand = new XORShift();
        
        for (int i = 0; i < 1e8; i++) {
            a += (double)rand.nextLong() / (double)1e8;
        }
        
        assertTrue(Math.abs(a) < Long.MAX_VALUE*1e-4);
    }
    
    /**
     * Test that both constructor with seed works, and that there aren't any
     * values outside of set limit, and that average is approx. at the center 
     * of the interval, when n is a power of 2.
     */
    @Test
    public void testXORShiftNextIntParam1() {
       double a = 0;
       XORShift rand = new XORShift(123456789L);
       
       int n = 256;
       boolean error = false;
       
        for (int i = 0; i < 1e8; i++) {
            int r = rand.nextInt(n);
            
            if (r < 0 || r >= n) {
                error = true;
                break;
            }
            
            a += (double)r / (double) 1e8;
        }
        
        assertTrue(!error && Math.abs(128 - a) < 1);
    }
    
    /**
     * Test that both constructor with seed works, and that there aren't any
     * values outside of set limit, and that average is approx. at the center 
     * of the interval, when n is not a power of 2.
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
            
            a += (double)r / (double) 1e8;
        }
        
        assertTrue(!error && Math.abs(149.5 - a) < 1);
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
