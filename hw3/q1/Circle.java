class Circle extends Shape 
{
	double radius;

	// Constructor
	public Circle(String name, double radius)
	{
		// Implements name from class Shape
		super(name);
		this.radius = radius;
	}

	public void Print()
	{
		// Implements Print() from class Shape
		super.Print();
		System.out.println("Circle radius: " + radius);
	}

	public double  GetArea()
	{
		// Area of Circle
		return Math.PI  * radius * radius;	
	}
	
}
