
package com.mycompany.util;

/**
 * Class for XORShift-RNG
 */
public class XORShift {
    private long seed;
        
    /**
     * Constructor without parameter, seed set as System.nanoTime() at creation
     */
    public XORShift() {
        this.seed = System.nanoTime();
    }
    
    /**
     * Constructor with user specified seed
     * @param seed long value to be used as seed
     */
    public XORShift(long seed) {
        this.seed = seed;
    }
    
    /**
     * XORShift-based random number generator, generator shifts 13 left,
     * 3 right, 53 left
     * @param bits length of wanted random number in bits
     * @return long random number, shifted right until number is at maximum 
     * representable with given number of bits
     */
    private long next(int bits) {
        long x = seed;
        x ^= (x << 13);
        x ^= (x >>> 3);
        x ^= (x << 53);
        
        seed = x;
        
        if (bits == 64) {
            return x;
        }
        
        return (x >>> (64 - bits));        
    }
    
    /**
     * Produces random int in approx. uniform distribution
     * @return random int
     */
    public int nextInt() {
        return (int) next(32);
    }
    
    /**
     * Produces random number between [0,n[, mostly same as similarly named 
     * Java.util.Random-method
     * @param n exclusive upper boundary for random number
     * @return random int between 0 and n.
     */
    public int nextInt(int n) {
        if (n <= 0) {
            return -1;
        }
        
        if ((n & -n) == n) {
            return (int) (n * next(31) >> 31);
        }
        
        int a, b;
        while (true) {
            a = (int) next(31);
            b = a % n;
            
            if (a - b + n - 1 >= 0) {
                break;
            }
        }
        
        return b;
    }

    /**
     *  Simply returns random long from approx. uniform distribution.
     * @return long random
     */
    public long nextLong() {
        return next(64);
    }
}
