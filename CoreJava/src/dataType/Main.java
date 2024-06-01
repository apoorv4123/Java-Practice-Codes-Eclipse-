package dataType;

import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {

//		Employee emp = new Employee();
//		emp.dummyMethod();
		
//		int a = 02;		
//		
//		long val = 100L;
//		System.out.println(val);

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
		
//		int a = 077;
//		System.out.println(a);
		
		// Down-casting / explicit type-casting
		int intVar1 = 10;
//		byte byteVar1 = intVar1; // compile time error
		byte byteVar1 = (byte) intVar1;
		System.out.println(byteVar1);
		
		int intVar2 = 130;
		byte byteVar2 = (byte) intVar2;
		System.out.println(byteVar2);
	}

}
