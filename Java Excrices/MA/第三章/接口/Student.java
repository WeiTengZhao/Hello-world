public class Student implements Singer{
	private String name;
	Student(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void sing(){
		System.out.println("Student is singing.");
	}
	public void sleep(){
		System.out.println("Student is sleeping.");
	}
	public void study(){
		System.out.println("Student is studenting.");
	}
}