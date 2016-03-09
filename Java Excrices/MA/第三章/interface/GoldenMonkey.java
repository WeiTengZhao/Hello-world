public class GoldenMonkey extends Animal implements Valueable,Protectable{
	GoldenMonkey(String name){
		super(name);
	}
	public void enjoy(){
		System.out.println("I so Happy!");
	}
	public double getMoney(){
		return 100000;
	}
	public void beProtect(){
		System.out.println("Protecting.");
	}
}