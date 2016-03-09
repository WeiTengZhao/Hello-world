public class TestArray2{
	public static void main(String [] args){
		int a[] ;
		a = new int[args.length];
		for(int i=0;i<args.length;i++){
			a[i] =  Integer.parseInt(args[i]);
		}
		printf(a);
		selectNumber(a);
		printf(a);		
	}

	private static void selectNumber(int [] a){
			int k,temp;
			for(int i=0;i<a.length;i++){
				k = i;
				for(int j=i+1;j<a.length;j++){
					if(a[j] < a[i]){
						//int m;
						k = j;
						if(k != i){
							temp = a[i];
							a[i] = a[j];
							a[j] = temp;
						}	
				}
			}
		}
	}		
	private static void printf(int[] a){
		for (int k=0;k<a.length;k++){
			System.out.print(a[k] + " ");
		}
		System.out.println();

	}
}