import java.util.*;
class Test
{
	public static void main(String args[])
	{
		// Error if the number of arguments is not 2
		if (args.length != 2)
		{
			System.out.println("Error: wrong number of arguments");
			return;
		}
		
		// Make args[1] into an integer
		int num = Integer.parseInt(args[1]);

		// Instantiate a tree
		Tree tree = new Tree();

		// Split code based on if args[0] is "sorted" or "random"
		if (args[0].equals("sorted"))
		{
			// Add keys from 0 to number of nodes created
			for (int i = 0; i < num; i++)
				tree.Insert(i, null);
		}
		else if (args[0].equals("random"))
		{
			// Instantiate random variable
			Random rand = new Random();
		
			// For loop for adding elements with try-catch
			for (int i = 0; i < num; i++)
			{
				int rand1 = rand.nextInt(num);
				try
				{
						tree.Insert(rand1, null);
				}	
				catch (RuntimeException e)
				{
				
				}
			}	
		}
		else
		{
			// Catches error if first argument is not "sorted" or "random"
			System.out.println("Error: first argument not 'sorted' or 'random'");
			return;
		}
	}
}
