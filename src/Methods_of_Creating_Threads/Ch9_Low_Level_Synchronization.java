package Methods_of_Creating_Threads;

import java.util.LinkedList;

class processsor{
	private LinkedList<Integer> list = new LinkedList<Integer>();
	private final int LIMIT=10;
	
	public void produce() {
		int value=0;
		
		while(true){
			list.add(value);
		}
		
	}
	
	
	public void consume(){
		while(true){
			System.out.println("List Size is: "+list.size());
			int value = list.removeFirst();
			System.out.println("; value is: "+value);
		}
		
	}
}


public class Ch9_Low_Level_Synchronization {

	
	
}
