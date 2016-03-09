public class Lady{
	private String name;
	private Animal a;
	Lady(String name,Animal a){
		this.name = name;
		this.a = a;
	}

	public void aenjoy(){
		a.enjoy();
	}
}