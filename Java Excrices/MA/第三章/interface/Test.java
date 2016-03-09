public class Test{
	public static void main(String [] args){
		Valueable v = new GoldenMonkey("M");
		v.getMoney();
		//Protectable p = new GoldMonkey();
		Protectable p = (Protectable) v;
		p.beProtect();
	}
}