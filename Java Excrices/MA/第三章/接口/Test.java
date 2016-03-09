public class Test{
	public static void main(String [] args){
		Singer s1 = new Student("Student");
		Singer s2 = new Teacher("Teacher");
		//s1.study();
		s1.sing();
		s1.sleep();
		//s2.teach();
		s2.sing();
		s2.sleep();
		Painter p1 = (Painter) s2;
		p1.paint();
		p1.eat();
	}
}