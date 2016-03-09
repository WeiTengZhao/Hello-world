import java.util.*;
public class Test{
	public static void main(String[] args){
		Set s1 = new HashSet();
		Set s2 = new HashSet();
		s1.add("a");
		s1.add("b");
		s1.add("c");
		s2.add("d");
		s2.add("a");
		s2.add("b");
		Set sn = new HashSet(s1);
		sn.retainAll(s2);
		System.out.println(sn);
		sn.addAll(s2);
		System.out.println(sn);
	}
}