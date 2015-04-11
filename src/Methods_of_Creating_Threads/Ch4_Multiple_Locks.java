package Methods_of_Creating_Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.SynchronousQueue;

import javax.sql.rowset.spi.SyncFactory;

class worker{

	private Random random = new Random();

	private Object lock1 = new Object();
	private Object lock2 = new Object();

	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();

	public void stage1(){
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			list1.add(random.nextInt(100));
		}

	}

	public void stage2(){
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));
		}
	}

	public void process(){
		for(int i=0;i<1000;i++){
			stage1();
			stage2();
		}
	}

	public void main() {
		System.out.println("Hello....Strating.....");
		long start = System.currentTimeMillis();

		Thread t1 = new Thread(new Runnable(){
			public void run(){
				process();
			}
		});
		t1.start();

		Thread t2 = new Thread(new Runnable(){
			public void run(){
				process();
			}
		});
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();

		System.out.println("Time Taken: "+(end-start));
		System.out.println("List1: "+list1.size()+" ; "+" List2: "+ list2.size());
	}	
}


public class Ch4_Multiple_Locks {


	public static void main(String[] args) {
		new worker().main(); 
	}
}
