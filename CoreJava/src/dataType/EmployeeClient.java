package dataType;

import java.math.BigInteger;

public class EmployeeClient {

	public static void main(String[] args) {

//		Employee emp = new Employee();
//		emp.dummyMethod();
		
//		int a = 02;		
//		
//		long val = 100L;
//		System.out.println(val);

		// Q: How float and double values are stored in memory? Why BigInteger should be used instead of float and double?
//		https://stackoverflow.com/questions/16369726/declaring-floats-why-default-type-double

//		float v1 = .3f;
////		float v2 = .3; // compilation error
////		float v2 = 0.3; // compilation error
//		float v3 = (float) 0.3;
//		float v4 = 1;
//		float v5 = 1f;
//		System.out.println("v1 : " + v1 + "\nv3 : " + v3 + "\nv4 : " + v4 + "\nv5 : " + v5);
		
//		float var1 = .3f;
//		float var2 = .1f;
//		System.out.println(var1 - var2);
		
//		double var3 = .3;
//		double var4 = .3d; // 0.3f
//		System.out.println(var3 - var4);
		
//		float f = .7f;
//		double d = .7d;
//		System.out.println("f : " + f + "\nd : " + d);
//		System.out.println((double) f);

		// Octal: In java, we can store octal numbers by just adding 0 while initializing. They are called Octal Literals. The data type used for storing is int.
//		https://www.geeksforgeeks.org/java-program-to-illustrate-the-usage-of-octal-integer/
//		int a = 077;
//		int b = 09; // compile time error as 9 is not valid in octal number system
//		System.out.println(a); // 77{octal} = (7 × 8^1) + (7 × 8^0) = 63{decimal}
		
		
		// Down-casting / explicit type-casting
		int intVar1 = 10;
//		byte byteVar1 = intVar1; // compile time error
		byte byteVar1 = (byte) intVar1;
		System.out.println(byteVar1); // 10
		
		int intVar2 = 130;
		byte byteVar2 = (byte) intVar2;
		System.out.println(byteVar2); // -126
		
		// Automatic Promotion during expression
		// byte range is -128 to 127
		byte a = 127;
		byte b = 1;
//		byte sum = a + b; // compile time error: cannot convert int to byte
		byte sum = (byte) (a+b);
		int sum1 = a + b;
		
		byte a1 = 126;
		byte b1 = 1;
		int sum2 = a + b; // here, a + b does not crosses the byte limit
		
		short a2 = 126;
		short b2 = 1;
//		short sum3 = a2 + b2; // compile time error : cannot convert from int to short
		int sum3 = a + b; // here, a + b does not crosses the byte limit
		
		int a4 = 10;
		double d = 20d;
//		int sum4 = a4 + d; // compile time error -> Type mismatch: cannot convert from double to int
		double sum4 = a4 + d;
		int sum5 = (int) (a4 + d);
		
		// Kinds of variable
		Employee obj1 = new Employee();
		Employee obj2 = new Employee();
		
		System.out.println(Employee.staticVariable); // cannot be accessed using object name
		System.out.println(obj1.memberVariable + obj2.memberVariable);
	}

}
