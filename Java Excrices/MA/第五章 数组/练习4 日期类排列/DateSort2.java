public class DateSort2{
	public static void main(String [] args){
		Date []day = new Date [5];
		day[0] = new Date(2006,5,4);
		day[1] = new Date(2006,7,4);
		day[2] = new Date(2008,5,5);
		day[3] = new Date(2004,5,9);
		day[4] = new Date(2004,5,4);
		print(day);
		System.out.println();
		bubbletSort(day);
		print(day); 
	}
	
	public static void print(Date[] d){
		for(int i = 0;i < d.length; i++){
			System.out.println(d[i]);	
		}
	}

	public static Date[] bubbletSort(Date[] d){
		int k ;
		Date temp;
		for(int i = 0;i < d.length;i++){
			k = i;
			for(int j = i+1;j < d.length;j++){
				if (d[j].compare(d[i]) < 0){
					k = j;
					if(k != i){
						temp = d[k];
						d[k] = d[i];
						d[i] = temp;
					}	
				}
			}
		}
		return d;
	}
}

