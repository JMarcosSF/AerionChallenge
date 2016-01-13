package com.challenge.aerion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
extends TestCase
{
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest( String testName )
	{
		super( testName );
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {    	
		return new TestSuite( AppTest.class );
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		int N = 0;
		assertTrue(testInput(N));
		
		N = -10;
		assertTrue(testInput(N));
		
		System.out.println("Running unit tests on recursive method.");
		int testRounds = 45;
		for(int i = 1; i <= testRounds; i++) {			
			N = i;
			assertTrue(testInput(N));
		}
		
	}

	// Test to validate input
	private boolean testInput(final int n) {
		if(n == 0) {
			if(App.calculateJumpCombinations(n) == 0) {
				return true;
			}
		}else if(n < 0) {
			if(App.calculateJumpCombinations(n) == -1) {
				return true;
			}
		}else if(n > 0) {
			long appCombos = App.calculateJumpCombinations(n);
			long testCombos = this.calculateJumpCombinations(n);
			
			if(appCombos == testCombos) {
				return true;
			}
		}

		return false;
	}

	// Standard version of recursive fibonacci method.
	// Using this to test with modified application version.
	private long calculateJumpCombinations(int n) {
		if (n == 1 || n == 2) {
			return n;
		}
		long combinations = calculateJumpCombinations(n - 1) + calculateJumpCombinations(n - 2);
		return combinations;
	}

}
