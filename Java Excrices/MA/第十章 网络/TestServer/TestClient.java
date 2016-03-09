import java.net.*;
import java.io.*;

public class TestClient {
	public static void main(String[] args)  throws Exception {
		Socket s = new Socket("127.0.0.1",6666);
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeUTF("我来自客户端");
		
		dos.flush();
		dos.close();
		s.close();
	}
}