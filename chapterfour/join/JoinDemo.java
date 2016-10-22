package chapterfour.join;
 /**
 * JoinDemo.java
 * 2016年10月17日下午10:47:37
 * @author cbb 
 * TODO 创建十个线程，先执行main线程，然后依次执行线程1到10，上一个线程没有执行完，下一个线程不能执行
 * 在线程A中执行Thread.join(),那么线程A必须先等线程Thread执行完后，才从Thread.join()返回
 */
public class JoinDemo {
	
	static class ThreadDemo implements Runnable{
		private Thread previous;
		public ThreadDemo(Thread demo){
			previous = demo; 
		}
		@Override
		public void run() {
			try{
				previous.join();
			}catch(Exception ex){
				
			}
			System.out.println(Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args){
		Thread previous = Thread.currentThread();
		for(int i = 0; i < 10; i++){
			Thread threaddemo = new Thread(new ThreadDemo(previous),"ThreadName:" + i);
			threaddemo.start();
			previous = threaddemo;
		}
		try{
			Thread.sleep(5000);
		}catch(Exception ex){
			
		}
		System.out.println(Thread.currentThread().getName());
	}
}
