package chapterfour.join;

import java.util.concurrent.CountDownLatch;

/**
 * countdownLatch.java
 * 2016年10月18日上午12:09:08
 * @author cbb
 * TODO 要实现一个线程等待另外一个或者多个线程执行完成后，再执行相关操作，除了线程的join()方法
 * juc还提供了工具类CountDownLatch
 */
public class CountDownLatchDemo {
	static CountDownLatch countdown = new CountDownLatch(2);
	public static void main(String[] args) throws InterruptedException {
	new Thread(new Runnable(){
		@Override
		public void run() {
			countdown.countDown();
			System.out.println(1);
		}}).start();
	
	new Thread(new Runnable(){
		@Override
		public void run() {
			countdown.countDown();
			System.out.println(2);
		}}).start();
	countdown.await(); //设置当前线程为等待状态，根据countdown的值来判断，如果为0，那么等待状态线程可以执行了。
	//如果值大于0，那么就继续执行。每执行一个线程会对线程进行减1操作。
	System.out.println(3);
	
	
	
	
	}
}
