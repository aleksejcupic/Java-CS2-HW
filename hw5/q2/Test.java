import java.util.*;
class Test
{
	// Instantiate array and 2 variables used
	static int[] v = new int[] {00, 10, 20, 30, 40, 50};
	static int index;
	int valid;

	// Function to check value at index from input
	static int CheckIndex(int index)
	{
		int value = v[index];
		return value;
	}

	public static void main(String args[])
	{
		// Infinite for loop
		for (;;)
		{
			// Ask for index input
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter an index: ");
			int index = scanner.nextInt();

			// Try / Catch block of code
			try
			{
				int valid = CheckIndex(index);
				System.out.println("Value at index " + index + " is " + valid);
			}
			catch (ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Error: Index out of bounds");
			}
		}
	}

}
