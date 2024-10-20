class Node
{
	public Node previous;
	public Node next;
	Object data;

	public Node(Object data)
	{
		this.data = data;
	}	

	public Object GetData()
	{
		return data;
	}
}
