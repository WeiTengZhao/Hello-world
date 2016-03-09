public class Dog extends Animal{
	private String name;
	private String furcolor;
	Dog(String name,String furcolor){
		super(name);
		this.furcolor = furcolor;
	}	
	
	public void enjoy(){
		System.out.println("¹·½Ð.....");
	}
}