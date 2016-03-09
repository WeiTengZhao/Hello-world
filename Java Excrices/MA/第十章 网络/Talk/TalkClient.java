import java.net.*;
import java.io.*;
import java.util.*;

public class TalkClient {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;		
		InputStream sis = null;
		Date d = new Date();
		try {
			Socket sk = new Socket("127.0.0.1",6666);
			is = sk.getInputStream();
			sis = System.in;
			os = sk.getOutputStream();

			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(os);
			BufferedReader dsis = new BufferedReader(new InputStreamReader(sis));	
			String s;
			s = dis.readUTF();
			System.out.println( d );
			System.out.println("Server:" + s);
			System.out.println("=====================");
			dos.writeUTF(dsis.readLine());
			while(!(s.equalsIgnoreCase("exit"))) {
				System.out.println( d );
				System.out.println("Client:" + s);
				System.out.println("=====================");
				s = dis.readUTF();
				System.out.println( d );
				System.out.println("Server:" + s);
				System.out.println("=====================");	
				s = dsis.readLine();
				dos.writeUTF(s);
				//dos.flush();
				
			}

			sk.close();
			is.close();
			//os.flush();
			os.close();
			is.close();
		}catch(IOException e2) {
			e2.printStackTrace();
			System.out.println("程序运行出错");
		 }

	}
}