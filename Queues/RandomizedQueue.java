public class RandomizedQueue<Item> implements Iterable<Item> 
{
  private Node first;
  private Node last;
  private int count;
    
  private class Node
  {
    Item item;
    Node previous;
    Node next;
    private Node(Item input)
    {
      this.item = input;
      this.previous = null;
      this.next = null;
    }
    
    private Node()
    {
      this.item = null;
      this.previous = null;
      this.next = null;
    }
    private void setPrevious(Node pr)
    {
      this.previous = pr;
    }
    private void setNext(Node nx)
    {
      this.next = nx;
    }
    private void setItem(Item input)
    {
      this.item = input;
    }   
    private Item returnItem()
    {
      return this.item;
    }
    private Node returnNext()
    {
      return this.next;
    }
    private Node returnPrevious()
    {
      return this.previous;
    }
  }
     
    public RandomizedQueue()           // construct an empty randomized queue
    {
       first = new Node();
       last = new Node();
       count = 0;
       first.setNext(last);
       last.setPrevious(first);
    }

  
            
            
   public boolean isEmpty()           // is the queue empty?
   {
        return first.returnNext().returnItem() == null;
   }
   }       
       
   public int size()                  // return the number of items on the queue
   {
       return count;
   }
   
   public void enqueue(Item item)     // add the item
       
   public Item dequeue()              // delete and return a random item
   public Item sample()               // return (but do not delete) a random item
   public Iterator<Item> iterator()   // return an independent iterator over items in random order
}