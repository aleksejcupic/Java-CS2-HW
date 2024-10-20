import java.util.Scanner;
class TestPoint2D
{

	public static void main(String args[])
	{
		// Instantiate Scanner and Points
		Scanner scanner = new Scanner(System.in);
		Point2D a = new Point2D();
		Point2D b = new Point2D();
		
		// Read 
		a.Read(scanner);
		b.Read(scanner);
		
		// Print
		a.Print();
		b.Print();

		// Print number of coordinates and answer
		int num = a.GetNumCoordinates();
		System.out.println("Number of Coordinates: " + num);
		
		double answer = a.GetDistance(b);

		System.out.println("Distance: " + answer);
		
	}	
}
