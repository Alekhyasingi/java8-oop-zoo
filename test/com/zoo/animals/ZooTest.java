package com.zoo.animals;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class ZooTest {
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

	}

	@Test
	public void testSetAnimalsInArrayLength() {
		assertEquals("Removing 1 fruit from list", 7, Zoo.setAnimalsInArray().length);
	}

	@Test
	public void testSetAnimalsInArray() {
		assertEquals("Setting elements in Array", Arrays.toString(animals), Arrays.toString(Zoo.setAnimalsInArray()));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testSetAnimalsInArrayException() {
		Zoo.setAnimalsInArray()[8] = new Animal("animal", "Corn", new LinkedList<>());
	}

	/*
	 * @Test(expected = IllegalArgumentException.class) public void
	 * testGetRandomElemenException() {
	 * 
	 * Zoo.getRandomElement(new LinkedList<Animal>()); }
	 * 
	 * @Test(expected = NullPointerException.class) public void
	 * testGetRandomElemenNullException() {
	 * 
	 * Zoo.getRandomElement(null); }
	 */

	@Test
	public void testGetRandomElement() {
		assertTrue("Random element retrieval", Arrays.asList(animals).contains(
				Zoo.getRandomElement(Arrays.stream(animals).collect(Collectors.toCollection(LinkedList::new)))));
	}

	@Test(expected = NullPointerException.class)
	public void testDisplayAnimalDetailException() {
		Zoo.displayAnimalDetails(null);
	}

	@Test(expected = NullPointerException.class)
	public void testDisplayAnimalDetail() {
		Zoo.displayAnimalDetails(null);
	}

	@Test
	public void testAddfriendSize() {
		List<String> friendshipChartOutput = new ArrayList<>();
		Zoo.addfriend(animals, animals[0], new HashSet<Animal>(), friendshipChartOutput);
		assertEquals("Add animal output set size ", 2, friendshipChartOutput.size());
	}

	@Test
	public void testAddfriendList() {
		List<String> friendshipChartOutput = new ArrayList<>();
		Zoo.addfriend(animals, animals[0], new HashSet<Animal>(), friendshipChartOutput);
		assertEquals("Added animal in friends list", 1, animals[0].getFriends().size());
	}

	@Test
	public void testAddfriend() {
		List<String> friendshipChartOutput = new ArrayList<>();
		Zoo.addfriend(animals, animals[0], new HashSet<Animal>(), friendshipChartOutput);
		assertTrue("Add animal from animals list",
				(Arrays.asList(animals).toString().indexOf(animals[0].getFriends().get(0).toString())) > 0);
	}

	@Test(expected = NullPointerException.class)
	public void TestfriendshipChartPrintException() {
		Zoo.friendshipChartPrint(null);
	}

}
