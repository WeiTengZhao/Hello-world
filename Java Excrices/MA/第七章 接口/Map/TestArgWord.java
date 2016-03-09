import java.util.*;
public class TestArgWord{
	private static final Integer ONE = new Integer(1); 
	public static void main(String[] args) {
		Map m = new HashMap();
		for(int i=0; i<args.length; i++) {
			Integer freg =(Integer)m.get(args[i]);
			m.put(args[i], (freg == null ? ONE:freg + 1) );
		}
		
		System.out.println(m.size() );
		System.out.println(m);
	}
}