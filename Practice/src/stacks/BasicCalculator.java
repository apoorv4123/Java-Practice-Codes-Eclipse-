package stacks;

import java.util.Stack;

public class BasicCalculator {

	public static void main(String[] args) {
		System.out.println(calculate(" 27-1 + 21 "));
	}

	public static int calculate(String s) {

		Stack<Integer> opnd = new Stack<Integer>();
		Stack<Character> optr = new Stack<>();

		for (int i = 0; i < s.length(); i++) {

			char ch = s.charAt(i);

			if (ch == '(') {
				optr.push(ch);
			} else if (Character.isDigit(ch)) {
				if(i != 0 && Character.isDigit(s.charAt(i-1))) {
					opnd.push(opnd.pop() * 10 + (ch - '0'));
					continue;
				}
				opnd.push(ch - '0');
			} else if (ch == ')') {
				while (optr.peek() != '(') {
					int v2 = opnd.pop();
					int v1 = opnd.pop();
					char operator = optr.pop();
					int res = operation(v1, v2, operator);
					opnd.push(res);
				}
				optr.pop();
			} else if (ch == '+' || ch == '-') {
//				if(optr.isEmpty() && ch == '-') {
//					opnd.push(-s.charAt(i + 1) - '0');
//					i++;
//					continue;
//				}
				while (!optr.isEmpty() && optr.peek() != '(') {
					int v2 = opnd.pop();
					int v1 = opnd.pop();
					char operator = optr.pop();
					int res = operation(v1, v2, operator);
					opnd.push(res);
				}
				optr.push(ch);
			} else {
				continue;
			}
		}
		
		while (!optr.isEmpty()) {
			int v2 = opnd.pop();
			int v1 = opnd.pop();
			char operator = optr.pop();
			int res = operation(v1, v2, operator);
			
			opnd.push(res);
		}

		return opnd.pop();
	}

	public static int operation(int v1, int v2, char opnd) {
		if (opnd == '+') {
			return v1 + v2;
		} else {
			return v1 - v2;
		}
	}

}