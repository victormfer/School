package lab7;

import java.util.Random;

/*
 * Author: Victor Fernandez
 * Prof: Hossain
 * TA: Anthony
 * Last Edit: 4/10/17
 */
public class Runner1 {
	public static void main(String[] args) {
		Cube[] cubesForBubbleSort = generateCubesArray(20);
		Cube[] cubesForSelectionSort = copyArray(cubesForBubbleSort);

		System.out.println("Array before Bubble Sort: ");
		printCubes(cubesForBubbleSort);
		System.out.println("\nArray after Bubble Sort: ");
		bubbleSort(cubesForBubbleSort);
		printCubes(cubesForBubbleSort);

		// System.out.println("---------------------------");

		System.out.println("\nArray before Selection Sort: ");
		printCubes(cubesForSelectionSort);
		System.out.println("\nArray after Selection Sort: ");
		selectionSort(cubesForSelectionSort);
		printCubes(cubesForSelectionSort);
	}

	public static Cube[] generateCubesArray(int arraySize) {
		Cube[] cubes = new Cube[arraySize];

		Random random = new Random();
		for (int i = 0; i < cubes.length; i++) {
			double length = random.nextDouble() * 100 + 1;
			double width = random.nextDouble() * 100 + 1;
			double height = random.nextDouble() * 100 + 1;
			cubes[i] = new Cube(length, width, height);
		}

		return cubes;
	}

	public static void printCubes(Cube[] cubes) {
		for (Cube c : cubes) {
			System.out.println(c);
		}
	}

	public static Cube[] copyArray(Cube[] cubes) {
		Cube[] cubesCopy = new Cube[cubes.length];
		for (int i = 0; i < cubesCopy.length; i++) {
			cubesCopy[i] = cubes[i];
		}

		return cubesCopy;
	}

	public static void bubbleSort(Cube[] cubes) {
		for (int i = 0; i < cubes.length; i++) {
			for (int j = 0; j < cubes.length - 1; j++) {
				if (cubes[j].getVolume() > cubes[j + 1].getVolume()) {
					Cube tmp = cubes[j];
					cubes[j] = cubes[j + 1];
					cubes[j + 1] = tmp;
				}
			}
		}
	}

	public static void selectionSort(Cube[] cubes) {
		for (int i = 0; i < cubes.length - 1; i++) {
			double currentMinVolume = cubes[i].getVolume();
			int currentMinIndex = i;

			for (int j = i + 1; j < cubes.length; j++) {
				if (currentMinVolume > cubes[j].getVolume()) {
					currentMinVolume = cubes[j].getVolume();
					currentMinIndex = j;
				}
			}

			if (currentMinIndex != i) {
				Cube tmp = cubes[currentMinIndex];
				cubes[currentMinIndex] = cubes[i];
				cubes[i] = tmp;
			}
		}
	}
}
