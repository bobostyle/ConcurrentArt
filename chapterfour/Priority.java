package chapterfour;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Priority.java
 * 2016��10��13������11:12:53
 * @author cbb
 * TODO ��ʹ���̳߳ش���10���߳�
 * �ڲ���;�̬�ڲ��࣬һ���̶߳����ڲ���
 */
public class Priority {
	private static volatile boolean notStart = true;
	private static volatile boolean notend = true;
	
	static class Job implements Runnable {
		private int priority;
		private long jobCount;
		public Job(int priority){
			this.priority = priority;
		}
		@Override
		public void run() {
			while(notStart){
				Thread.yield();
			}
			while(notend){
				Thread.yield();
				jobCount++;
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		List<Job> jobs = new ArrayList<Job>();
		for(int i = 0; i < 10; i++){
			int priority = (i < 5) ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY; 
			Job job = new Job(priority);
			jobs.add(job);
			Thread thread = new Thread(job, "Thread:"+i);
			thread.start();
		}
		notStart = false;
		TimeUnit.SECONDS.sleep(10);
		notend = false;
		for(Job job : jobs){
			System.out.println("Job poririty: " + job.priority + ",Count:"
					+ job.jobCount);
		}
	}
	
}
