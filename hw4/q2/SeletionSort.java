class SelectionSort
{
	// Will return the index of the element
	static int GetMinIndex(int[] v, int left, int right)
	{
		// Assume left index contains minimum value
		int min_index = left;
		
		// Traverse remaingin elements 
		for (int i = left + 1; i <= right;i++)
			if (v[i] < v[min_index])
				min_index = i;

		// Return index of minimum value
		return min_index;
	}

	static void Swap(int[] v, int index1, int index2)
	{
		int temp = v[index1];
		v[index1] = v[index2];
		v[index2] = temp;
	}

	public static void Sort(int[] v)
	{
		// We want to run n - 1 iterations
		for (int i = 0; i < v.length - 1; i++)
		{
			// Get minimum index within unsorted region
			int min_index = GetMinIndex(v, i, v.length - 1);

			// Swap minimum value and left most value in unsorted region
			Swap(v, min_index, i);
		}
	}
}
