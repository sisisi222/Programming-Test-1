
public class ImprovedArrayBasedStack<T> implements ImprovedStackInterface<T> {
	//instance variables
	private int top;
	private T [] stack;
	
	//default constructor
	public ImprovedArrayBasedStack() {
		top = -1;
		stack = (T[])new Object[100];
	}
	
	//overloaded constructor
	public ImprovedArrayBasedStack(int size) {
		top = -1;
		stack = (T[])new Object[size];
	}

	@Override
	public void push(T item) throws StackFullException {
		if(top < stack.length-1) {
			top++;
			stack[top] = item;
		}
		else
			throw new StackFullException("Not enough room for one item");
	}
	
	@Override
	public void push(T item1, T item2) throws StackFullException {
		if(top < stack.length-2) {
			top++;
			stack[top] = item1;
			top++;
			stack[top] = item2;
		}
		else
			throw new StackFullException("Not enough room for two items");
	}
	

	@Override
	public void pop() throws StackEmptyException {
		if(top > -1) {
			stack[top] = null;
			top--;
		}
		else 
			throw new StackEmptyException("No item to remove");
	}
	
	public void doublePop() throws StackEmptyException {
		if(top > 0) {
			stack[top] = null;
			top--;
			stack[top] = null;
			top--;
		}
		else 
			throw new StackEmptyException("There are less than two items in the stack");
	}

	@Override
	public T top() throws StackEmptyException {
		if(top > -1)
			return stack[top];
		else
			throw new StackEmptyException("Top attempted on an empty stack.");
	}
}