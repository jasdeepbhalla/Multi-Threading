package Methods_of_Creating_Threads;
// Synchronized Keyword
public class Ch3_Synchronized_Keyword {
	
	private int count = 0;
	private int Sync_count = 0;
	
	public synchronized void increment(){
		Sync_count++;
	}
	
	public static void main(String[] args) {
		
		Ch3_Synchronized_Keyword ss = new Ch3_Synchronized_Keyword();
		ss.doWorkwithoutSynchronized();
		System.out.println();
		
		ss.doWorkwithSynchronized();
	}

	public void doWorkwithoutSynchronized(){
		
		Thread t1 = new Thread(new Runnable(){
			
			@Override
			public void run(){
				for(int i=0; i<10000;i++){
					count++;
				}
			}
		});
		
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				for(int i=0; i<10000;i++){
					count++;
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Output without syncronization\ncount: "+count);
	}
	
	
public void doWorkwithSynchronized(){
		
		Thread t3 = new Thread(new Runnable(){
			
			@Override
			public void run(){
				for(int i=0; i<10000;i++){
					increment();
				}
			}
		});
		
		
		Thread t4 = new Thread(new Runnable(){
			public void run(){
				for(int i=0; i<10000;i++){
					increment();
				}
			}
		});
		
		t3.start();
		t4.start();
		
		try {
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nOutput with syncronization\nSync_count: "+Sync_count);
	}
}
