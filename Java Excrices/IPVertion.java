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
				System.out.println("IPv4地址");
				if((firstaddress & 0000)==0) {
					System.out.println("A类地址");
				}
				if((firstaddress & 1000)==1000) {
					System.out.println("B类地址");
				}
				if((firstaddress & 1100)==1100) {
					System.out.println("C类地址");
				}
				if((firstaddress & 1110)==1110) {
					System.out.println("D类地址");
				}
				if((firstaddress & 1111)==1111) {
					System.out.println("E类地址");
				}
			}
			if(address.length == 6) {
				System.out.println("IPv6地址");		
			}
			//else {System.out.println("程序错误");}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("程序错误");
		 }
	}
}