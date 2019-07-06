package ex0527.thread;

public class InterruptedExam {

	public static void main(String[] args) {
		System.out.println("****** 메인시작 ******");

//		Thread thread = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				try {
//					while(true) {
//						System.out.println("재밌늬? 응? 재밌냐고...");
//						Thread.sleep(300);
//					}
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		thread.start();
//		
//		try { // 5초가 지나면 
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		thread.interrupt();

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					System.out.println("재밌늬? 응? 재밌냐고...");
					if (Thread.interrupted()) 
						break;
				}
			}
		});
		thread.start();

		try { // 5초가 지나면
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * interreupt()는 반드시 sleep 또는 스레드가 대기상태가 되는 상황이어야만 스레드를 빠져나올수 있다.
		 * 또는 스레드 블럭 안에서 interrupt가 되는ㄴ지를 체크하려면 Thread.interrupted() 메소드로 체크하나다. */
		thread.interrupt(); // 강제중지 시킨다.

		System.out.println("****** 메인끗 ******");
	}
}
