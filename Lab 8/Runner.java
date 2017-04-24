package lab8v2;

/*Author:Victor Fernandez
 * Prof: Hossain
 * TA: Anthony
 * Last Edit: 4/17/17
 * 
 */
public class Runner {

	public static void printQueue(Queue Q) {
		//System.out.println("=============");

		for (int i = Q.getFront(); i < Q.getQUEUE_SIZE() && Q.items[i] != null; i++)
			System.out.print(Q.items[i] + " ");

		System.out.println();
		// System.out.println("=============");
		// int s = Q.size();
		// for (int i = 0; i<s; i ++){
		// int temp = (int)Q.dequeue();
		// Q.enqueue(temp);
		// System.out.println(temp + " ");
		// }

	}

	public static void reverseQueue(Queue Q) {

		Queue reverseQ = new Queue();

		for (int i = Q.getBack(); i < Q.getQUEUE_SIZE(); i++)
			reverseQ.enqueue(Q);
			//System.out.println(Q.items[i] + " ");
		//System.out.println(reverseQ);

		// int s = Q.size();
		// for (int i = 0; i<s; i++){
		// int temp = (int)Q.dequeue();
		// Q.enqueue(temp);
		// System.out.println(temp + " ");
		// }
	}

	public static void main(String[] args) {
		Queue Q = new Queue();

		 //Q.dequeueAll();
		for (int i = 1; i <= 5; i++) {
			Q.enqueue(i * 10);
			// printQueue(Q);
		}
		System.out.println("My queue is as follows");
		printQueue(Q);

		System.out.println("I'm going to dequeue an element");
		System.out.println("My queue is as follows");
		Q.dequeue();
		printQueue(Q);

		System.out.println("I'm going to reverse my Queue");
		System.out.println("My queue is as follows");
		reverseQueue(Q);

		System.out.println("I'm going to enqueue 60");
		System.out.println("My queue is as follows");
		Q.enqueue(60);
		printQueue(Q);

		System.out.println("I'm going to enqueue 70");
		System.out.println("My queue is as follows");
		Q.enqueue(70);
		printQueue(Q);

		System.out.println("I'm going to reverse my queue");
		System.out.println("My queue is as follows");
		reverseQueue(Q);
		
		

	}

}