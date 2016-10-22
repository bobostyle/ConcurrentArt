package chapterfour.join;
 /**
 * JoinDemo.java
 * 2016��10��17������10:47:37
 * @author cbb 
 * TODO ����ʮ���̣߳���ִ��main�̣߳�Ȼ������ִ���߳�1��10����һ���߳�û��ִ���꣬��һ���̲߳���ִ��
 * ���߳�A��ִ��Thread.join(),��ô�߳�A�����ȵ��߳�Threadִ����󣬲Ŵ�Thread.join()����
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
