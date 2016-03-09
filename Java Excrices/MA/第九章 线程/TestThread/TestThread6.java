public class TestThread6 {
	public static void main(String[] args) {
		Thread t = new Round6();
		t.start();
		for(int i=0; i<50; i++){
			System.out.println("MainThread=======" + i);
		}
	}
}

class Round6 extends Thread {
	public void run() {
		for(int i=0; i<50; i++){
			System.out.println(Thread.currentThread().isAlive());
			System.out.println("SubThread  "+ i);
		}
	}
}