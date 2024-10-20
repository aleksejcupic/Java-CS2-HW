abstract class Shape implements Comparable
{
	private String name;

	// Constructor
	public Shape(String name)
	{
		this.name = name;
	} 
	
	
	public void Print()
	{
		System.out.println("Name of shape: " + name);
	}

	public abstract double GetArea();

	
	public int compareTo(Object other)
	{
		// We use an explicit type cast with "(Shape)"
		// before "other".
		Shape other_shape = (Shape) other;
	
		// Get areas of this and other shapes
		double this_area = GetArea();
		double other_area = other_shape.GetArea();

		// Compare areas
		if (this_area < other_area)
			return -1;
		else if (this_area == other_area)
			return 0;
		else
			return 1;
	}
}
