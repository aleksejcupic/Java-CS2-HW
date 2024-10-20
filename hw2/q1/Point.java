import java.util.Scanner;
abstract class Point 			// Parent class for each Point
{

	String name;


	public void Print()
	{
		System.out.println("Point" + name);
	}
	
	public void Read(Scanner scanner)
	{
		System.out.println("Enter Name: ");
		this.name = scanner.nextLine();
	}

	public abstract int GetNumCoordinates();
}
