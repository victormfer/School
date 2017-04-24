
public class GenericStack 
{
    private Node top;
    private int size;
    public GenericStack() 
    {
        top = null;
        size=0;
    }
    public boolean isEmpty()
    {
        return ( top == null );
    }
    public void push(Object newItem)
    {
        top = new Node(newItem, top);
        size++;
    }
public Object pop()
{
    if (isEmpty())
    {
        System.out.println("Trying to pop when stack is empty");
        return null;
    }
    else
    {
        Node temp = top;
        top = top.next;
        size--;
        return temp.info;
       
    }
}
void popAll()
{
    top = null;
    size=0;
}
public int getSize()
{
    return size;
}
public Object peek()
{
    if (isEmpty())
    {
        //System.out.println("Trying to peek when stack is empty");
        return null;
    }
    else
    {
        return top.info;
    }
}
} 

