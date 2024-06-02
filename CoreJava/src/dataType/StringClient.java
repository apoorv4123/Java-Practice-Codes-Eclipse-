package dataType;

public class StringClient {
	
	public static void main(String[] args) {
		
		
		String s1 = "hello"; // literal is put in string constant pool
		String s2 = "hello"; // would check in string constant pool first
		
		System.out.println(s1 == s2); //true - checks whether s1 and s2 both point to the same memory
		System.out.println(s1.equals(s2)); //true - equals will match the content stored at the memory locations
		
		String s = new String();
		System.out.println(s); // empty string
		
		String s3 = new String("hello");
		
		System.out.println(s1 == s3); // false - memory location is different
		System.out.println(s1.equals(s3)); // true - content is same
		
		s1 = "helloWorld"; // "hello" is atill present in string constant pool. So, string is immutable. 
	}

}
