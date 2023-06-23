package com.Galaxy.junit3.test;

import junit.fparamework.Test;
import junit.fparamework.TestSuite;
import junit.textui.TestRunner;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.Galaxy.junit3.test");
		//$JUnit-BEGIN$
		suite.addTestSuite(AccountService3Testcase.class);
		//$JUnit-END$
		return suite;
		
	}
	public static void main(String args[]){
		junit.textui.TestRunner.run(suite());
	}

}
