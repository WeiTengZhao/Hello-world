	 class Person{
	String name;
	int age;
	
	Person(String _name,int _age){
		name = _name;
		age = _age;
	}
	Person(){
		this(null,0);
	}
	public void setName(String _name){
		name = _name;
	}
	public void setAge(int _age){
		age = _age;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public String getInfo(){
		return("姓名:" + name + "\n" + "年龄:" + age);
	}
}

      class Student extends Person{
	String school;
	public void setSchool(String _school){
		school = _school;
	}
	public String getSchool(){
		return school;
	}
	public String getInfo(){
		return("姓名:" + name + "\n" + "年龄:" + age + "\n" +  "学校:" + school);
	}
}

public class Test{
	public static void main(String args[]){
	Student s = new Student();
	Person p = new Person();
	p.setName("U.N.");
	p.setAge(1000);
	s.setName("Crazy Kid");
	s.setAge(99);
	s.setSchool("GXUN");
	System.out.println(s.getInfo());
	System.out.println(p.getInfo());
}
}