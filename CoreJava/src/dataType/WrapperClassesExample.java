package dataType;

public class WrapperClassesExample {

	public static void main(String[] args) {
		
//		https://www.geeksforgeeks.org/autoboxing-unboxing-java/
		
		int a = 10;
		Integer a1 = a; // Autoboxing
		
		Integer b = 50;
		int b1 = b; // Unboxing
		
		System.out.println(modify(a1));
	}
	
	public static int modify(int x) {
		System.out.println("one");
		return x;
	}
	
	public static int modify(Integer x) {
		System.out.println("two");
		return x;
	}

}
