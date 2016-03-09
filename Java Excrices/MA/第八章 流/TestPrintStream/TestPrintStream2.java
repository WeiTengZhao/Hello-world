import java.io.*;
public class TestPrintStream2 {
	public static void main(String[] args) {
		String filename = args[0];
		if(filename != null){
			list(filename);
		}
	}

	public static void list(String f) {
		try{
			BufferedReader br = new BufferedReader(new FileReader(f) );
			String s = null;
			while( ( s = br.readLine() ) != null){
				System.out.println(s);
			}
		}catch(IOException e) {
			e.printStackTrace();
		 }
	}
}