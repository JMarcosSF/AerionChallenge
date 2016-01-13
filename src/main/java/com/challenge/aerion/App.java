package com.challenge.aerion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Aerion Coding Challenge
 * 
 * A toad only moves forward, but it can move in steps that are 1 inch long or in jumps that 
 * are 2 inches long. The toad can cover the same distance using different combinations of 
 * steps and jumps.
 * 
 * Write a method that calculates the number of different combinations the toad can use to 
 * cover a given distance. For example, a distance of 3 inches can be covered in three ways: 
 * step-step-step, step-jump, and jump-step.
 * 
 * Please use "mvn clean package" to build runnable jar.
 * This will create a file in the target directory named "AerionChallenge.jar".
 * To run, use the command java -jar AerionChallenge.jar [integer input].
 * 
 * @author jmarcos
 *
 */
public class App {

    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);
        long combinations = 0;

        if(N < 0) {
        	System.out.println("Please enter a positive integer.");
        	return;
        }
        
        combinations = calculateJumpCombinations(N);
        
    	
        System.out.println("\nThe number of different combinations the toad can use to cover a distance of " + N  + " inches: " + combinations);
    	System.out.println("\nBuilt with JDK Version: " + System.getProperty("java.version"));
    }
    
    private static Map<Long, Long> map = new HashMap<Long, Long>();
    // Initialize init data in map
    static {
        map.put(1l, 1l);
        map.put(2l, 2l);
    }

    // This method is a modified version of it's derivative fibonacci recursive method.
    // It has been modified to store already processed data within a map and retrieve that
    // data, rather than processing data which has already been processed.
    public static long calculateJumpCombinations(final long n) {
    	
    	if(n == 0) {
			return 0l;
		}else if(n < 0) {
			return -1l;
		}
    	
        if (map.containsKey(n)) {        	
        	return map.get(n);
        }

        long a, b;

        if (map.containsKey(n - 1))
            a = map.get(n - 1);
        else {
            a = calculateJumpCombinations(n - 1);
            map.put(n - 1, a);
        }

        if (map.containsKey(n - 2))
            b = map.get(n - 2);
        else {
            b = calculateJumpCombinations(n - 2);
            map.put(n - 2, b);
        }

        return a + b;
    }
    
}
