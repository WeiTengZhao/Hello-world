public class TestSync implements Runnable{
	Timer timer = new Timer();
	public static void main (String[] args) {
		TestSync test = new TestSync();
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);
		
		t1.setName("t1");
		t2.setName("t2");
		
		t1.start();
		t2.start();
	}

	public void run() {
		timer.add(Thread.currentThread().getName());
	}
}


class Timer {
	private static int num;
	public synchronized void add(String name) {
		num ++;
		//synchronized(this) 为此对象添加排它锁
		try{
			Thread.sleep(1);
		}catch(InterruptedException e) {
			e.printStackTrace();
		 }
		System.out.println(name + " 正在使用第 " + num + "号线程");
	}
}