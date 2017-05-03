package comsb.threads;

public class SimpleThreads {
	
	public Object synObject = new Object();

	public static void main(String[] args) {
		
		IdHolder idHolder = new IdHolder();

		Worker w1 = new Worker("Worker 1", idHolder);
		Thread th = new Thread(w1);

		Worker w2 = new Worker("Worker 2", idHolder);
		Thread th2 = new Thread(w2);
		
		th.start();
		th2.start();
		
		try {
			th.join();
			th2.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int finalSum = w1.getSum() + w2.getSum();
		
		System.out.println("Final Id is " + idHolder.getNextId());
	}

}

class Worker implements Runnable
{
	private String name;
	private IdHolder idHolder;
	private int sum = 0;
	
	public Worker(String name, IdHolder idHolder) {
		this.name = name;
		this.idHolder = idHolder;
	}
	public void run() {
		for(int i = 0; i < 1000; i++) {
			int nextId = idHolder.getNextId();
			
			//Do some work
		}
	}
	
	public int getSum(){
		return sum;
	}
}

class IdHolder
{
	private int nextId;
	
	
	//public synchronized int getNextId() {
	public int getNextId() {
		synchronized(this) {
			return nextId++;
		}
	}
	
}


class MyThread extends Thread
{
	public MyThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		while(true) {
			System.out.println("Hello from " + getName());
		}
	}
}
