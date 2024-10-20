class Test
{
	public static void main(String args[])
	{			
		// Instantiate 3 binary search trees
		// Data values set to null
	
		// Create nodes
		Node n1 = new Node(1, null);
		Node n2 = new Node(2, null);
		Node n3 = new Node(3, null);
		Node n5 = new Node(5, null);
		Node n7 = new Node(7, null);
		Node n8 = new Node(8, null);
		Node n10 = new Node(10, null);
	
		// First Binary Search Tree
		// Create tree
			Tree tree1 = new Tree();

		// Insert nodes to tree 1
		tree1.Insert(n5.GetKey(), n5.GetData());
		tree1.Insert(n2.GetKey(), n2.GetData());
		tree1.Insert(n8.GetKey(), n8.GetData());
		tree1.Insert(n1.GetKey(), n1.GetData());
		tree1.Insert(n3.GetKey(), n3.GetData());
		tree1.Insert(n7.GetKey(), n7.GetData());
		tree1.Insert(n10.GetKey(), n10.GetData());
			
		// Second Binary Tree
		// Create tree
		Tree tree2 = new Tree();
		
		// Insert nodes to tree 2
		tree2.Insert(n8.GetKey(), n8.GetData());
		tree2.Insert(n7.GetKey(), n7.GetData());
		tree2.Insert(n10.GetKey(), n10.GetData());
		tree2.Insert(n5.GetKey(), n5.GetData());
		tree2.Insert(n2.GetKey(), n2.GetData());
		tree2.Insert(n1.GetKey(), n1.GetData());
		tree2.Insert(n3.GetKey(), n3.GetData());
	
		// Third Binary Tree
		// Create tree
		Tree tree3 = new Tree();
		
		// Insert nodes to tree 3
		tree3.Insert(n1.GetKey(), n1.GetData());
		tree3.Insert(n3.GetKey(), n3.GetData());
		tree3.Insert(n2.GetKey(), n2.GetData());
		tree3.Insert(n5.GetKey(), n5.GetData());
		tree3.Insert(n7.GetKey(), n7.GetData());
		tree3.Insert(n8.GetKey(), n8.GetData());
		tree3.Insert(n10.GetKey(), n10.GetData());

		// Print trees
		tree1.Print();
		tree2.Print();
		tree3.Print();

		// Print the Height of the trees
		System.out.println("Height of first tree: " + tree1.GetHeight());
		System.out.println("Height of second tree: " + tree2.GetHeight());
		System.out.println("Height of third tree: " + tree3.GetHeight());
	}
}
