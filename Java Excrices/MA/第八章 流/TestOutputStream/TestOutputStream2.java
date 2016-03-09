import java.io.*;
public class TestOutputStream {
	public static void main(String[] args) {
		FileInputStream in = null;
		FileOutputStream out = null;
		int b = 0;
	
		try {
			in = new FileInputStream("E:/Java Excrices/MA/第八章 流/TestOutputStream/TestOutputStream.java");
			out = new FileOutputStream("E:/Java Excrices/MA/第八章 流/TestOutputStream/TestOutputStream2.java");
	
			while( (b = in.read()) != -1) {
				out.write(b);
			}
			in.close();
			out.close();
		}catch(FileNotFoundException e1) {
			System.out.println("文件打开错误");
			System.exit(-1);
		 }
		 catch(IOException e2) {
			System.out.println("文件出错");
			System.exit(-1);
		 }
		
		System.out.println("文件已复制");
	}	
}