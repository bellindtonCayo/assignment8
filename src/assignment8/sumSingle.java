package assignment8;

import java.util.List;
import java.util.concurrent.CountDownLatch;



	public class sumSingle extends Thread implements Runnable {

		private String name;
		private List<Integer> listS;
		
		
		public sumSingle(String name, List<Integer> listS) {
			super();
			setName1(name);
			setListS(listS);
		
		}




		public String getName1() {
			return name;
		}


		public void setName1(String name) {
			this.name = name;
		}


		public List<Integer> getlistS() {
			return listS;
		}

		public void setListS(List listS) {
			this.listS = listS;
		}

		//list sum method------------------------------------
		public  Integer ListSSum(List<Integer> listS){
			Integer sum = 0;
			
			for(int i=0; i< listS.size();++i)  
			 {    
				    sum += (Integer) listS.get(i);

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
				
				//System.out.print("sum Multiple one runtime efficiency: ");   
				result = ListSSum(listS);
				
				}catch(Exception e)
			{
					e.printStackTrace();
			}
	// Capture the total time
			time2 = System.nanoTime(); 
			time3 = time2 - time1;
			System.out.println("Sum Single thread efficiency:  " + result + " in "+ time3 + " ns");
			
		}
		
		

}
