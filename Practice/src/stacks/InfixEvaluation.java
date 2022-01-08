package stacks;

import java.util.Stack;

public class InfixEvaluation {

	public static void main(String[] args) {
		System.out.println(evaluate("(5+5)/5"));
	}

	public static int evaluate(String expression) {
		Stack<Integer> operands = new Stack<>();
		Stack<Character> operators = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);

			if (ch == '(') {
				operators.push(ch);
			} else if (Character.isDigit(ch)) {
				operands.push(ch - '0'); // char to integer
			} else if (ch == ')') {
				while (operators.peek() != '(') {
					char optor = operators.pop();
					int v2 = operands.pop();
					int v1 = operands.pop();
					operands.push(operation(v1, v2, optor));
				}
				operators.pop(); // to pop '('
			} else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				// ch is wanting higher priority operators to solve first
				while (!operators.isEmpty() && operators.peek() != '('
						&& precedence(operators.peek()) >= precedence(ch)) {
					char optor = operators.pop();
					int v2 = operands.pop();
					int v1 = operands.pop();
					operands.push(operation(v1, v2, optor));
				}
				// ch is pushing itself
				operators.push(ch);
			}
		}

		while (!operators.isEmpty()) {
			char optor = operators.pop();
			int v2 = operands.pop();
			int v1 = operands.pop();
			operands.push(operation(v1, v2, optor));
		}

		return operands.pop();
	}

	public static int precedence(char optor) {
		if (optor == '+') {
			return 1;
		} else if (optor == '-') {
			return 1;
		} else if (optor == '*') {
			return 2;
		} else {
			return 2;
		}
	}

	public static int operation(int v1, int v2, char optor) {
		if (optor == '+') {
			return v1 + v2;
		} else if (optor == '-') {
			return v1 - v2;
		} else if (optor == '*') {
			return v1 * v2;
		} else {
			return v1 / v2;
		}
	}

}
