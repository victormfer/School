package lab6;

/* Author: Victor Fernandez
 * Prof: Hossain
 * TA: Anthony 
 * Last Edit: 3/27/17
 */

public class ListOperations {
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {

		MyListOfInts t = null;

		for (int i = 0; i < 5; i++) {
			// ran = (int) (100 * Math.random());
			int ran = i + 2;
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

		System.out.println("Remove 3");
		MyListOfInts tt = removeANumberFromMyList(t, 3);

		System.out.println("All numbers in the new list:");
		printMyList(tt);
		System.out.println();

		System.out.println("All numbers in the previous list:");
		printMyList(t);
		System.out.println();

		System.out.println("Insert a number in a position of the new list:");
		tt = insertANumberIntoMyList(tt, 20, 2);
		printMyList(tt);
		System.out.println();

		System.out.println("Values obtained for the special recursive method:");
		reportOnValues(tt);
		System.out.println(reportOnValues(tt));

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

		// print(m.firstInt + " ", false);

		return finalPointer;

	}

	/*
	 * Write a recursive method to remove the first occurrence of a specific
	 * number from a list. As an example, if your list initially contains 20 5
	 * 10 3 5 1 and your removee is 5, the returned list should contain 20 10 3
	 * 5 1 after the removal. Return a new head. You must make sure that the
	 * parameter list remains intact after returning the new list to the main
	 * method. This method cannot contain any loop.
	 */
	public static MyListOfInts removeANumberFromMyList(MyListOfInts m, int removee) {
		if (m == null)
			throw new RuntimeException("Removee not found");
		if (m.firstInt == removee)
			return m.next;
		return new MyListOfInts(m.firstInt, removeANumberFromMyList(m.next, removee));

	}

	/*
	 * Write a recursive method to insert a number (insertee) into a specific
	 * position of a list. Positions start from 0 (that is, the position of the
	 * head of a list is 0). This method cannot contain any loop (that is, uses
	 * of for, while, do-while are prohibited).
	 */
	public static MyListOfInts insertANumberIntoMyList(MyListOfInts m, int insertee, int position) {
		MyListOfInts newNode = new MyListOfInts(insertee);
		if (position == 1) {
			newNode.next = m;
			m = newNode;
			return newNode;
		} else {
			MyListOfInts previous = m;
			int count = 1;
			if (count < position - 1) {
				previous = previous.next;
				count++;
			}
			MyListOfInts current = previous.next;
			newNode.next = current;
			previous.next = newNode;
			return m;
		}
	}

	/*
	 * Write a recursive method named reportOnValues that will use each value in
	 * a list to compute a recursive formula implemented in the method
	 * specialRecursiveFunction. This method cannot contain any loop.
	 */
	public static double reportOnValues(MyListOfInts m) {

		if (m == null)
			return 0;
		else
			return specialRecursiveFunction(m.firstInt) + reportOnValues(m.next);

		// System.out.print(specialRecursiveFunction(m.firstInt)
		// +reportOnValues(m.next));
		//System.out.println(specialRecursiveFunction(m.firstInt));
		//System.out.println(reportOnValues(m.next));

	}

	/* This method cannot contain any loop */
	public static double specialRecursiveFunction(int x) {
		if (x == 1)
			return 0;
		else if (x % 2 == 1)
			return 1 + specialRecursiveFunction(x - 1);
		else
			return 1 + specialRecursiveFunction(x / 2);

	}

}
