import java.util.* ;
public class IteratorRemove {
	public static void main(String[] args) {
		Collection c = new HashSet();
		c.add( new Name("fff1","lll1") );
		c.add( new Name("ff2","ll2") );
		c.add( new Name("fff3","lll3") );
		for(Iterator i =  c.iterator(); i.hasNext(); ) {
			Name n = (Name) i.next();
			if(n.getFirstName().length() > 3) {
				i.remove();
			}
		}
		System.out.println(c);
		
	}	
}