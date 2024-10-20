import java.util.Scanner;
class Test
{
	// Recursive factorial function
	static int Factorial(int n)
	{
		if (n==0)
			return 1;
		else
			return n * Factorial(n-1);
	}
	
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int n = scanner.nextInt();
		System.out.println("The factorial is: " + Factorial(n));
	}

}
