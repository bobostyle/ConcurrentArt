package chapterfour.interrupt;

 /**
 * Client.java
 * 2016年10月20日上午12:21:15
 * @author cbb
 * TODO
 */
public class Client {

	public static void main(String[] args) {
		
		ThreadDemo demo = new ThreadDemo();
		demo.start();
		try{
			Thread.sleep(3000);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		demo.stopThread();
	}
}
