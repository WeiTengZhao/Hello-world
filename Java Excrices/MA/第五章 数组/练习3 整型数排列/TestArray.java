public class TestArray{
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
		for(int i=0;i<a.length;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[i]>a[j]){
					int m;
					m = a[i];
					a[i] = a[j];
					a[j] = m;	
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