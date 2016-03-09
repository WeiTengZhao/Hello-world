public class TestDeadLock implements Runnable{
	public int flag;
	static Object o1 = new Object();
	static Object o2 = new Object();

	public void run() {
		System.out.println("Flag" + flag);
		if(flag == 0) {
			synchronized(o1) {
				try{
					Thread.sleep(10);
				}catch(InterruptedException e) {
					e.printStackTrace();
			 	}
				synchronized(o2) {
					System.out.println("0");
				}
			}
		}

		if(flag == 1) {			
			synchronized(o2) {
				try{
					Thread.sleep(10);
				}catch(InterruptedException e) {
					e.printStackTrace();
			 	}
				synchronized(o1) {
					System.out.println("1");
				}
			}
		}
	}


	public static void main(String[] args) {
		TestDeadLock t1 = new TestDeadLock();
		TestDeadLock t2 = new TestDeadLock();
		t1.flag = 0;
		t2.flag = 1;
		Thread tr1 = new Thread(t1);
		Thread tr2 = new Thread(t2);

		tr1.start();
		tr2.start();
	}
}