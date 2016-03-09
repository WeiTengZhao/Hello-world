import java.net.*;
import java.io.*;
import java.util.*;

public class TalkServer {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;		
		InputStream sis = null;
		Date d = new Date();
		try {
			ServerSocket sok = new ServerSocket(6666);
			Socket sk = new Socket();
			sk = sok.accept();
			
			is = sk.getInputStream();
			sis = System.in;
			os = sk.getOutputStream();

			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(os);
			BufferedReader dsis = new BufferedReader(new InputStreamReader(sis));
			String s;
			s = dsis.readLine();
			dos.writeUTF(s);
			while(!s.equalsIgnoreCase("exit")) {
				System.out.println( d );
				System.out.println("Server:" + s);
				System.out.println("=====================");
				s = dis.readUTF();	
				System.out.println( d);
				System.out.println("Client:" + s);
				System.out.println("=====================");
				s = dsis.readLine();
				dos.writeUTF(s);
				
			}

			sok.close();
			sk.close();
			is.close();
			os.close();
			sis.close();
		}catch(IOException e2) {
			e2.printStackTrace();
			System.out.println("程序运行出错");
		 }

	}
}