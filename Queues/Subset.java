public class Subset
{
	public static void main(String[] args)
	{
		int k = Integer.parseInt(args[0]);
		RandomizedQueue<String> r = new RandomizedQueue<String>();

		while(!StdIn.isEmpty()) 
		{
			String item = StdIn.readString();
			r.enqueue(item);
		}

		while((!r.isEmpty())&&(k>0)) 
		{
			System.out.println(r.dequeue());
			k--;
		}	  
	}
}