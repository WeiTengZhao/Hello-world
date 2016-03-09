public class TestYield {
	public static void main(String[] args) {
		reThread t1 = new reThread("T111111");
		reThread t2 = new reThread("T222222222");
		
		t1.start();
		t2.start();	
				
	}
}


class reThread extends Thread {
	reThread(String s) {
		super(s);
	}
	public void run(){
		for(int i=0; i<100; i++) {
			System.out.println(getName() + " " + i);
			if(i % 10 == 0){
					yield();
				
			}
		}
	}
}