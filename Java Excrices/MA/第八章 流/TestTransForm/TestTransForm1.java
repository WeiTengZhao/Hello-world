import java.io.*;
public class TestTransForm1 {
	public static void main(String[] args) {
		try {
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:/Java Excrices/MA/�ڰ��� ��/TestTransForm/test1.txt"));
			osw.write("�ᶽ��æ��");
			System.out.println(osw.getEncoding());
			osw.close();

			OutputStreamWriter osw2 = new OutputStreamWriter(new FileOutputStream("E:/Java Excrices/MA/�ڰ��� ��/TestTransForm/test1.txt",true),"ISO8859_1");
			osw2.write( "\n" +"poi~");
			System.out.println(osw2.getEncoding());
			osw2.flush();
			osw2.close();			
		}catch(IOException e) {
			e.printStackTrace();
		 }
	}
}