import java.util.*;
public class TestArgWord2{
	private static final Integer ONE = 1; 
	public static void main(String[] args) {
		Map m = new HashMap();
		for(int i=0; i<args.length; i++) {
			int freg = (Integer)m.get(args[i]) ==null ? 0 : (Integer)m.get(args[i]);
			m.put(args[i], (freg == 0 ? ONE:freg + 1) );
		}
		
		System.out.println(m.size() );
		System.out.println(m);
	}
}