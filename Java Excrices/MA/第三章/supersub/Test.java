class Super{
	public int n;
	Super(){
		System.out.println("Super");	
	}
	Super(int n){
		System.out.println("Super" + n);
		this.n = n;
	}	
}

class Sub extends Super{
	public int n ;
	Sub(int n){
		super();
		System.out.println("Sub" + n);
	}
	Sub (){	
		super(300);
		System.out.println("Sub");
	}
}
public class Test{
	public static void main (String args[]){
		Sub c1 = new Sub();
		Sub c2 = new Sub(400);
	}
}