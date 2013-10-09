import java.lang.*;
import java.util.*;

public class Deque<Item> implements Iterable<Item> 
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
            private void setItem(Item input){
                this.Item = input;
            }   
            private Item returnItem(){
                return this.item;
            }
            private Node returnNext(){
                return this.next;
            }
            private Node returnPrevious(){
                return this.previous;
            }
    }
    


    
   public Deque()                     // construct an empty deque
   {
       first = new Node();
       last = new Node();
       count = 0;
       first.setNext(last);
       last.setPrevious(first);
   }
   
   public boolean isEmpty()           // is the deque empty?
   {
       return first.returnNext().returnItem == null;
   }
   
   public int size()                  // return the number of items on the deque
   {
       return count;
   }
   
   public void addFirst(Item item)    // insert the item at the front
   {
       if (item == null) { throw new NullPointerException("NULL"); }
       Node temp = first.returnNext();
       Node newNode = new Node(item);
       first.setNext(newNode);
       newNode.setPrevious(first);
       temp.setPrevious(newNode);
       newNode.setNext(temp);
       count ++;      
   }
   
          
   public void addLast(Item item)     // insert the item at the end
   {
       if (item == null) { throw new NullPointerException("NULL"); }
       Node temp = last.returnNext();
       Node newNode = new Node(item);
       last.setPrevious(newNode);
       newNode.setPrevious(temp);
       temp.setNext(newNode);
       count ++;  
   }
         
   public Item removeFirst()          // delete and return the item at the front
   {   
       if (size() < 1) 
       {
          throw new NoSuchElementException("It is empty already.");
       }
       
       Node temp = first;
       first = first.next;
       
       if(isEmpty())
       {
           last = null;
       } else
       {
       first.previous = null;
       }
       count --;
       return temp.item;
   }
   
   
   public Item removeLast()           // delete and return the item at the end
   {  
       if (size() < 1) 
       {
          throw new NoSuchElementException("It is empty already.");
       }
       Node temp = last;
        if(count == 1)
       {
           last = null;
           first = null;
       } else
       {
       last = last.previous;
       last.next = null;
       }
       count --;
       return temp.item;
   }
   public Iterator<Item> iterator()   // return an iterator over items in order from front to end
   {
       return new ListIterator();
   }
   
   private class ListIterator implements Iterator<Item>
   {
       private Node current = first;
       
       public boolean hasNext() { return current != null;}
       
       public void remove() { throw new UnsupportedOperationException("Not supported"); }
           
       public Item next() 
       {
           if ( current == null) 
           {
               throw new NoSuchElementException("No such an element!");
           }
           Item item = current.item;
           current = current.next;
           return item;
       }
   }
   public static void main(String[] args){ 
       Deque<String> test = new Deque<String>();
       test.addFirst("s");
       test.addFirst("u");
       test.addFirst("p");
       test.addFirst("e");
       test.addFirst("r");
       test.addFirst("m");
       test.addFirst("a");
       test.addFirst("n");
       
       /*for(String s : test)*/
       System.out.println(test.removeFirst());
       System.out.println(test.removeFirst());
       System.out.println(test.removeFirst());
       System.out.println(test.removeFirst());
       System.out.println(test.removeFirst());
       System.out.println(test.removeFirst());
       
       
   }      
}