import java.util.Scanner;
public class ImprovedStackDemo {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		ImprovedStackInterface<String> myImprovedStack = new ImprovedArrayBasedStack<String>(6);
		int option;
		
		do {
			System.out.println("Please pick one of the following options:");
			System.out.println("Press 1 to push one item onto the stack");
			System.out.println("Press 2 to push two items onto the stack");
			System.out.println("Press 3 to pop the top of stack");
			System.out.println("Press 4 to pop the top of stack twice");
			System.out.println("Press 5 to look at the top of the stack");
			System.out.println("Press 6 to end program");
			option = keyboard.nextInt();
			keyboard.nextLine();
			
			if (option == 1) {
				System.out.println("What would you like to push onto the stack?");
				String item = keyboard.nextLine();
				try {
					myImprovedStack.push(item);
				}
				catch(StackFullException e) {
					System.out.println(e);
				}
			}
			
			else if (option == 2) {
				System.out.println("What would you like to push onto the stack first?");
				String item1 = keyboard.nextLine();
				System.out.println("What would you like to push onto the stack next?");
				String item2 = keyboard.nextLine();
				try {
					myImprovedStack.push(item1, item2);
				}
				catch(StackFullException e) {
					System.out.println(e);
				}
			}
			
			else if (option == 3) {
				try {
					myImprovedStack.pop();
				}
				catch(StackEmptyException e) {
					System.out.println(e);
				}
			}
			
			else if (option == 4) {
				try {
					myImprovedStack.doublePop();
				}
				catch(StackEmptyException e) {
					System.out.println(e);
				}
			}
			
			else if (option == 5) {
				try {
					System.out.println(myImprovedStack.top());
				}
				catch(StackEmptyException e) {
					System.out.println(e);
				}
			}
			
			else {
				System.out.println("Thank you for using our program. Goodbye!");
			}
			
		} while (option != 6);
	}
}
