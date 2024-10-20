class Rectangle extends Shape
{	
	String name;
	double width;
	double height;

	// Constructor
	public Rectangle(String name, double width, double height)
	{
		// Implements name from class Shape
		super(name);
		this.width = width;
		this.height = height;
	}

	public void Print()
	{
		// Implements Print() from class Shape
		super.Print();
		System.out.println("Rectangle width: " + width);
		System.out.println("Rectangle height: " + height);
	}

	public double GetArea()
	{
		// Area of rectangle
		return width * height;
	}
	
}
