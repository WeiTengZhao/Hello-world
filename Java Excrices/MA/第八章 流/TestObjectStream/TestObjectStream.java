import java.io.*;
public class TestObjectStream {
	public static void main(String[] args)throws Exception {
		T t = new T();
		t.k = 8;	
			FileOutputStream fos = new FileOutputStream("E:/Java Excrices/MA/第八章 流/TestObjectStream/test.txt");
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(t);
			os.flush();
			os.close();
			
			FileInputStream fis = new FileInputStream("E:/Java Excrices/MA/第八章 流/TestObjectStream/test.txt") ;	
			ObjectInputStream oi = new ObjectInputStream(fis);
			T tread = (T)oi.readObject();
			System.out.println(tread.j +" "+ tread.i +" "+tread.n +" "+tread.k+" ");		
	}
}


