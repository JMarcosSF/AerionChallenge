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
    	int testN = 10;
    	assertTrue(testCalculatePermutation());
    	assertTrue(testGenerateInitialAddendList(testN));
    }
    
    private boolean testGenerateInitialAddendList(final int testN) {
    	boolean testPassed = true;
    	for(String str:App.generateInitialAddendList(testN)) {
    		List<String> items = Arrays.asList(str.split(""));
    		int testSum = 0;
    		for(String item:items) {
    			testSum = testSum + Integer.parseInt(item);
    		}
    		if(testSum != testN) {
    			return false;
    		}
    	}
    	return testPassed;
    }
    
    private boolean testCalculatePermutation() {
    	String testStr = "212121";
    	App.calculatePermutation(testStr);
    	boolean permTestPassed = true;
    	for(String str:App.permsSet) {
    		if(isPerm(Integer.parseInt(testStr), Integer.parseInt(str)) == false) {
    			permTestPassed = false;
    			break;
    		}
    	}
    	return permTestPassed;
    }
    
    public static boolean isPerm(int x, int y) {
		List<Integer> lOne = intToStringArray(x);
		List<Integer> lTwo = intToStringArray(y);
		if(lOne.size() != lTwo.size()) {
			return false;
		}

		for(int str:lTwo) {
			if(!lOne.contains(str)) 
				return false;
		}

		return true;
	}
    
    public static List<Integer> intToStringArray(int num) {
		int x = num;
		List<Integer> intList= new ArrayList<Integer>();
		while (x > 0) {
			intList.add(x%10);
			x = x/10;
		}
		return intList;
	}
    
}
