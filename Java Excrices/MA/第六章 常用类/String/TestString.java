public class TestString{
public static void main(String [] args){
		String s ="I have a story to tell.Do you hear me tonight.";
		int lConst = 0;
		int uConst = 0;
		int oConst = 0;
		for(int i = 0;i < s.length();i ++){
			char c = s.charAt(i);
			if(c > 'a' && c < 'z'){
				lConst ++;
			}
			else if(c > 'A' && c < 'Z'){
				uConst ++;
			}
			else{
				oConst ++;
			}
		}
		System.out.println(lConst + " " + uConst + " " + oConst);
	}
}