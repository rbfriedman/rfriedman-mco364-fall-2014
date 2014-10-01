package friedman.threads;

public class MultiThreadingPrintingBusyLoop {
	public static void main(String[] args){
		Thread[] threads = new Thread[5];
		for(int i =0; i <threads.length ;i++){
			final int curr =i;
			threads[i] = new Thread(){
				public void run(){
					System.out.println(curr);
				}
			};
			threads[i].start();
		}
		
		int alive = threads.length;
		while(alive >0){
			alive = 0;
			for(int i =0; i <threads.length ; i++){
				if(threads[i].isAlive()){
					alive++;
				}
			}
		}
		
		System.out.println("finished");
	}
}
