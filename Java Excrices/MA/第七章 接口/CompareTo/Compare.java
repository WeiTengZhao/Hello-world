import java.util.*;
public class Compare{
	public static void main(String[] args){
		List n = new LinkedList();
		n.add(new Name("Apple","A") );
		n.add(new Name("Cherry","C") );
		n.add(new Name("Banana" ,"B") );
		System.out.println(n);
		System.out.println("-----ԭʼ˳��");
		/*
		Collections.shuffle(n);
		System.out.println(n);
		System.out.println("-----����");
		*/
		
		Collections.sort(n);
		System.out.println(n);
		System.out.println("-----˳��");
		
		
		/*Collections.reverse(n);
		System.out.println(n);
		System.out.println("-----����");		
		*/
	}
}