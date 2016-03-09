import java.util.*;
public class TestMap2 { 
	public static void main(String[] args) {
		Map<String,Integer> m1 = new HashMap<String,Integer>();
		Map<String,Integer> m2 = new HashMap<String,Integer>();
		

		m1.put("One",1);	//JDK1.5�汾��֧���Զ�������Զ��������������ʹ���ɶ���
		m1.put("Two",2);
		m1.put("Three",3);
		m2.put("A",36);
		m2.put("B",37);

		System.out.println(m1.size());
		System.out.println(m1.containsKey("One") );
		System.out.println(m2.containsValue(36));
		
		if(m2.containsKey("B") ) {
			int i = m2.get("B");	//�Զ������int,ʹ�÷��Ͳ���ǿ��ת����Integer)
			System.out.println(i);
		}
		
		Map m3 = new HashMap(m1);
		m3.putAll(m2);		
		System.out.println(m3);
	}
}