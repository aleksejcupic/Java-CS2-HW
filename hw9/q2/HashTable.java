class HashTable
{
	Node[] nodes;
	int size;
	int length;

	static final double max_load_factor = 1;
	static final int initial_size = 5;

	public HashTable()
	{
		size = initial_size;
		nodes = new Node[size];
	}

	// Return the data associated with the given key, or null if the key is
	// not present in the hash table.
	public Object Search(Object key)
	{
		// Obtain index for the key
		int index = key.hashCode() % size;

		// Traverse collision list
		for (Node node = nodes[index]; node != null; node = node.next)
			if (node.key.equals(key))
				return node.data;

		// Not found
		return null;
	}

	// Insert a pair key data into the hash table
	public void Insert(Object key, Object data)
	{
		// Check if the table must grow
		double load_factor = (double) length / size;
		if (load_factor > max_load_factor)
			Grow();

		// Create node
		Node node = new Node(key, data);

		// Calculate index in the array for the key
		int index = key.hashCode() % size;

		// Insert it at the head of the collision list
		node.next = nodes[index];
		nodes[index] = node;

		// Update lenght
		length++;
	}

	// Grow the hash table. All nodes must be repositioned according to their 
	// new hash indices based on the new table size.
	void Grow()
	{
		// Save old nodes and table size
		int old_size = size;
		Node[] old_nodes = nodes;

		// Create new table
		size = NextPrime(size);
		nodes = new Node[size];
		length = 0;

		// Message
		System.out.println("Growing hash table to " + size + " nodes");

		// Traverse old nodes
		for (int i = 0; i < old_size; i++)
		{
			for (Node node = old_nodes[i]; node != null; node = node.next)
				Insert(node.key, node.data);
		}		
	}

	// Remove the element with the given key from the hash table. If the given key
	// is not present, an exception is thrown.
	public void Remove(Object key)
	{
		// Get index for the key
		int index = key.hashCode() % size;

		// Traverse collision list 
		Node previous = null;
		Node node = nodes[index];
		while (node != null && !node.key.equals(key))
		{
			previous = node;
			node = node.next;
		}

		// Not found
		if (node == null)
			throw new RuntimeException("Key not found");

		// Delete it
		if (previous == null)
			nodes[index] = node.next;
		else
			previous.next = node.next;

		// Update length
		length--;
	}

	public void Print()
	{
		// Traverse table
		for (int i = 0; i < size; i++)
			for (Node node = nodes[i]; node != null; node = node.next)
				System.out.println(node.data);
	}

	public int GetLength()
	{
		return length;
	}

	public boolean IsPrime(int num)
	{
		// Base case
		if (num <= 1)
			return false;

		// Check if its prime and return
		for (int i = 2; i < num; i++)
		{
			if (num % i == 0)
			return false;
		}
		return true;
	}

	public int NextPrime(int size)
	{
		// For loop between the current size and largest size (1000)
		for (int i = size + 1; i < 1000; i++)
		{
			if (IsPrime(i) == true)
				return i;
		}
		return 1000;
	}
}
