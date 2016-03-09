import java.net.*;
import java.io.*;

public class TestSockClient {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			Socket socket = new Socket("127.0.0.1",6666);
			os = socket.getOutputStream();
			is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(os);
			String s = null;
			dos.writeUTF("Hey!");
			if( (s = dis.readUTF() ) != null) {
				System.out.println(s);
				dis.close();
				dos.close();
				socket.close();
			}
		}catch(UnknownHostException e1) {
			e1.printStackTrace();
			System.out.println("无法确定主机IP");
		 }catch(IOException e) {
			e.printStackTrace();
			System.out.println("程序运行出错!");
		 }
	}
}