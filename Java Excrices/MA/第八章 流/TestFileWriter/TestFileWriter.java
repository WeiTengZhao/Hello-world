import java.io.*;
public class TestFileWriter {
	public static void main(String[] args) {
		FileWriter w = null;
		try {
			w = new FileWriter("E:/Java Excrices/MA/�ڰ��� ��/TestFileWriter/Unicode.txt");
			for(int c=0; c<65536; c++) {
				w.write(c);
			}
			w.close();
		}catch(IOException e) {
		 	System.out.println("�ļ�����");
			System.exit(-1);
		 }
	}
}