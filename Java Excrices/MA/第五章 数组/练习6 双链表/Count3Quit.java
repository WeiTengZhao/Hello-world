public class Count3Quit{
	public static void main(String [] args){
		KidCircle kc = new KidCircle(500);
		Kid k = kc.first;
		int countNum = 0;
		while(kc.count > 1){
			countNum ++;
			if(countNum == 3){
				countNum = 0;
				kc.delete(k);
			}
			k = k.right;
		}
		System.out.println(kc.first.id);
	}
}