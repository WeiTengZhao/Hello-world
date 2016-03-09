import java.util.*;
public class Compare{
	public static void main(String[] args){
		List n = new LinkedList();
		n.add(new Name("Apple","A") );
		n.add(new Name("Cherry","C") );
		n.add(new Name("Banana" ,"B") );
		System.out.println(n);
		System.out.println("-----Ô­Ê¼Ë³Ðò");
		/*
		Collections.shuffle(n);
		System.out.println(n);
		System.out.println("-----ÂÒÐò");
		*/
		
		Collections.sort(n);
		System.out.println(n);
		System.out.println("-----Ë³Ðò");
		
		
		/*Collections.reverse(n);
		System.out.println(n);
		System.out.println("-----µ¹Ðò");		
		*/
	}
}