import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> 
{
   private Item[] a;
   private int N = 0;
 
   public RandomizedQueue()           // construct an empty randomized queue
   {    
       a = (Item[]) new Object[2];
   }
 
   public boolean isEmpty()           // is the queue empty?
   {
    return N == 0;
   }
 
   public int size()                  // return the number of items on the queue
   {
    return N;
   }
 
   private void resize(int capacity)
   {
       assert capacity >= N;
       Item[] temp = (Item[]) new Object[capacity];
       for (int i = 0; i < N; i++)
       {
        temp[i] = a[i];
       }
       a = temp;
   }

   public void enqueue(Item item)     // add the item
   {
    if (item == null) { throw new NullPointerException("NULL"); }
       

     if (N == a.length) resize(2*a.length);
     a[N] = item; 

     N++; 

   }

   public Item dequeue()              // delete and return a random item
   {
    if (isEmpty()) throw new NoSuchElementException("RandomizedQueue underflow");
    
    int rd = StdRandom.uniform(0, N);

    Item item = a[rd];
    if (rd != N-1)
    {
      a[rd] = a[N-1];
    }

    a[N-1] = null;
    N--;
    if (N > 0 && N == a.length/4) resize(a.length/2);

    return item;
   }
   public Item sample()               // return (but do not delete) a random item
   {
    if (isEmpty()) throw new NoSuchElementException("RandomizedQueue underflow");
    int rd = StdRandom.uniform(0, N);
    Item item = a[rd];

    return item;
   }
   public Iterator<Item> iterator()   // return an independent iterator over items in random order
   {
     return new QueueIterator();
   }
   private class QueueIterator implements Iterator<Item>
   { 
      private int[] order = new int[N];
      private int current = 0;
   
      public QueueIterator()
      {
         for(int index = 0; index < N; index++ )
         {
             order[index] = index;
         }
         StdRandom.shuffle(order);
      }
     
 

      public boolean hasNext(){ return current<N;}
     
      public void remove() {
            throw new UnsupportedOperationException();
      }
     public Item next()
     {
        if (hasNext()) 
        {
            current ++;
            return a[order[current-1]];
            
        }
        else
        {
          throw new NoSuchElementException("It is empty already.");
        }

     }   
   }
}
