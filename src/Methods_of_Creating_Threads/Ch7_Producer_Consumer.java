package Methods_of_Creating_Threads;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Ch7_Producer_Consumer {
	
	BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10); 	
	
	
	private void producer() throws InterruptedException{
		Random random = new Random();
		while(true){
			queue.put(random.nextInt(100));
		}
	}

	private void consumer() throws InterruptedException{
		Random random = new Random();
		while(true){
			Thread.sleep(100);
	
			if(random.nextInt(10)==0){
				Integer value = queue.take();
			
			
			}
		}
	}
	
	
	
}
