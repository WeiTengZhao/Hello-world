import java.util.*;
public class TestMap2 { 
	public static void main(String[] args) {
		Map m1 = new HashMap();
		Map m2 = new HashMap();
		

		m1.put("One",1);	//JDK1.5版本后支持自动打包，自动将基础数据类型打包成对象
		m1.put("Two",2);
		m1.put("Three",3);
		m2.put("A",36);
		m2.put("B",37);

		System.out.println(m1.size());
		System.out.println(m1.containsKey("One") );
		System.out.println(m2.containsValue(36));
		
		if(m2.containsKey("B") ) {
			int i = (Integer)m2.get("B");	//自动解包成int
			System.out.println(i);
		}
		
		Map m3 = new HashMap(m1);
		m3.putAll(m2);		
		System.out.println(m3);
	}
}