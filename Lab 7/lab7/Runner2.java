package lab7;

import java.util.Date;

/*
 * Author: Victor Fernandez
 * Prof: Hossain
 * TA: Anthony
 * Last Edit: 4/10/17
 */
public class Runner2 {
	public static void main(String[] args) {
		testSpeed(2000);
		testSpeed(3000);
		testSpeed(4000);
		testSpeed(5000);
		testSpeed(6000);
		testSpeed(7000);
	}

	private static void testSpeed(int arraySize) {
		System.out.println("For " + arraySize + " cubes: ");
		System.out.print("Bubble sort time = " + getTimeForBubbleSort(arraySize));
		System.out.println("  Selection sort time = " + getTimeForSelectionSort(arraySize) + "\n");
	}


	private static long getTimeForBubbleSort(int arraySize) {
		Cube[] cubes = Runner1.generateCubesArray(arraySize);

		long startTime = new Date().getTime();
		Runner1.bubbleSort(cubes);
		long endTime = new Date().getTime();

		return endTime - startTime;
	}

	private static long getTimeForSelectionSort(int arraySize) {
		Cube[] cubes = Runner1.generateCubesArray(arraySize);

		long startTime = new Date().getTime();
		Runner1.selectionSort(cubes);
		long endTime = new Date().getTime();

		return endTime - startTime;
	}
}
