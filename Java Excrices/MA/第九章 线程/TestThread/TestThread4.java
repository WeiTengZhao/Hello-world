public class TestThread4 {
	public static void main(String[] args) {
		reThread r = new reThread();
		Thread t = new Thread(r);
		t.start();
		for(int  i=0; i<10000; i++) {
			if(i%100 ==0 & i>0) {
				System.out.println("This is the main======================");
			}
		}
		System.out.println("The Program is Over!");
		r.shutdown();
	}
}



class reThread implements Runnable{
	boolean flat = true;
	public void run() {
		int i = 0;
		while(flat == true) {
			++i;
			System.out.println("This Chilrend   "+i);
		}
	}

	public void shutdown(){
		flat = false;
	}
}