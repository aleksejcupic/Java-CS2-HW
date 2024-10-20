class Test
{
	public static void main(String args[])
	{
		// Instantiate linked list
		DoublyLinkedList doubly_linked_list = new DoublyLinkedList();
		
		// Insert elements: "a", "b", "c", at the head:
		doubly_linked_list.Insert("a");
		doubly_linked_list.Next();
		doubly_linked_list.Head();
		doubly_linked_list.Insert("b");
		doubly_linked_list.Next();
		doubly_linked_list.Head();
		doubly_linked_list.Insert("c");
		doubly_linked_list.Next();

		// Set current element to second to last
		doubly_linked_list.Tail();
		doubly_linked_list.Previous();

		// Insert element "d", at current position
		doubly_linked_list.Insert("d");
		doubly_linked_list.Next();

		// Set current element to past-the-end
		doubly_linked_list.Tail();
		doubly_linked_list.Next();

		// Insert element "e" at current position
		doubly_linked_list.Insert("e");
		doubly_linked_list.Next();

		// Print
		doubly_linked_list.Print();
	}
}
