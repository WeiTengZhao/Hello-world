public class Teacher implements Singer,Painter{
	private String name;
	Teacher (String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void sing(){
		System.out.println("Teacher is singing.");
	}
	public void sleep(){
		System.out.println("Teacher is sleeping.");
	}
	public void paint(){
		System.out.println("Teacher is painting.");
	}
	public void eat(){
		System.out.println("Teacher is eating.");
	}
	public void teach(){
		System.out.println("Techer is teaching.");
	}
}