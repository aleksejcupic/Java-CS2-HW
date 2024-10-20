import java.util.*;
class Test
{
	int element;
	
	public static void main(String args[])
	{
		// Set up scanner
		Scanner scanner = new Scanner(System.in);

		// Instantiate vector
		Vector vector = new Vector();

		// Enter (insert) 5 elements
		for (int i = 0; i < 5; i++)
		{
			System.out.println("Enter element " + (i + 1) + " of 5: ");
			int element = scanner.nextInt();
			vector.Add(Integer.valueOf(element));
		}
		
		// Print current vector
		vector.Print();
	
		// Extract (remove) 4 elements
		for (int i = 0; i < 4; i++)
		{
			System.out.println("Extract element " + (i + 1) + " of 4 at index: ");
			int extract = scanner.nextInt();
			vector.Remove(extract);
		}

		// Print current vector
		vector.Print();

	}
	
	

}
