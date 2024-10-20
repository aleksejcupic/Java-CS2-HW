import java.util.Scanner;
class Test
{		
	// Will return the index of the element
	static int GetMinIndex(Shape[] v, int left, int right)
	{
		// Assume left index contains minimum value
		int min_index = left;
		
		// Traverse remaingin elements 
		for (int i = left + 1; i <= right;i++)
			if (v[i].compareTo(v[min_index]) == -1)
				min_index = i;

		// Return index of minimum value
		return min_index;
	}

	// Swaps index1 and index2
	static void Swap(Shape[] v, int index1, int index2)
	{
		Shape temp = v[index1];
		v[index1] = v[index2];
		v[index2] = temp;
	}

	static void Sort(Shape[] v)
	{
		// We want to run n - 1 iterations
		for (int i = 0; i < v.length - 1; i++)
		{
			// Get minimum index within unsorted region
			int min_index = GetMinIndex(v, i, v.length - 1);

			// Swap minimum value and left most value in unsorted region
			Swap(v, min_index, i);
		}
	}

	public static void main(String args[])
	{
		// Ask for number of shapes (keyboard input)
		Scanner scanner = new Scanner(System.in);
		System.out.println("Number of shapes: ");

		// Instantiate N as number of shapes
		int N = scanner.nextInt();
		scanner.nextLine();

		// Instantiate array
		Shape v[];
		v = new Shape[N];
		
		// Input data for each shape
		for (int i = 0; i <= N - 1; i++)
		{
			// Ask for which type of shape
			System.out.println("Circle or Rectangle: ");
			String shapetype = scanner.nextLine();
			if (shapetype.equals("Circle"))
			{
				// Input name and radius
				System.out.println("Enter circle name: ");
				String name = scanner.nextLine();
				scanner.nextLine();
				System.out.println("Enter radius: ");
				double radius = scanner.nextDouble();
				scanner.nextLine();

				// Add data to array
				Circle circle = new Circle(name, radius);
				v[i] = circle;
			}

			else if (shapetype.equals("Rectangle"))
			{	
				// Input name, width, and height
				System.out.println("Enter rectangle name: ");
				String name = scanner.nextLine();
				scanner.nextLine();
				System.out.println("Enter width: ");
				double width = scanner.nextDouble();
				scanner.nextLine();
				System.out.println("Enter height: ");
				double height = scanner.nextDouble();
				scanner.nextLine();
			
				// Add data to array
				Rectangle rectangle = new Rectangle(name, width, height);
				v[i] = rectangle;
			}
		}
		
		// Sort array 
		Sort(v);
	
		// Print sorted array
		for (int i = 0; i < N; i++)
			v[i].Print();
	}
}
