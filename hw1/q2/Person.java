class Person
{
	private String name;
	private int age;	

	// Constructor
	public Person(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	public void Print()
	{	
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);		
	}

	public boolean IsUnderAge()
	{
		return age < 18; 
	}	
}
