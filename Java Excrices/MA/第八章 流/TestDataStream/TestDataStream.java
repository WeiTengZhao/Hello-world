import java.io.*;
public class TestDataStream {
	public static void main(String[] args) {
		try{
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			DataOutputStream dos = new DataOutputStream(bos);
			dos.writeDouble(Math.random());
			dos.writeBoolean(true);

			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			DataInputStream dis = new DataInputStream(bis);
			System.out.println(dis.available());
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());
			bos.close();
			bis.close();
		}catch(IOException e) {
			e.printStackTrace();
		 }
	}
}