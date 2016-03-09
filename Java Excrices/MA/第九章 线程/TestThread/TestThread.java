public class TestThread {
	public 	static void main(String[] args) {
		Round r = new Round();
		Thread t = new Thread(r);
		t.start();

		for(int i=0; i<100; i++) {
			System.out.println("----Thread-----"+ " "+i);
		}
	}
}

class Round implements Runnable {
	public  void run() {
		for(int i=0; i<100; i++) {
			System.out.println("Round:" + i);
		}
	}
}
