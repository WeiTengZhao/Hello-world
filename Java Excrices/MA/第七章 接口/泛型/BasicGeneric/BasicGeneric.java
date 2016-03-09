import java.util.*;

public class  BasicGeneric {
	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("aaa");
		l.add("bbb");
		l.add("ccc");
		for(int i=0; i<l.size();i++){
			String s = l.get(i);
			System.out.println(s);
		}

		Collection<String> c = new HashSet<String>();		
		c.add("aaa");
		c.add("bbb");
		c.add("ccc");
		for(Iterator <String>i = c.iterator();i.hasNext();){
			String s1 = i.next();
			System.out.println(s1);
		}
	}
}