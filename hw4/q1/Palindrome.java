import java.util.Scanner;
class Palindrome
{
	static boolean IsPalindrome(String word)
	{
		// Instantiate variables 
		int length = word.length();
		int first = 0;
		int last = length - 1;

		// Variables for charAt 
		char a = word.charAt(0);
		char b = word.charAt(length - 1);
		
		// Case if length is 0 or 1
		if (length <= 1)
			return true;

		// If first and last not the same, 
		else if (a != b)
			return false;

		// If not pass first 2 if statement conditions, continue recursively
		word = word.substring(1, length - 1);
		IsPalindrome(word);
		return true;
	}

	public static void main(String args[])
	{
		// Scanner to become word
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a word: ");
		String word = scanner.nextLine();
	
		if (IsPalindrome(word) == true)
			System.out.println(word + " is a palindrome.");
		
		if (IsPalindrome(word) == false)
			System.out.println(word + " is not a palindrome.");
	}
}
