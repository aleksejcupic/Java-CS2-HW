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
	public Node Search(Comparable key)
	{
		// Obtain index for the key
		int index = key.hashCode() % size;

		// Traverse collision list
		for (Node node = nodes[index]; node != null; node = node.next)
			if (node.key.equals(key))
				return nodes[index];

		// Not found
		return null;
	}

	// Insert a pair key data into the hash table
	public void Insert(Comparable key, Object data)
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
		// Message
		System.out.println("Growing hash table");

		// Save old nodes and table size
		int old_size = size;
		Node[] old_nodes = nodes;

		// Create new tablet
		size = size * 2;
		nodes = new Node[size];
		length = 0;

		// Traverse old nodes
		for (int i = 0; i < old_size; i++)
			for (Node node = old_nodes[i]; node != null; node = node.next)
				Insert(node.key, node.data);
	}

	// Remove the element with the given key from the hash table. If the given key
	// is not present, an exception is thrown.
	public void Remove(Comparable key)
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

	public Object GetSuccessor(Comparable key)
	{
		// Set successor node to null
		Node successor = null;
	
		// Traverse the table
		for (int i = 0; i < size; i ++) 
		{
			for (Node node = nodes[i]; node != null; node = node.next) 
			{
				// Comparing keys 
				if (node.key.compareTo(key) <= 0)
					continue;
				
				// Check the successor 
				if (successor == null || node.key.compareTo(successor.key) < 0)
					successor = node;
			}
		}

		// Returning the successor data
		if (successor == null )
			return null;

		else
			return successor.data;
	}
}