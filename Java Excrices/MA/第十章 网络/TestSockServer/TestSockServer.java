import java.net.*;
import java.io.*;

public class TestSockServer {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {		
			Socket socket = new Socket();
			ServerSocket ss = new ServerSocket(6666);			
			socket = ss.accept();
			os = socket.getOutputStream();
			is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(os);			
			String s = null;
			if( ( s = dis.readUTF() ) != null) {
				dos.writeUTF("Welcome.Bye-Bye!");
				System.out.println(s);
				System.out.println("From:" + socket.getInetAddress() );
				System.out.println("Port:" + socket.getLocalPort() );
				dos.close();
				dis.close();
				ss.close();
				socket.close();
			}
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("≥Ã–Ú‘À––¥ÌŒÛ");
		 }
	}
}