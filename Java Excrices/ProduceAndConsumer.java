public class ProduceAndConsumer {
	public static void main(String[] args) {
		try{
			Ticket t = new Ticket(10);
			Producter p = new Producter(t);
			Consumer c = new Consumer(t);
			Thread tr = new Thread(p);
			Thread tr2 = new Thread(c);
			tr.start ();
			tr.sleep(1000);
			tr2.start();
		}catch(Exception e){}
	}
}


class Ticket {
	int number = 0;
	int size;
	int i = 0;
	boolean avelible = false;
	public Ticket(int size) {
		this.size = size;
	}
	
	public synchronized void setTicket() {
		System.out.println("Producer has set the Ticket:" + (++number) );
		avelible = true;	
	}
	
	public synchronized void sellTicket() {
		while(avelible == true && i < number){
			System.out.println("Consumer has bought the Ticket:" + (++i) );
		}

		while(i == number) {
			avelible = false;
		}
		
	}
}

class Producter implements Runnable {
	Ticket t = null;
		
	public Producter(Ticket t) {
		this.t = t;
	}
	
	public void run() {
		while(t.number < t.size) {
			t.setTicket();
		}
	}
}

class Consumer implements Runnable {
	Ticket t = null;

	public Consumer(Ticket t) {
		this.t = t;
	}

	public void run() {
		while(t.avelible) {
			t.sellTicket();
		}
	}
}
