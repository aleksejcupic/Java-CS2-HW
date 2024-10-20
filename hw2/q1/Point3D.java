import java.lang.Math;
import java.util.Scanner;
class Point3D extends Point
{
	// Create variables
	private double x;
	private double y;
	private double z;
	
	public Point3D()
	{
	}
	
	// Read variables
	public void Read(Scanner scanner)
	{
		super.Read(scanner);
		System.out.println("Enter X: ");
		this.x = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Enter Y: ");
		this.y = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Enter Z: ");
		this.z = scanner.nextDouble();
		scanner.nextLine();
	}

	// Print variables
	public void Print()
	{
		super.Print();
		System.out.println("X: " + x);
		System.out.println("Y: " + y);
		System.out.println("Z: " + z);
	}

	public int GetNumCoordinates()
	{
		return 3;
	}

	// Distance formula (3 points)
	public double GetDistance(Point3D B)
	{
		return Math.sqrt(Math.pow(B.x-x,2) + Math.pow(B.y-y,2) + Math.pow(B.z-z,2));
	}
}
