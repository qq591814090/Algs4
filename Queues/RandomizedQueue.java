public class RandomizedQueue<Item> implements Iterable<Item> 
{
    private Item[] list;
    private int N;
    public RandomizedQueue()           // construct an empty randomized queue
    {
        list = (Item[]) new Object[2];
        N = 0;
    }
            
            
   public boolean isEmpty()           // is the queue empty?
   {
       return N == 0;
   }       
       
   public int size()                  // return the number of items on the queue
   {
       return N;
   }
   
   public void enqueue(Item item)     // add the item
       
   public Item dequeue()              // delete and return a random item
   public Item sample()               // return (but do not delete) a random item
   public Iterator<Item> iterator()   // return an independent iterator over items in random order
}