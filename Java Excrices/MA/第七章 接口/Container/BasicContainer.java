import java.util.*;
public class BasicContainer{
	public static void main(String [] args){
		Collection c = new HashSet();
		c.add(new Integer(110) );
		c.add(new String("Hello World") );
		c.add(new Name("Spring","Free") );
		System.out.println(c);
		c.remove("Hello World");
		c.remove(110);
		System.out.println(c);
		System.out.println(c.remove ( new Name("Spring","Free") ));
		System.out.println(c);
	}
}