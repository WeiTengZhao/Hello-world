import java.io.*;
import java.net.Socket;
public class TestHttp {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Socket s = new Socket("127.0.0.1",8080);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream())); {
			pw.println("GET /HTTP 1.1 /");
			pw.println("Host:localhost");	
			pw.println("Content-Type : text/html");
			pw.println();
			pw.flush();
			BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			String str = "";
			while ((str = bf.readLine()) != null ) {
				System.out.println(str);
			}
			pw.close();
			bf.close();
			s.close();
		}
	}

}
