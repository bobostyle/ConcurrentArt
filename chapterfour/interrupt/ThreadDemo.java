package chapterfour.interrupt;

 /**
 * ThreadDemo.java
 * 2016年10月20日上午12:16:00
 * @author cbb
 * TODO
 */
public class ThreadDemo extends Thread{
	
	private boolean isStop = false;
	@Override
	public void run(){
		try{
		while(!isStop()){
			Thread.sleep(1000);
			System.out.println("thread");
		}}catch(Exception ex){
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			System.out.println("interrupt thread");
		}
	}
	
	public boolean isStop(){
		return isStop;
	}
	
	public void setStop(boolean flag){
		isStop = flag;
	}
	
	public void stopThread(){
		setStop(true);
		//this.interrupt();
	}
	
}
