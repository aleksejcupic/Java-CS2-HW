import java.util.*;
class Test 
{
	public static void main(String args[])
	{
		// Instantiate arguments
		String algorithm = args[0];
		String size = args[1];
		
		// Change size to int
		int n = Integer.parseInt(size);
		
		// Instantiate array
		int[] v = new int[n];

		// Fill with random numbers
		for (int i = 0; i < v.length; i++)
		{
			Random random = new Random();
			v[i] = random.nextInt(100);
		}
	
		// If algorithm selected is Selection
		if (algorithm.equals("selection"))
		{
			SelectionSort.Sort(v);
		}

		// If algorithm selected is Merge
		if (algorithm.equals("merge"))
		{
			MergeSort.Sort(v);
		}
	}
}
