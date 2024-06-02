package dataType;

public class StudentClient {

	public static void main(String[] args) {
		
		Student studentObject = new Student();
		
		studentObject.studentId = 10;
		modify(studentObject);
		System.out.println(studentObject.studentId);
		
		Student studentObject2 = studentObject;
		System.out.println(studentObject2.getStudentId());
		
	}
	
	public static void modify(Student student) {
		student.studentId = 20;
	}

}
