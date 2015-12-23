package com.challenge.aerion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
 * 
 * @author jmarcos
 *
 */
public class App {
	
	static Set<String> permsSet = new HashSet<String>();

    public static void main(String[] args) {
//    	//TODO CHANGE POM TO Java 1.8
//    	// This is to be the user's input
        int N = Integer.parseInt("3");
        
    	calculateJumpCombinations(N);
    	
        System.out.println("The number of different combinations the toad can use to cover a distance of " + N  + " inches: " + permsSet.size());
    	System.out.println("\nBuilt with JDK Version: " + System.getProperty("java.version"));
    }
    
    private static void calculateJumpCombinations(final int distance) {
    	for(String str :generateInitialAddendList(distance)) {
    		calculatePermutation(str);
    	}
    }
    
    private static List<String> generateInitialAddendList(final int targetSum) {
    	List<String> list = new ArrayList<String>();
    	String curr = generateInitialAddends(targetSum);
    	int loc = curr.length() - 1;
    	if(curr.endsWith("1")) {
    		loc = loc - 1;
    	}
    	list.add(curr);
    	while(curr.contains("2")) {
    		curr = sumListHelper(loc, curr);
    		list.add(curr);
    		loc--;
    	}

    	return list;
    }
    
    private static String generateInitialAddends(final int targetSum) {
    	StringBuilder sb = new StringBuilder();
    	if(targetSum % 2 == 0) {
			  // Set initial data to find permutations
			  for(int i = 0; i < (targetSum/2); i++) {
				  sb.append(2);
			  }
			  return sb.toString();
    	} else {
			for(int i = 0; i < (targetSum/2); i++) {
				sb.append(2);
			}
			return sb.toString() + "1";
    	}
    }
    
    private static String sumListHelper(final int loc, final String addends) {
    	StringBuilder sb = new StringBuilder(addends);
    	return sb.replace(loc, loc+1, "11").toString();
    }
    
    public  static void calculatePermutation(String s) { 
    	permHelper("", s); 
    }
    
    private static void permHelper(String prefix, String s) {
        int N = s.length();
        if (N == 0) {
        	permsSet.add(prefix);
        } else {
            for (int i = 0; i < N; i++)
            	permHelper(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N));
        }

    }
    
}
