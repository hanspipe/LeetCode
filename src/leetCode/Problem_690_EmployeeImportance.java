package leetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Problem_690_EmployeeImportance {
	class Employee {
		// It's the unique id of each node;
		// unique id of this employee
		public int id;
		// the importance value of this employee
		public int importance;
		// the id of direct subordinates
		public List<Integer> subordinates;
	}

	public int getImportance(List<Employee> employees, int id) {
		int sum = 0;
		// 先把每个员工和他们的importance存入map
		Map<Integer, Employee> map = new HashMap<Integer, Employee>();
		for (Employee e : employees) {
			map.put(e.id, e);
		}

		// 
		Stack<Employee> stack = new Stack<Employee>();
		stack.push(map.get(id));
		while (!stack.isEmpty()) {
			// 当前Employee
			Employee cur = stack.pop();
			sum += cur.importance;
			// 当前Employee的所有下属入栈
			List<Integer> subordinates = cur.subordinates;
			for(int subordinate : subordinates) {
				stack.push(map.get(subordinate));
			}

		}
		return sum;
	}
}
