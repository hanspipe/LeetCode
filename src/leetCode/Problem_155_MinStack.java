package leetCode;

import java.util.Stack;

public class Problem_155_MinStack {
	/** initialize your data structure here. */
	
	Stack<Integer> data;
    Stack<Integer> min;
    
    public Problem_155_MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
        data.push(x);
        if(!min.isEmpty()) {
        	min.push(x < min.peek() ? x : min.peek());
        }else
        	min.push(x);
    }
    
    public void pop() {
        data.pop();
        min.pop();
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
