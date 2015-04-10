package Methods_of_Creating_Threads;


//first way of starting a thread in Java
class Runner extends Thread{
	public void run(){
		
		for(int i=0; i<10; i++){
			System.out.println("Hellow "+ i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class RunnerUsingRunnable implements Runnable{
public void run(){
		
		for(int i=0; i<10; i++){
			System.out.println("Hellow "+ i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


public class Threading {
	public static void main(String[] args) {

		//extends Thread method
		Runner runner1 = new Runner();
		runner1.start();
		
		Runner runner2 = new Runner();
		runner2.start();
		
		System.out.println();
		System.out.println();

		
		//implements Runnable method
		Thread t1 = new Thread(new RunnerUsingRunnable());
		Thread t2 = new Thread(new RunnerUsingRunnable());
		
		t1.start();
		t2.start();
		

		//Threads Using an anonymous class {Without creating extra class}
		Thread anonymous = new Thread(new Runnable(){
			public void run() {
				for(int i=0; i<10; i++){
					System.out.println("Hellow "+ i);
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
			
		});
		
		anonymous.start();
	}
}
