import java.util.*;
public class TestSleep {
	public static void main(String[] args){
		Round r = new Round();
		Thread t = new Thread(r);
		t.start();
		try {
			t.sleep(10000);
		}catch(InterruptedException e1){
			e1.printStackTrace();
	 	}
		t.interrupt();
	}
}

class Round implements Runnable {
	public  void run() {
		while(true){
			System.out.println("=====" + new Date() +"======");
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				return;
			 }
		}
	}
}