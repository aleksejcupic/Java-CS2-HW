import java.lang.Math;
import java.util.Scanner;
class Point2D extends Point
{
	// Create variables	
	private double x;
	private double y;

	public Point2D()
	{
	}
	
	// Read coordinates
	public void Read(Scanner scanner)
	{
		super.Read(scanner);
		System.out.println("Enter X: ");
		this.x = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Enter Y: ");
		this.y = scanner.nextDouble();
		scanner.nextLine();
	}
	
	// Print coordinates
	public void Print()
	{
		super.Print();
		System.out.println("X: " + x);
		System.out.println("Y: " + y);
	}

	public int GetNumCoordinates()
	{
		return 2;
	}

	// Distance formula (2 points)
	public double GetDistance(Point2D B)
	{
		return Math.sqrt(Math.pow(B.x-x,2) + Math.pow(B.y-y,2));
	}
}
