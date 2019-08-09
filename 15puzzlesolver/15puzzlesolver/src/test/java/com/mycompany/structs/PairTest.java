
package com.mycompany.structs;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PairTest {
    
    public PairTest() {
    }

    @Test
    public void testPairKeyGetter() {
        Pair<Boolean, Integer> pair = new Pair(true, 132);
        
        assertTrue(pair.getKey());
    }
    
    @Test
    public void testPairValueGetter() {
        Pair<Boolean, Integer> pair = new Pair(true, 132);
        
        assertTrue(132 == pair.getValue());
    }
}
