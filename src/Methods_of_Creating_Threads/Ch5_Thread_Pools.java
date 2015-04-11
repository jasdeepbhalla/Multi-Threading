package Methods_of_Creating_Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


class processorclass implements Runnable{
	int id;
	
	public processorclass(int id){
		this.id=id;
	}
	
	@Override
	public void run() {

		System.out.println("Starting: "+ id);
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("completed "+ id);
		
	}

}


public class Ch5_Thread_Pools {
	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		
		for(int i=0;i<5;i++){
			executor.submit(new processorclass(i));
		}
		
		executor.shutdown(); //not shutdown but it will wait for all threads to complete what thery are doing
		System.out.println("All tasks submitted.");
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		System.out.println("All tasks completed..");
	}
	
}







