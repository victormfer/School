package lab5;

/* Author: Victor Fernandez
 * Prof: Hossain
 * TA: Anthony 
 * Last Edit: 3/10/17
 */

public class ListOperations {

	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {

		MyListOfInts t = null;

		for (int i = 0; i < 5; i++) {
			int ran = (int) ( 100 * Math.random());
			// ran = i + 2;
			t = new MyListOfInts(ran, t);
		}

		System.out.println("All numbers in the list:");
		printMyList(t);
		System.out.println("\nSum = " + sumOfMyList(t));
		System.out.println("Max = " + maxOfMyList(t));
		System.out.println("Length = " + lengthOfMyList(t));
		System.out.println("All numbers in the reversed list:");
		t = reverseMyList(t);
		printMyList(t);
		System.out.println();

	}

	public static void print(Object text, Boolean line) {

		if (line) {
			System.out.println(text);
		} else {
			System.out.print(text);
		}
	}

	/*
	 * Write a recursive method to print all the numbers separated by spaces.
	 * This method cannot contain any loop (that is, uses of for, while, do
	 * while are prohibited).
	 */
	public static MyListOfInts printMyList(MyListOfInts m) {

		if (m == null)
			return null;

		print(m.firstInt + " ", false);

		return printMyList(m.next);

	}

	/*
	 * Write a recursive method to retrieve the sum of all the numbers in a
	 * list. This method cannot contain any loop (that is, uses of for, while,
	 * do while are prohibited).
	 */
	public static int sumOfMyList(MyListOfInts m) {

		if (m == null)
			return 0;

		return sumOfMyList(m.next) + m.firstInt;
	}

	/*
	 * Write a recursive method to retrieve the largest number from the list.
	 * Assume that there is at least one number in the given list when the
	 * method is called from the main function. This method cannot contain any
	 * loop (that is, uses of for, while, do while are prohibited).
	 */
	public static int maxOfMyList(MyListOfInts m) {

		if (m == null)
			return max;

		if (max < m.firstInt) {
			max = m.firstInt;
		}

		return maxOfMyList(m.next);
	}

	/*
	 * Write a recursive method to compute the length of a list. This method
	 * cannot contain any loop (that is, uses of for, while, do while are
	 * prohibited).
	 */
	public static int lengthOfMyList(MyListOfInts m) {
		if (m == null)
			return 0;

		return lengthOfMyList(m.next) + 1;
	}

	/*
	 * Write a recursive method named reverseMyList that will reverse a given
	 * linked list m. Return the head of the reversed linked list. It is fine if
	 * you need to modify the given linked list to obtain the reversed one. The
	 * method reverseMyList may not contain any loop.
	 */
	public static MyListOfInts reverseMyList(MyListOfInts m) {

		if (m == null || m.next == null)
			return m;

		MyListOfInts pointer = m.next;
		m.next = null;

		MyListOfInts finalPointer = reverseMyList(pointer);

		pointer.next = m;

		//print(m.firstInt + " ", false);

		return finalPointer;

	}

}
