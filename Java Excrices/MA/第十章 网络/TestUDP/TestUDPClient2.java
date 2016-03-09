import java.net.*;
import java.io.*;

public class TestUDPClient2 {
	public static void main (String[] args)throws Exception {
		
		
		long n = 10000L;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		dos.writeLong(n);
		byte[] buf = bos.toByteArray(); 

		DatagramPacket dp = new DatagramPacket(buf,buf.length,new InetSocketAddress("127.0.0.1",6666) );
		DatagramSocket ds = new DatagramSocket(8888);
		ds.send(dp);
		ds.close();

	}
}