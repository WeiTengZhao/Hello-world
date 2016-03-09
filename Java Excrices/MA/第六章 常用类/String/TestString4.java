public class TestString4{
	public static void main(String [] args){
		String s ="sunjavahpjavaokjavajjavahahajavajavagoodjava ";
		String sToFin ="java";
		System.out.println( search(sToFin,s) );
	}	
	public static int search(String c,String s){
		int count = 0;
		int index = -1;
		while( (index = s.indexOf(c) ) != -1){
			count ++;
			s = s.substring(index + c.length());
		}
		return count;
	}
}