package Methods_of_Creating_Threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Countdown Latches

class processorRunnable implements Runnable{

	private CountDownLatch latch;
	
	public processorRunnable(CountDownLatch L){
		this.latch = L;
	}
	
	@Override
	public void run() {
		System.out.println("Started..");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		latch.countDown();
	}
	
}



public class Ch6_Countdown_Latches {
	public static void main(String[] args) {
		
		CountDownLatch L1 = new CountDownLatch(3);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for(int i=0; i<3; i++){
			executor.submit(new processorRunnable(L1));
		}
		
		try {
			L1.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Completed !!");
	}
}
