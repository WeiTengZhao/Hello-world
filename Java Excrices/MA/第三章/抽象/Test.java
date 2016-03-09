public class Test{
	public static void main(String [] args){
		//Animal a = new Animal("name");
		Cat c = new Cat("Cat","Bule");
		Dog d = new Dog("Dog","Black");
		Lady l1 = new Lady("L1",c);
		Lady l2 = new Lady("L2",d);
		l1.aenjoy();
		l2.aenjoy();	
	}
}