import java.util.Scanner;
class TestPoint3D
{
	public static void main(String args[])
	{
		// Instantiate Scanner and points
		Scanner scanner = new Scanner(System.in);
		Point3D a = new Point3D();
		Point3D b = new Point3D();
		
		// Read
		a.Read(scanner);
		b.Read(scanner);
	
		// Print
		a.Print();
		b.Print();

		// Print number of coordiantes and answer
		int num = a.GetNumCoordinates();
		System.out.println("Number of Coordinates: " + num);
		
		double answer = a.GetDistance(b);
	
		System.out.println("Distance: " + answer);
	}
}
