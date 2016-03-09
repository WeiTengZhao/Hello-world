public class For {
	public static void main(String[] args) {
		System.out.println(div(5));
	}
	public static double div(int n) {
		double a = -1;
		double sum = 0 ;
		for(int i=1;i<=n;i++) {
			a = a * (-1);
			sum = sum + a/i; 
		}
		return sum;
	}
}