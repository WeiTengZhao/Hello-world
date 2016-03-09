import java.io.*;
public class TestReader {
	public static void main(String[] args) {
		FileReader r = null;
		int b = 0;
		try {
			r = new FileReader("E:/Java Excrices/MA/第八章 流/TestReader/TestReader.java");
			while( ( b = r.read() ) != -1 ) {
				//b = r.read();
				System.out.print( (char)b );
			}
			r.close();
		}catch(FileNotFoundException e1) {
		 	System.out.println("文件不存在");
			System.exit(-1);
		 }
		 catch(IOException e2) {
			System.out.println("文件错误");
			System.exit(-1);
		 }
	}
}