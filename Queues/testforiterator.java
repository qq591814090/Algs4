public class testforiterator
{
	public static void main(String[] args)
	{
		int[] test = new int[10];
		for(int i = 0; i < 10; i++){
			test[i] = i;
		}
		StdRandom.shuffle(test);
		for(int i = 0; i < 10; i++){
			System.out.println(test[i]);
		}
	}
}