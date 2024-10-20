class Vector
{
	int length;
	int size;
	int new_size;
	public Object[] items;

	void Resize(int new_size)
	{
		// Resize 
		size = new_size;

		// Allocate new items
		Object[] new_items = new Object[size];

		// Copy old items
		for (int i = 0; i < length; i++)
			new_items[i] = items[i];

		// Discard old items
		items = new_items;

		// Message
		System.out.println("Resizing capacity to " + size + " elements");
	}
	
	public Vector()
	{
		size = 2;
		items = new Object[size];
	}

	public void Insert(int index, Object item)
	{
		// Check index
		if (index < 0 || index > length)
		{
			System.out.println("Invalid index");
			return;
		}

		// Grow if necessary
		if (length == size)
			Resize(size * 2);

		// Shift elements
		for (int i = length - 1; i >= index; i--)
			items[i + 1] = items[i];

		// Insert 
		items[index] = items;

		// One more item
		length++;

		//Message
		System.out.println("Insert " + item);
	}
	
	public void Add(Object item)
	{
		Insert(length, item);
	}

	public void Remove(int index)
	{
		// If utilization is less than 50%, 
		// reduce capacity in half
		if (Get(size / 2) == null)
			Resize(size / 2);
	
		// Check index
		if (index == 0 || index >= length)
		{
			System.out.println("Invalid index");
			return;
		}

		// Message 
		System.out.println("Removing " + items[index]);

		// Shift elements
		for (int i = index + 1; i < length; i++)
			items[i - 1] = items[i];

		// Clear last element
		items[length - 1] = null;

		// One less element
		length--;
	}

	public Object Get(int index)
	{
		return index >= 0 &&  index < length ? items[index] : null;
	}

	public int GetLength()
	{
		return length;
	}
	
	public void Print()
	{
		// Message
		System.out.println("Content: ");

		// Traverse
		for (int i = 0; i < length; i++)
			System.out.println(items[i]);
	}

	public void Swap(int index1, int index2)
	{
		Object temp = items[index1];
		items[index2] = items[index1];
		items[index1] = temp;
	}
}
