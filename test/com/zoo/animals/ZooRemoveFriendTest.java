package com.zoo.animals;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ZooRemoveFriendTest {
	Animal animals[] = new Animal[7];

	@Before
	public void init() {

		animals[0] = new Dog("Dog one", "Meat", new LinkedList<>(), "Hunting dog");
		animals[1] = new Parrot("Parrot one", "Grain", new LinkedList<>(), 0.25f, false);
		animals[2] = new Chicken("Chicken one", "Corn", new LinkedList<>(), 0.75f, true);
		animals[3] = new Dog("Dog two", "Fresh meat", new LinkedList<>(), "Assistance dog");
		animals[4] = new Parrot("Parrot two", "Corn", new LinkedList<>(), 0.5f, true);
		animals[5] = new Dog("Dog three", "Pedigree", new LinkedList<>(), "Racing dog");
		animals[6] = new Chicken("Chicken two", "Corn", new LinkedList<>(), 0.75f, false);

		Zoo.addfriend(animals, animals[0], new HashSet<Animal>(), new ArrayList<>());// already
																						// tested
																						// in
																						// testAddfriend()
																						// in
																						// ZooTest.class

	}

	@Test
	public void testRemovefriendSize() {
		List<String> friendshipChartOutput = new ArrayList<>();
		Zoo.removefriend(animals[0], new HashSet<Animal>(), friendshipChartOutput);
		assertEquals("Remove animal output set size ", 2, friendshipChartOutput.size());
	}

	@Test
	public void testRemovefriend() {
		List<String> friendshipChartOutput = new ArrayList<>();
		int size = animals[0].getFriends().size();
		Zoo.removefriend(animals[0], new HashSet<Animal>(), friendshipChartOutput);
		assertTrue("Removed animal in friends list", size > animals[0].getFriends().size());
	}

}
