package chapterfour.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolService.java
 * 2016��10��18������11:02:06
 * @author cbb
 * TODO ����һ���̳߳صķ�����
 */
public class ThreadPoolService {
	
	private static final int coreThreadNum = 0; //�����߳���
	private static final int maxThreadNum = 10; //����߳���
	private BlockingQueue<Runnable> blockQueue = new LinkedBlockingQueue<Runnable>(20); //�洢�������������
	private BlockingQueue<Runnable> cachaQueue = new LinkedBlockingQueue<Runnable>(30); //������У�������Ҫ�����񣬻���������
	
	private long keepAliveTime = 30000L; 
	private ThreadPoolExecutor threadpool = new ThreadPoolExecutor(coreThreadNum, maxThreadNum, keepAliveTime, TimeUnit.MILLISECONDS, blockQueue, new DefineAbortPolicy());
	public void test(){
		for(int i = 0; i < 40; i++){
			System.out.println("task id :" + i);
			threadpool.execute(new WorkTask());
			//���̳߳����ύ����,execute()������û�н�����صġ�
		}
	}
	class WorkTask implements Runnable{
		@Override
		public void run() {
			try{
				Thread.sleep(5000L);
			}catch(Exception ex){
				
			}
			System.out.println("ThreadName:"+ Thread.currentThread().getName() + "executor thread pool");
		}
	}
	
	class DefineAbortPolicy implements RejectedExecutionHandler{
		@Override
		public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadpoolexecutor) {
			cachaQueue.add(runnable);
			System.out.println("blocking queue is full!");
		}
	}
	//ִ�л����е�����
	public void executorCacheTask(BlockingQueue<Runnable> cacheQueue) throws InterruptedException{
		while(cacheQueue.size() != 0){
			threadpool.execute(cacheQueue.take());
		}
			
	}
	public void shutDown(){
		System.out.println("cachaQueue:" + cachaQueue.size());
		threadpool.shutdown();
	}
	public BlockingQueue<Runnable> getRunnable(){
		return cachaQueue;
	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadPoolService service = new ThreadPoolService();
		service.test();
		service.executorCacheTask(service.getRunnable());
		service.shutDown();
	}
}
