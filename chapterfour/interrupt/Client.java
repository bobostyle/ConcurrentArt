package chapterfour.interrupt;

 /**
 * Client.java
 * 2016��10��20������12:21:15
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
