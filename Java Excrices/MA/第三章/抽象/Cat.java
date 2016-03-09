public class Cat extends Animal{
	private String name;
	private String eyecolor;
	Cat(String name,String eyecolor){
		super(name);
		this.eyecolor = eyecolor;
	}
	
	public void enjoy(){
		System.out.println("竪出。。。。");
	}	
}