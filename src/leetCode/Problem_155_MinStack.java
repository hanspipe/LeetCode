package leetCode;

import java.util.Stack;
//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
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
        // ���ջ������,ѹ�뵱ǰջ����x�н�С��һ��
        if(!min.isEmpty()) {
        	min.push(x < min.peek() ? x : min.peek());
        }else// ���ջ��,��ֱ�ӽ�x��ջ
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
