import java.net.*;
import java.io.*;

public class TestUDPServer2 {
	public static void main (String[] args)throws Exception {
		byte[] buf = new byte[1024];
		
		
		 
		DatagramPacket dp = new DatagramPacket(buf,buf.length);
		DatagramSocket ds = new DatagramSocket(6666);
		
		while(true) {
			ByteArrayInputStream bis = new ByteArrayInputStream(buf);
			DataInputStream dis = new DataInputStream(bis);
			ds.receive(dp);
			System.out.println( dis.readLong() );
		}

	}
}