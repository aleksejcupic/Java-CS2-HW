class Tree
{
	Node root;

	// Given a key, return the node containing it, or null if the key is not 
	// present in the tree. Nodes are not exposed to the user - this is a private auxillary function.
	Node SearchNode(Comparable key)
	{
		// Start at the root
		Node node = root;

		// Traverse tree
		while (node != null)
		{
			if (key.compareTo(node.GetKey()) == 0)
				return node;
			else if (key.compareTo(node.GetKey()) < 0)
				node = node.left;
			else 
				node = node.right;
		}

		// Not found
		return null;
	}

	// Given a key, return data associated with it, or null if the key is
	// not present in the tree.
	public Object Search(Comparable key)
	{
		// Find node
		Node node = SearchNode(key);

		//Return associated data or null
		return node == null ? null : node.GetData();
	}

	// Return the node containing the minimum key in the subtree starting
	// at the node passed in the argument, or null if that subtree is empty.
	Node GetMinNode(Node node)
	{
		// Go down the left branch
		while (node != null && node.left != null)
			node = node.left;

		// Return it
		return node;
	}

	// Return the data associated with the minimum node in the tree, or null if
	// the tree is empty.
	public Object GetMin()
	{
		// Get minimum node starting at the root
		Node node = GetMinNode(root);
		
		// Return associated data or null
		return node == null ? null : node.data;
	}

	// Return the node containing the maximum key in the subtree starting
	// at the node passed in the argument, or null if that subtree is empty.
	Node GetMaxNode(Node node)
	{
		// Go down the right branch
		while (node != null && node.right != null)
			node = node.right;

		// Return it 
		return node;
	}

	// Return the data associated with the maximum node in the tree, or null if
	// the tree is empty.
	public Object GetMax()
	{
		// Get maximum node starting at the root
		Node node = GetMaxNode(root);

		// Return associated data or null
		return node == null ? null : node.data;
	}

	// Return the successor node for the node passed as an argument, or null
	// if the node passed as an argument is the last. This is an 
	// auxillary private function.
	Node GetSuccessorNode(Node node)
	{
		// Case 1 - Node has a right child
		if (node.right != null)
			return GetMinNode(node.right);

		// Case 2 - node has no right child
		Node parent = node.parent;
		while (parent != null && parent.left != node)
		{
			// Go one level up
			node = parent;
			parent = parent.parent;
		}
		
		// We found a node that is the left child of its parent,
		// or we reached the root. Either way, return the value of
		// variable 'parent'.
		return parent;
	}

	// Return the successor data of the given key, or null if the key is
	// the last, or is not present.
	public Object GetSuccessor(Comparable key)
	{
		// Find node
		Node node = SearchNode(key);

		// Check if key is not present
		if (node == null)
			return null;

		// Get successor node
		node = GetSuccessorNode(node);

		// Return associated data or null
		return node == null ? null : node.GetData();
	}

	// Return the predecessor node for the node passed as an argument, or null 
	// if the node passed as an argument is the last. This is an 
	// auxillary private function.
	Node GetPredecessorNode(Node node)
	{
		// Case 1 - Node has a left child
		if (node.left != null)
			return GetMaxNode(node.left);
		
		// Case 2 - node has no right child
		Node parent = node.parent;
		while (parent != null && parent.right != node)
		{
			// Go one level up
			node = parent;
			parent = parent.parent;
		}

		// We found a node that is the right child of its parent,
		// or we reached the root. Either way, return the value of
		// variable 'parent'.
		return parent;
	}

	// Return the predecessor data of the given key, or null if the key is
	// the last, or is not present.
	public Object GetPredecessor(Comparable key)
	{
		// Find node
		Node node = SearchNode(key);

		// Check if key is not present
		if (node == null)
			return null;

		// Get predecessor node
		node = GetPredecessorNode(node);

		// Return associated data or null
		return node == null ? null : node.GetData();
	}

	public void Insert(Comparable key, Object data)
	{
		// Create new node
		Node node = new Node(key, data);

		// Walk down the tree
		Node parent = null;
		Node child = root;
		while (child != null)
		{
			// Parent goes down
			parent = child;

			// Child goes down
			if (key.compareTo(child.GetKey()) < 0)
				child = child.left;
			else if (key.compareTo(child.GetKey()) > 0)
				child = child.right;
			else 
				throw new RuntimeException("Duplicate key");
		}

		// Hang new node from parent
		node.parent = parent;
		if (parent == null)
			root = node;
		else if (key.compareTo(parent.GetKey()) < 0)
			parent.left = node;
		else 
			parent.right = node;
	}

	// Print the data associated with all nodes in the subtree that starts at the
	// node passed in the argument. The printed objects are sorted by their keys.
	// This is a private auxillary function.
	void PrintNode(Node node)
	{
		// Ignore if null
		if (node == null)
			return;

		// Print left subtree
		PrintNode(node.left);

		// Print current node key
		System.out.println(node.GetKey());

		// Print current node
		System.out.println(node.GetData());

		// Print right subtree
		PrintNode(node.right);
	}

	// Print all objects in the tree in the order dictated by their keys.
	public void Print()
	{
		PrintNode(root);
	}

	// Replace the subtree rooted at node 'u' with the subtree rooted at node 'v',
	// or with null. This is an auxillary private function.
	void Transplant(Node u, Node v)
	{
		// Update downward reference
		if (u.parent == null) // or (u == root)
		{
			// Case a) Node 'u' is the root
			root = v;
		}
		else if (u == u.parent.left)
		{
			// Case b) Node 'u' is the left child of its parent
			u.parent.left = v;
		}
		else 
		{
			// Case c) Node 'u' is the right child of its parent
			u.parent.right = v;
		}

		// Update upward reference
		if (v != null)
			v.parent = u.parent;
	}

	// Remove the given node. This is an auxiliary private function.
	void RemoveNode(Node node)
	{
		// Distinguish 4 cases
		if (node.left == null)
		{
			// Case a) Node has no left child
			Transplant(node, node.right);
		}
		else if (node.right == null)
		{
			// Case b) Node has no right child
			Transplant(node, node.left);
		}
		else 
		{
			// Check successor
			Node successor = GetMinNode(node.right);
			if (successor == node.right)
			{
				// Case c) Node's successor is its right child
				Transplant(node, successor);
				successor.left = node.left; // Downward reference
				successor.left.parent = successor; // Upward reference
			}
			else 
			{
				// Case d) Node's successor is not its right child
				Transplant(successor, successor.right);
				Transplant(node, successor);
				successor.left = node.left;
				successor.left.parent = successor;
				successor.right = node.right;
				successor.right.parent = successor;
			}
		}
	}

	public void Remove(Comparable key)
	{
		// Find node
		Node node = SearchNode(key);

		// Check if present
		if (node == null)
			throw new RuntimeException("Key not found");
	
		// Remove it
		RemoveNode(node);
	}

	// Returns the height of a node
	int GetNodeHeight(Node node)
	{
		// Base case if the node is null
		if (node == null)
			return 0;

		else 
		{
			// Determine height of left and right subtrees
			int leftheight = GetNodeHeight(node.left);
			int rightheight = GetNodeHeight(node.right);
		
			// Pick longer subtree
			if (leftheight > rightheight)
				return leftheight + 1;
			else
				return rightheight + 1;
		}
	}
			
	public int GetHeight(Comparable key)
	{
		int height = GetNodeHeight(SearchNode(key));
		if (height == 0)
			return -1;
		else 
			return height;
	}
	
	// Overload function that return height of entire tree
	public int GetHeight()
	{
		return GetHeight(root.key);
	}
}
