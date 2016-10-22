package chapterfour.join;

import java.util.concurrent.CountDownLatch;

/**
 * countdownLatch.java
 * 2016��10��18������12:09:08
 * @author cbb
 * TODO Ҫʵ��һ���̵߳ȴ�����һ�����߶���߳�ִ����ɺ���ִ����ز����������̵߳�join()����
 * juc���ṩ�˹�����CountDownLatch
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
	countdown.await(); //���õ�ǰ�߳�Ϊ�ȴ�״̬������countdown��ֵ���жϣ����Ϊ0����ô�ȴ�״̬�߳̿���ִ���ˡ�
	//���ֵ����0����ô�ͼ���ִ�С�ÿִ��һ���̻߳���߳̽��м�1������
	System.out.println(3);
	
	
	
	
	}
}
