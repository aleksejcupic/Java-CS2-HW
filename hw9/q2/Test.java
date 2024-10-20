class Test
{
	public static void main(String args[])
	{
		// Make new hash table
		HashTable hash_table = new HashTable();

		// For loop to insert 1000 integers
		for (int i = 0; i < 1000; i++)
		{
			// Create node of "Integer"
			Integer q = new Integer(i, null);

			// Insert into the hash table
			hash_table.Insert(q.GetInteger(), q);

			if (i == 999)
				break;
		}
	}
}
