package assignment8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class sumMultipleTwo extends Thread implements Runnable {

		private String name;
		private List<Integer> list2;
		private CountDownLatch latch2;
		
		public sumMultipleTwo(String name, List<Integer> list2, CountDownLatch latch2) {
			super();
			setNamex(name);
			setList2(list2);
			setLatch2(latch2);
		}


		public String getNamex() {
			return name;
		}


		public void setNamex(String name) {
			this.name = name;
		}



		public List<Integer> getlist2() {
			return list2;
		}

		public void setList2(List list2) {
			this.list2 = list2;
		}

		public CountDownLatch getLatch2() {
			return latch2;
		}

		public void setLatch2(CountDownLatch latch2) {
			this.latch2 = latch2;
		}
		//list sum method------------------------------------
		public  Integer List2Sum(List<Integer> list2){
			Integer sum = 0;
			
			for(int i=0; i< list2.size();++i)  
			 {    
				    sum += (Integer) list2.get(i);

			 }
			return sum;    
		}

		@Override
		public void run() {
				
	//Start timer------------------		
			long time1 = System.nanoTime();
			long time2, time3;
			Integer result = 0; 
			
			try {
				latch2.await();
				//System.out.print("sum Multiple two runtime efficiency: ");
	// Call to List2Sum method			
				result = List2Sum(list2);
				
					
				}catch(Exception e)
			{
				e.printStackTrace();
			}
	// Capture the total time		
			time2 = System.nanoTime(); 
			time3 = time2 - time1;	
			System.out.println("Parallel thread #2 efficiency: " + result + " in " + time3 + " ns");
		}
	}


