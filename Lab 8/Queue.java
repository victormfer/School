package lab8v2;

public class Queue {
	public int QUEUE_SIZE = 7;
    public Object[] items;
    private int front, back, count;

    public Queue() {
        items = new Object[QUEUE_SIZE];
        front = 0;
        back = QUEUE_SIZE - 1;
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == QUEUE_SIZE;
    }

    public void enqueue(Object newItem) {
        if (!isFull()) {
            back = (back + 1) % QUEUE_SIZE;
            items[back] = newItem;
            count++;
            return;
        } 
        else if (isFull()){
            QUEUE_SIZE = QUEUE_SIZE * 2;
            System.out.println("Queue is full; doubling its size.");
            System.out.println("New max. Size is now: " + QUEUE_SIZE);
         
            back = (back + 1) % QUEUE_SIZE;
            items[back] = newItem;
            count++;
            return;
        }else
            System.out.println("Trying to enqueue into full queue");
    }

    public Object dequeue() {
        if (!isEmpty()) {
            Object queueFront = items[front];
            front = (front + 1) % QUEUE_SIZE;
            count--;
            return queueFront;
        } else
            System.out.println("Trying to dequeue from empty queue");
        return null;
    }

    public void dequeueAll() {
        items = new Object[QUEUE_SIZE];
        front = 0;
        back = QUEUE_SIZE - 1;
        count = 0;
    }

    public Object peek() {
        if (!isEmpty()) {
            return items[front];
        } else
            System.out.println("Trying to peek with empty queue");
        return null;
    }

    public int size() {
        return count;
    }

    public int getBack(){
        return this.back;
    }

    public int getFront() {
        return this.front;
    }

    public int getQUEUE_SIZE(){
        return QUEUE_SIZE;
    }

}
