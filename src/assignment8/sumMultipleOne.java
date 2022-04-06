package assignment8;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class sumMultipleOne extends Thread implements Runnable {

		private String name;
		private List<Integer> list1;
		private CountDownLatch latch1;
		
		public sumMultipleOne(String name, List<Integer> list1, CountDownLatch latch1) {
			super();
			setName1(name);
			setList1(list1);
			setLatch1(latch1);
		}




		public String getName1() {
			return name;
		}


		public void setName1(String name) {
			this.name = name;
		}


		public List<Integer> getlist1() {
			return list1;
		}

		public void setList1(List list1) {
			this.list1 = list1;
		}

		public CountDownLatch getLatch1() {
			return latch1;
		}

		public void setLatch1(CountDownLatch latch1) {
			this.latch1 = latch1;
		}
		
	//list sum method------------------------------------

		public  Integer List1Sum(List<Integer> list1){
			Integer sum = 0;
			
			for(int i=0; i< list1.size();++i)  
			 {    
				    sum += (Integer) list1.get(i);

			 }
			return sum;    
		}

		@Override
		public void run() {
			
		
	//Start timer------------------
			long time1 = System.nanoTime();
			long time2, time3;
			Integer result = 0;
	//list sum method------------------------------------
		 
			try {
				latch1.await();
				//System.out.print("sum Multiple one runtime efficiency: ");   
				result = List1Sum(list1);
				
				}catch(Exception e)
			{
					e.printStackTrace();
			}
	// Capture the total time
			time2 = System.nanoTime(); 
			time3 = time2 - time1;
			System.out.println("Parallel Thread #1 efficiency: " + result + " in "+ time3 + " ns");
			
		}
		
		

}
