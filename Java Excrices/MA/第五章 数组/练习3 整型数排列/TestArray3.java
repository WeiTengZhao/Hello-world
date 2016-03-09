public class TestArray3{
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
		int len = a.length;
		for(int i = len - 1;i>0;i--){
			for(int j = 0;j<i;j++){
				if(a[j] > a[j+1]){
		 			int temp;
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
							
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