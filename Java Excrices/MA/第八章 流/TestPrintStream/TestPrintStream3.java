import java.io.*;
import java.util.*;

public class TestPrintStream3 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		try{
			FileWriter fw = new FileWriter("E:/Java Excrices/MA/µÚ°ËÕÂ Á÷/TestPrintStream/log.txt",true); 
			PrintWriter log = new PrintWriter(fw);
			String s = null;
			while( (s = br.readLine()) != null) {
				if(s.equalsIgnoreCase("exit")){break;}
				System.out.println(s.toUpperCase());
				log.println(s.toUpperCase());
				log.println("==========");
			}
			log.println("=====" + new Date() +"=====");
			log.close();
		}catch(IOException e) {
			e.printStackTrace();
		 }
	}
}