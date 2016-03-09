import java.io.*;
import java.net.*;

public class TestServer2 {
	public static void main(String[] args) {
		try{
			ServerSocket ss = new ServerSocket(8888); 
			while(true) {
				Socket s = ss.accept();
				OutputStream os = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os); 
				dos.writeUTF("Welcome Client From" + ss.getInetAddress()+"   "+s.getInetAddress() + "In" + ss.getLocalPort()+"  "+ s.getPort() );
				dos.close();
				s.close();
			}
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("程序运行出错");
		 }
	}
}