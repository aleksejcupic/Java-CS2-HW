class Test
{
	public static void main(String args[])
	{
		// Error if number of arguments its not 1
		if (args.length != 1)
		{
			System.out.println("Error: wrong number of arguments");
			return;
		}

		// Set and print args to string
		String ascii_text = args[0];
		System.out.println("Input text: " + ascii_text);

		// Create leaf nodes and build tree	
		HuffmanTree huffman_tree = new HuffmanTree();
		huffman_tree.CreateLeafNodes(ascii_text);
		huffman_tree.BuildTree();

		// Encode
		String huffman_text = huffman_tree.Encode(ascii_text);
		System.out.println("Huffman text (encoded): " + huffman_text);

		// Compression ratio
		int size_compressed = huffman_text.length();
		int size_original = ascii_text.length() * 8;
		int compression_ratio = size_compressed * 100 / size_original;
		System.out.println("Compression ratio: " + compression_ratio + "%");

		// Decode
		ascii_text = huffman_tree.Decode(huffman_text);
		System.out.println("Huffman text (decoded): " + ascii_text); 
	}
}
