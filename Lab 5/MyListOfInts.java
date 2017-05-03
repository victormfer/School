package lab5;

public class MyListOfInts {
	public int firstInt;
	public MyListOfInts next; // changed restOfInts to next because its easier

	public MyListOfInts() {
		next = null;
	}

	public MyListOfInts(int value) {
		firstInt = value;
	}

	public MyListOfInts(int value, MyListOfInts n) {
		firstInt = value;
		next = n;
	}

}
