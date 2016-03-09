import java.net.*;

public class IPVertion {
	public static void main (String args[]){
		try{
			InetAddress host = null;
			host = InetAddress.getLocalHost();
			System.out.println(host.getHostName());
			System.out.println(host.getHostAddress());
			//System.out.println(host.clssName());
			System.out.println(host.getByName("www.baidu.com"));
			System.out.println(host.getByName("localhost"));

			byte[] address = host.getAddress();
			byte firstaddress = address[0];
	
			if(address.length == 4){
				System.out.println("IPv4��ַ");
				if((firstaddress & 0000)==0) {
					System.out.println("A���ַ");
				}
				if((firstaddress & 1000)==1000) {
					System.out.println("B���ַ");
				}
				if((firstaddress & 1100)==1100) {
					System.out.println("C���ַ");
				}
				if((firstaddress & 1110)==1110) {
					System.out.println("D���ַ");
				}
				if((firstaddress & 1111)==1111) {
					System.out.println("E���ַ");
				}
			}
			if(address.length == 6) {
				System.out.println("IPv6��ַ");		
			}
			//else {System.out.println("�������");}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("�������");
		 }
	}
}