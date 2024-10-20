class Node implements Comparable
{
	public int frequency;
	public Node left;
	public Node right;
	public int ascii_code;
	public String huffman_code;

	public Node(int ascii_code)
	{
		this.ascii_code = ascii_code;
	}

	public int compareTo(Object other)
	{
		Node other_node = (Node) other;

		// Inverted comparison to make our max heap behave as a min heap.
		if (frequency < other_node.frequency)
			return 1;
		else if (frequency > other_node.frequency)
			return -1;
		else 
			return 0;
	}
	
	public void SetHuffmanCode(String huffman_code)
	{
		// Save the code for the current node
		this.huffman_code = huffman_code;

		// Set code for left child
		if (left != null)
			left.SetHuffmanCode(huffman_code + "0");
		
		// Set code for child
		if (right != null)
			right.SetHuffmanCode(huffman_code + "1");
	}
}
