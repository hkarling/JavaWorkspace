package ex0527.thread;

/**
 * DaemonThread란 메인스레드가 종료되면 함께 종료되는 스레드
 * @author hkarling
 */
public class DeamonThreadExam {

	public static void main(String[] args) {
		System.out.println("****** 메인시작 ******");
		
		Thread thread = new Thread(){

			@Override
			public void run() {
				while(true) {
					System.out.println("난 Daemonthread입니다... ");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		thread.setDaemon(true);
		thread.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("****** 메인끗 ******");
	}
}
