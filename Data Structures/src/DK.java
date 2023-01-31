import java.util.*;

public class DK {
	public static void main(String[] args) {
		System.out.println("Hi");
		Stack<Integer> s=new Stack<Integer>();
		s.push(15);
		s.push(7);
		s.push(5);
		s.push(6);
		s.push(10);
		s.push(4);
		s.push(1);
		s.push(5);
		System.out.println("Hi2");
		System.out.println(s.size());
		findStack(s);
		System.out.println(s.size());
		while(!s.isEmpty()) {
			System.out.println(s.peek());
		}
		System.out.println("end");
	}
public static Stack<Integer> findStack(Stack<Integer> inIntStack) {
	Stack<Integer> outIntStack=new Stack<Integer>();
	
	if(inIntStack.isEmpty()) return null;
	
	int number =1;
	System.out.println("Hi4");
	while(!inIntStack.isEmpty()) {
		outIntStack.push((inIntStack.pop()+number));
		number+=1;
		int temp=inIntStack.pop();
		if(outIntStack.peek()%10==0) {
			outIntStack.push(inIntStack.pop());
		}
		else {
			outIntStack.push(temp/number);
		}
	}
	System.out.println("Hi5");
	
	return outIntStack;
}
}