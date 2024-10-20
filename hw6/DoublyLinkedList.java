class DoublyLinkedList
{
	Node head;
	Node tail;
	Node current;

	public void Head()
	{
		current = head;
		current.previous = null;
	}

	public void Tail()
	{	
		current = tail;
		current.next = null;
	}

	public void Next()
	{
		if (current != null)
		{
			current.previous = current;
			current = current.next;
		}
	}

	public void Previous()
	{
		if (current.previous != null)
		{
			current.next = current;
			current = current.previous;
		}	
	}

	public Object Get()
	{
		return current != null ? current.GetData() : null;
	}

	public void Insert(Object data)
	{
		// Create a new node
		Node node = new Node(data);

		// Set 'next' reference of new node
		node.next = current;

		// Updating 'previous' field of the inserted node
		if (current == null)
			node.previous = tail;
		else
			node.previous = current.previous;
		
		// Updating 'next' of inserted node
		node.next = current;

		// Updating 'next' of previous node
		if (current == head)
			head = node;
		else if (current == null)
			tail.next = node;
		else
			current.previous.next = node;

		// Updating 'previous' of next node
		if (current == null)
			tail = node;
		else
			current.previous = node;

		// Updating 'current' node
		current = node;
	}

	public void Print()
	{
		// Traverse the list
		for (Head(); Get() != null; Next())
			System.out.println(Get());
	}

	
}
