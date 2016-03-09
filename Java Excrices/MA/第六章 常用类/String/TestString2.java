public class TestString2{
	public static void main(String [] args){
		String s ="I have a story to tell.Do you hear me tonight.";
		int lConst = 0;
		int uConst = 0;
		int oConst = 0;
		String sL ="abcdefghijklmnopqrstuvwxyz";
		String sU = sL.toUpperCase();
		for(int i = 0;i < s.length();i ++){
			char c = s.charAt(i);
			if(sL.indexOf(c) != -1){
				lConst ++;
			}
			else if(sU.indexOf(c) != -1){
				uConst ++;
			}
			else{
				oConst ++;
			}
		}
		System.out.println(lConst + " " + uConst + " " + oConst);
	}
}