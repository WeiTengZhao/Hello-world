import java.io.*;
import java.net.*;

public class TestClient2 {
	public static void main(String[] args) {
		try{
			Socket s = new Socket("127.0.0.1",8888);
			DataInputStream dis = new DataInputStream( s.getInputStream() );
			System.out.println(dis.readUTF() );
			dis.close();
			s.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("程序运行出错");
		 }
	}
}