public class ArrayParser{
	public static void main(String[] args){
		String s ="1,2;3,4,5;6,7,8";
		String[] sFirst = s.split(";");
		double d[][] = new double[sFirst.length][];
		
		for(int i=0; i<sFirst.length; i++){
			String[] sSecond = sFirst[i].split(",");
			d[i] = new double[sSecond.length]; 
		
			for(int j=0; j<sSecond.length; j++){
				d[i][j] = Double.parseDouble(sSecond[j]); 
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		} 
	}
}