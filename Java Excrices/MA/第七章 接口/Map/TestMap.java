import java.util.*;
public class TestMap { 
	public static void main(String[] args) {
		Map m1 = new HashMap();
		Map m2 = new HashMap();
		

		m1.put("One",new Integer(1) );
		m1.put("Two",new Integer(2) );
		m1.put("Three",new Integer(3) );
		m2.put("A",new Integer(36) );
		m2.put("B",new Integer(37) );

		System.out.println(m1.size());
		System.out.println(m1.containsKey("One") );
		System.out.println(m2.containsValue(new Integer(36) ) );
		
		if(m2.containsKey("B") ) {
			int i = ( (Integer)m2.get("B") ).intValue();
			System.out.println(i);
		}
		
		Map m3 = new HashMap(m1);
		m3.putAll(m2);		
		System.out.println(m3);
	}
}