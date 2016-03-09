public class BinartSearch{
	public static void main(String [] args){
		int a[] = { 1 , 3 , 6 , 8 , 9 , 10 , 12 , 18 , 20 , 34 };
		int i = 12;
 		System.out.println(binaSearch(a, i));
	}

	public static int binaSearch(int a[],int i){
		if(a.length == 0) return -1;
		
		int startPos = 0;
		int endPos = a.length - 1;
		int m = (startPos + endPos) / 2;
			
		while(startPos <= endPos){
			if(a[m] == i) return m;
				
			if(a[m] > i){
				endPos = m - 1;
			} 
				
			if(a[m] < i){
				startPos = m + 1;
			}
				
			m = (startPos + endPos) / 2;
		}
		
		return -1;
	} 
}