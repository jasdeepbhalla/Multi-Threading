package newboston_Example_of_Threads;

import java.util.Random;

public class Tuna implements Runnable {
	String name;
	int time;
	Random r = new Random();
	
	public Tuna(String x){
		name=x;
		time=r.nextInt(999);
	}
	
	public void run(){
			
			try {
				System.out.printf("%s is sleeping for %d\n", name, time);
				Thread.sleep(time);
				System.out.println();
				System.out.printf("%s is done", name);
			} catch (Exception e) {	}
			
	}

}
