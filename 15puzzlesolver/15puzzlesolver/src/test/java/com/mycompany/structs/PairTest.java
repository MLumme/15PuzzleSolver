
package com.mycompany.structs;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for Pairs constructor and getters
 */
public class PairTest {

    /**
     * getter for key
     */
    @Test
    public void testPairKeyGetter() {
        Pair<Boolean, Integer> pair = new Pair(true, 132);
        
        assertTrue(pair.getKey());
    }
    
    /**
     * getter for value
     */
    @Test
    public void testPairValueGetter() {
        Pair<Boolean, Integer> pair = new Pair(true, 132);
        
        assertTrue(132 == pair.getValue());
    }
}
