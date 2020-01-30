package com.zoo.animals;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suit to test all the test cases at once. This includes all the test
 * classes that needs to be executed
 * 
 * @author alekhya
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ ZooTest.class, ZooRemoveFriendTest.class })
public class AllTests {

}
