import java.io.*;
public class TestPrintStream {
	public static void main(String[] args) {
		
		PrintStream ps = null;
		try{
			FileOutputStream fos = new FileOutputStream("E:/Java Excrices/MA/µÚ°ËÕÂ Á÷/TestPrintStream/Unicode.txt");
			ps = new PrintStream(fos);		
		}catch(IOException e) {
			e.printStackTrace();
		 }
		if(ps != null) {
			System.setOut(ps);
		}
		int in = 0;
		for(char c =0; c<65536; c++) {
			System.out.print(c + " ");
			if(in++ ==20) {
				System.out.println();
			}
		}
		ps.close();
	}
}