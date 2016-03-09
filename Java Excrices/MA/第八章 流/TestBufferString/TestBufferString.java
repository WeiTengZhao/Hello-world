import java.io.*;
public class TestBufferString {
	public static void main (String[] args) {
		try{
			BufferedWriter bfw = new BufferedWriter (new FileWriter ("E:/Java Excrices/MA/第八章 流/TestBufferString/test.txt") );
			BufferedReader bfr = new BufferedReader(new FileReader("E:/Java Excrices/MA/第八章 流/TestBufferString/test.txt") );
			String s = null;
			String b = null;		

			for(int i=0; i<100; i++) {
				s = String.valueOf( Math.random() );
				bfw.write(s);
				bfw.newLine();
			}
		
			bfw.flush();
			while( (b=bfr.readLine() ) != null){
				
				System.out.println(b);
			}
			
			bfw.close();
			bfr.close();
		}catch(IOException e){
			System.exit(-1);
		 }
	}
}