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
		Map<Integer, Employee> map = new HashMap<Integer, Employee>();
		for (Employee e : employees) {
			map.put(e.id, e);
		}

		Stack<Employee> stack = new Stack<Employee>();
		stack.push(map.get(id));
		while (!stack.isEmpty()) {
			Employee cur = stack.pop();
			sum += cur.importance;
			List<Integer> subordinates = cur.subordinates;
			for(int subordinate : subordinates) {
				stack.push(map.get(subordinate));
			}

		}

		return sum;
	}
}
