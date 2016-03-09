public class TestThread2 {
	public 	static void main(String[] args) {
		Round r = new Round();
		//Thread t = new Thread(r);
		r.start();

		for(int i=0; i<100; i++) {
			System.out.println("----Thread-----"+ " "+i);
		}
	}
}

class Round extends Thread { //从Thread 继承实现多线程
	public  void run() {
		for(int i=0; i<100; i++) {
			System.out.println("Round:" + i);
		}
	}
}
