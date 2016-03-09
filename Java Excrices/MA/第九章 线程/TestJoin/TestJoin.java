public class TestJoin {
	public static void main(String[] args) {
		reThread t = new reThread("HHHHH");
		t.start();
		try {
			t.join();
		}catch(InterruptedException e1) {
			e1.printStackTrace();
		 }

		for(int i=0; i<10; i++) {
			System.out.println("Main" + i);
		}
		
	}
}


class reThread extends Thread{
	reThread(String s) {
 		super(s);
	}

	public void run() {
		for(int i=0; i<10; i++){
			System.out.println( getName() + i);
			try{
				sleep(1000);
			}catch(InterruptedException e){
				return;
			 }
		}
	}
}