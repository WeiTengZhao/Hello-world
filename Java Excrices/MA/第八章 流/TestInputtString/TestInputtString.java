import java.io.*;
public class TestInputtString {
	public static void main (String[] args) {
		int b = 0;
		FileInputStream in = null;

		try {
			in = new FileInputStream ("E:/Java Excrices/MA/µÚ°ËÕÂ Á÷/TestInputtString/TestInputtString.java");
			
		}catch(FileNotFoundException ex) {
			System.out.println("Hit That!!!!!!!!!!!!!!!!!");
			System.exit(-1);
		 }

		try {
			int num = 0;
			while((b = in.read() ) != -1){
				System.out.print( (char)b );
				num ++;	
			}				
			in.close();
			System.out.println(num);
		}catch(IOException e){
			System.exit(-1);
		 }
			
	}
}