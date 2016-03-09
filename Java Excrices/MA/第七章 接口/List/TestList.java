import java.util.*;
public class TestList {
	public static void main(String[] args) {
		List l1 = new LinkedList();
		for(int i=0; i<8; i++) {
			l1.add("a" + i);
		}
		System.out.println(l1);
		l1.add(4,"a100");
		System.out.println(l1);
		l1.set(4,"a4");
		System.out.println(l1);
		System.out.println("===");
		System.out.println( (String)l1.get(4) );
		l1.remove(0);
		System.out.println(l1);
		System.out.println("/////////////////////////////////");
		//Collectinos 类常用方法
		Collections.sort(l1);
		System.out.println(l1);
		System.out.println("------");
		Collections.reverse(l1);
		System.out.println(l1);
		System.out.println("------");
		Collections.shuffle(l1);
		System.out.println(l1);
		System.out.println("-----");
		Collections.sort(l1);
		System.out.println(l1);
		System.out.println( Collections.binarySearch(l1,"a4") );
	}
}