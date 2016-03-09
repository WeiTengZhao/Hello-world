public class TestPriority {
	public static void main(String[] args) {
		MyThread m2 = new MyThread(2);
		MyThread m1 = new MyThread(1);

		m1.setPriority(Thread.MAX_PRIORITY);
		m2.setPriority(Thread.MIN_PRIORITY);
		
		m1.start();
		m2.start();		
	}
}

class MyThread extends Thread {
	int num;
	public MyThread(int num){
		this.num = num;
	}
	public void run() {
		for(int i =0 ;i <= 400000;i++) {
			if( (i%50000) == 0) {
				System.out.println(num + " " + i +" "+ getPriority());
				//System.out.println(getPriority());
				//yield();
			}	
		}	
	}
}