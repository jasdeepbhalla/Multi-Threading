package Methods_of_Creating_Threads;

import java.util.Scanner;


class processorWN{

	public void producee() throws InterruptedException
	{
		synchronized (this) {
			System.out.println("Producer thread running");
			wait();
			System.out.println("Resumed....");
		}
	}

	public void consumee() throws InterruptedException
	{
		Scanner sc = new Scanner(System.in);
		Thread.sleep(3000);

		//same locks in both synchronized
		synchronized (this) {
			System.out.println("Waiting for return Key...");	
			sc.nextLine();
			System.out.println("Return Key Pressed...");
			notify();
		}

	}

}

public class Ch8_Wait_And_Notify {

	public static void main(String[] args) {
		final processorWN processor = new processorWN();

		Thread t1 = new Thread(new Runnable(){
			public void run() {
				try {
					processor.producee();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable(){
			public void run() {
				try {
					processor.consumee();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
 		}

	}

}
