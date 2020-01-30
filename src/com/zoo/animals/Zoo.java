package com.zoo.animals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Represents animals in a zoo and display of their break/establishing
 * friendship each day followed by main method
 * 
 * @author alekhya
 *
 */
public class Zoo {

	/**
	 * Logic to display friends established and lost each day
	 * 
	 * @param animals
	 * @return
	 */
	private static void friendshipChart(Animal[] animals) {

		Set<Animal> tempRemoveSet = new HashSet<>();
		Set<Animal> tempAddSet = new HashSet<>();
		List<String> friendshipChartOutput = new ArrayList<>();

		Arrays.stream(animals).forEach(animal -> {
			removefriend(animal, tempRemoveSet, friendshipChartOutput);
		});

		Arrays.stream(animals).forEach(animal -> {
			addfriend(animals, animal, tempAddSet, friendshipChartOutput);
		});

		friendshipChartPrint(friendshipChartOutput);

	}

	/**
	 * Printing the Live one day output (formated) to console
	 * 
	 * @param friendshipChartOutput
	 * @throws NullPointerException
	 */
	static void friendshipChartPrint(List<String> friendshipChartOutput) throws NullPointerException {
		friendshipChartOutput.sort(Comparator.reverseOrder());// sorting output
																// to desired
																// order

		StringBuilder tempString = new StringBuilder();
		System.out.println("Live one day");
		friendshipChartOutput.forEach(t -> {

			if (tempString.length() == 0) {
				tempString.append(t);
				System.out.print(t);
			} else if (t.split(" ")[0].equalsIgnoreCase(tempString.toString().split(" ")[0])// comparing
																							// names
																							// of
																							// the
																							// string

					&& t.split(" ")[1].equalsIgnoreCase(tempString.toString().split(" ")[1])) {
				System.out.print(";" + t + ".\n");
				tempString.setLength(0);
			} else {
				System.out.print(".\n" + t);
				tempString.setLength(0);
				tempString.append(t);
			}

		});

		if (tempString.length() != 0)
			System.out.println(".\n");
	}

	/**
	 * Add a friend to animal in one day
	 * 
	 * @param animals
	 * @param animal
	 * @param tempAddSet
	 * @param friendshipChartOutput
	 */
	static void addfriend(Animal[] animals, Animal animal, Set<Animal> tempAddSet, List<String> friendshipChartOutput) {
		try {
			if (!tempAddSet.contains(animal)) {
				tempAddSet.add(animal);
				if (tempAddSet.size() != animals.length) {
					Animal a = getRandomElement(
							Arrays.stream(animals)
									.filter(s -> !s.equals(animal) && !animal.getFriends().contains(s)
											&& !tempAddSet.contains(s))
									.collect(Collectors.toCollection(LinkedList::new)));
					tempAddSet.add(a);
					// A is friend of B then B is friend of A
					animal.getFriends().add(a);
					a.getFriends().add(animal);
					friendshipChartOutput.add(animal.getName() + " has established friendship with " + a.getName());
					friendshipChartOutput.add(a.getName() + " has established friendship with " + animal.getName());
				}
			}
		} catch (IllegalArgumentException e) {
			System.err.println("IllegalArgumentException: value must be positive" + e);
		}

	}

	/**
	 * Remove a friend in one day
	 * 
	 * @param animal
	 * @param tempRemoveSet
	 * @param friendshipChartOutput
	 */
	static void removefriend(Animal animal, Set<Animal> tempRemoveSet, List<String> friendshipChartOutput) {
		try {
			if (!tempRemoveSet.contains(animal) && animal.getFriends() != null && animal.getFriends().size() > 0) {
				tempRemoveSet.add(animal);
				Animal a = getRandomElement(animal.getFriends());
				tempRemoveSet.add(a);
				// A lost friendship with B then B lost friendship with A
				animal.getFriends().remove(a);
				a.getFriends().remove(animal);
				friendshipChartOutput.add(animal.getName() + " has lost friendship with " + a.getName());
				friendshipChartOutput.add(a.getName() + " has lost friendship with " + animal.getName());
			}
		} catch (IllegalArgumentException e) {
			System.err.println("IllegalArgumentException: value must be positive" + e);
		}

	}

	/**
	 * display animal details
	 * 
	 * @param animals
	 */
	static void displayAnimalDetails(Animal[] animals) {
		System.out.println("Details of animals in Zoo");
		Arrays.stream(animals).sorted(Comparator.comparing(Animal::getName).reversed()).forEach(System.out::println);

	}

	/**
	 * Random selection of element based on index *
	 * 
	 * @param animalList
	 * @return Animal
	 * @throws IllegalArgumentException
	 */
	public static Animal getRandomElement(LinkedList<Animal> animalList) throws IllegalArgumentException {
		Random rand = new Random();
		return animalList != null && animalList.size() > 0 ? animalList.get(rand.nextInt(animalList.size())) : null;

	}

	/**
	 * Adding animal details in Animal[]
	 * 
	 * @return Animal[]
	 */
	static Animal[] setAnimalsInArray() {
		Animal animals[] = new Animal[7];

		try {

			animals[0] = new Dog("Dog one", "Meat", new LinkedList<>(), "Hunting dog");
			animals[1] = new Parrot("Parrot one", "Grain", new LinkedList<>(), 0.25f, false);
			animals[2] = new Chicken("Chicken one", "Corn", new LinkedList<>(), 0.75f, true);
			animals[3] = new Dog("Dog two", "Fresh meat", new LinkedList<>(), "Assistance dog");
			animals[4] = new Parrot("Parrot two", "Corn", new LinkedList<>(), 0.5f, true);
			animals[5] = new Dog("Dog three", "Pedigree", new LinkedList<>(), "Racing dog");
			animals[6] = new Chicken("Chicken two", "Corn", new LinkedList<>(), 0.75f, false);

		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Values added greater than array length" + ex);
		}

		return animals;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		try {
			String userInput;// variable to store user action input
			int day = 0;// day count

			System.out.println("Welcome to Zoo");

			Animal animals[] = setAnimalsInArray();

			do {

				displayAnimalDetails(animals);

				// logic to add and remove friends each day
				System.out.println("Day #" + ++day);
				friendshipChart(animals);

				System.out.println("Do you want to check next day's friendship status y/n ?");
				userInput = scan.next();

			} while ("y".equalsIgnoreCase(userInput));

		} catch (NullPointerException e) {
			System.err.println("NullPointerException: null retrieval " + e);
			e.printStackTrace();
		} catch (InputMismatchException e) {
			System.err.println("Invalid input, please provide proper input:");
			scan.nextLine();
		} catch (Exception e) {
			System.err.println("Exception :" + e);
			e.printStackTrace();
		} finally {
			scan.close();
			System.out.println("Exiting...");
			System.exit(0);
		}

	}

}
