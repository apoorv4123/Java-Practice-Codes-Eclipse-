package dataType;

public class Employee {

//	byte var; // class member variables
//
//	public void dummyMethod() {
//		byte localVar; // local variables
//		System.out.println(var);
//		// System.out.println(localVar);
//	}

	// kinds of variables example
	int memberVariable; // member variable or instance variable : Each object has its own copy of member variables
	static int staticVariable = 100; // static variable or class variable
	
	Employee() {
		
	}
	
	// parameterized constructor : constructor variable
	Employee(int a) {
		memberVariable = a;
	}

	public void dummyMethod1() {
		byte localVariable = 100; // local variable
	}

	// a & b are method parameters
	public int dummyMethod2(int a, int b) {
		return a + b;
	}
}
