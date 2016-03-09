public class BinaryDate{
	public static void main(String[] args){
		Date []day = new Date [5];
		day[0] = new Date(2006,5,4);
		day[1] = new Date(2006,7,4);
		day[2] = new Date(2008,5,5);
		day[3] = new Date(2004,5,9);
		day[4] = new Date(2004,5,4);
		
		Date d = new Date(2006,7,4);
		
		print(day);
		System.out.println();
		bubbletSort(day);
		print(day); 
		System.out.println( binaSearch(day,d) );
		
	}

	public static void print(Date[] d){
		for(int i = 0;i < d.length; i++){
			System.out.println(d[i]);	
		}
	}

	public static int binaSearch(Date [] d,Date day){
		if(d.length == 0) return -1;
		int startPos = 0;
		int endPos = d.length - 1;
		int m = (startPos + endPos) / 2;
		while(startPos <= endPos){
			if(d[m].compare(day) == 0) return m;
			if(d[m].compare(day) == 1){
				endPos = m - 1;
			} 
			if(d[m].compare(day) == -1){
				startPos = m + 1;
			}
			m = (startPos + endPos) / 2;
		}
			
		return -1;
	}
		

	public static Date[] bubbletSort(Date[] d){
		int len = d.length;
		for(int i = len - 1;i > 0;i--){
			for(int j = 0;j < i;j++){
				if( d[j].compare(d[j+1]) > 0){
					Date temp = d[j];
					d[j] = d[j+1];
					d[j+1] = temp;
				}
			}
		}
		return d;
	}
}

