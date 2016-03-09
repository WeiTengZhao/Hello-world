import java.net.*;

public class TestUDPClient {
	public static void main (String[] args)throws Exception {
		byte[] buf = (new String ("Hello")).getBytes();

		DatagramPacket dp = new DatagramPacket(buf,buf.length,new InetSocketAddress("127.0.0.1",6666) );
		DatagramSocket ds = new DatagramSocket(8888);
		ds.send(dp);
		ds.close();

	}
}