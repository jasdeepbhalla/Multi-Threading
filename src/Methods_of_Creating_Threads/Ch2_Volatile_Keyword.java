package Methods_of_Creating_Threads;

import java.util.Scanner;

//Thread volatile keyword

class processor extends Thread{
	// no caching can be done. guarantees that it will work
	private volatile boolean running = true;
	
	public void run(){
		while (running) {
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void shutdown(){
		running = false;
	}
	
	
}


public class Ch2_Volatile_Keyword {


	public static void main(String[] args) {
		processor proc1 = new processor();
		proc1.start();
		
		System.out.println("Press return to stop....");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		
		proc1.shutdown();
		
	}
	
}
