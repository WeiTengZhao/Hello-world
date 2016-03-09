public class TestProductConsumer {
	public static void main(String[] args) {
		synStack ss = new synStack();
		Producter p1 = new Producter(ss);
		Consumer c1 =  new Consumer(ss);
		Thread p = new Thread(p1);
		Thread c = new Thread(c1);
		p.start();
		c.start();
	}
}

//====================================================================================

class Woto {
	int id;
	Woto(int id) {
		this.id = id;
	}
	public String toString(){
		return("第" + id + "个窝头");
	}
}

//====================================================================================

class synStack {
	Woto arrwoto[] = new Woto[6]; 
	int index = 0;
	
	public synchronized void push(Woto wt) {
		while(index == arrwoto.length) {
			try{
				this.wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			 }
		}
		this.notify();
		arrwoto[index] = wt;
		index ++;
		//System.out.println("生产了：" + wt);
			
		

	}

	public synchronized  Woto pop() {
		while(index == 0) {
			try{
				this.wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
		 	 }
		}	
		this.notify();
		index --;
		return(arrwoto[index]);
		//System.out.println("消费了:" + arrwoto[index]);
		
	}
}

//=====================================================================================

class Producter implements Runnable{
	synStack ss = null;
	Producter(synStack ss){
		this.ss = ss;
	}
	public void run(){
		for(int i=0; i<20; i++){
			Woto wt = new Woto(i);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			 }
			ss.push(wt);
			System.out.println("生产了：" + wt);

		}
	}
}

//=====================================================================================

class Consumer implements Runnable{
	synStack ss = null;
	Consumer(synStack ss){
		this.ss = ss;
	}
	public void run(){
		for(int i=0; i<20;i++){
			try{
				Thread.sleep(20000);
			}catch(InterruptedException e){
				e.printStackTrace();
			 }
			Woto wt = ss.pop();
			System.out.println("消费了:" + wt);
		}
	}
}