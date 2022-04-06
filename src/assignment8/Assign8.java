package assignment8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Assign8 {

	public static void main(String[] args) {
		int min = 1;  
		int max = 10;  
		//Generate random double value from 200 to 400   
		//System.out.println("Random value of type double between "+min+" to "+max+ ":");  
		Integer ran = 0;
		//ran = (int)(Math.random()*(max-min+1)+min);   
		List<Integer> listx1 = new ArrayList<Integer>();
		
		for(int i=0; i < 199999999;i++) {
		ran = (int)(Math.random()*(max-min+1)+min);   
		listx1.add(ran);
		}	
		 	
        		CountDownLatch latch = new CountDownLatch(1);
        		// Instantiate 3 threads and three types
					Thread Thread1 = new Thread( new sumMultipleOne("One",listx1,latch));
					Thread Thread2 = new Thread( new sumMultipleTwo("Two",listx1,latch));
					Thread Thread3 = new Thread( new sumSingle("Two",listx1));			
					
			//start thread3 	
					//Thread3.start();
			//start thread 1 but with CountDownLatch
					Thread1.start();
		
				//start thread 2 but with CountDownLatch
					Thread2.start();
				
					//CountDownLatch for thread1 and thread2

					latch.countDown();         
					
///WARNING eXTREMLY LONG LIST OF 200 MILLION NUMBERS COMMENTED OUT!!!!!!!!!!!
		//System.out.println(listx1);

						Thread3.start();

	}

}
