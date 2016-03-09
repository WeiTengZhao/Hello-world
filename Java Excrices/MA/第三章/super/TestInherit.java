class Father{
	int value;
	public void f(){
		value = 100;
		System.out.println("Father value" + value);
	}
}

class Children extends Father{
	public int value;
	public void f(){
		super.f();
		value = 200;
		System.out.println("Children value" + value);
		System.out.println(value);
		System.out.println(super.value);
	}
}

public class TestInherit{
	public static void main	(String [] args){
		Children cc  = new Children();
		cc.f();
	}
}