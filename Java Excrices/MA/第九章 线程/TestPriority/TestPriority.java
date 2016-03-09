public class TestPriority {
	public static void main(String[] args) {
		Round1 r1 = new Round1();
		Round2 r2 = new Round2();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.setPriority(Thread.MAX_PRIORITY );
		t1.start();
		t2.start();
	}
}


class Round1  implements Runnable{
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("Round1:" + i);
		} 
		
	}
} 

class Round2  implements Runnable{
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("Round2============================="+" " + i);
		} 
		
	}
} 