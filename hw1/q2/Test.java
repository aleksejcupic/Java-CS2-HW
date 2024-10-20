import java.util.Scanner;
class Test
{
	public static void main(String args[])
	{
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter name: ");
		String name = scanner.nextLine();

		System.out.print("Enter age: ");
		int age = scanner.nextInt();

		// Creating instance of Person
		Person p1 = new Person(name, age);

		p1.Print();

		boolean underage = p1.IsUnderAge();
		System.out.println("Underage: " + underage);
	}	
}
