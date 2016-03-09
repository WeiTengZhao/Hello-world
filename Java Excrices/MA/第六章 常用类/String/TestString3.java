public class TestString3{
	public static void main(String [] args){
		String s ="I have a story to tell.Do you hear me tonight.";
		int lConst = 0;
		int uConst = 0;
		int oConst = 0;
		for(int i = 0;i < s.length();i ++){
			char c = s.charAt(i);
			if(Character.isLowerCase(c) == true ){
				lConst ++;
			}
			else if(Character.isUpperCase(c) == true){
				uConst ++;
			}
			else{
				oConst ++;
			}
		}
		System.out.println(lConst + " " + uConst + " " + oConst);
	}
}