package ex0527.thread;

public class ThreadExam {

	public static void main(String[] args) {
		System.out.println("****** 메인 시작합니다 ******");
		NumberThread th1 = new NumberThread("첫번째 스레드");
		NumberThread th2 = new NumberThread("두번째 스레드");
		
		AlphaThread alpha = new AlphaThread();
		Thread th3 = new Thread(alpha, "세번째 스레드");
		
//		th1.run();
//		th2.run();
//		th3.run();
		
		/** 우선순위를 설정 */
//		th1.setPriority(Thread.MIN_PRIORITY);
//		th2.setPriority(Thread.MAX_PRIORITY);
		
		/** 스레드를 준비합니다. */
		th1.start();
		th2.start();
		th3.start();
		
//		try {
//			th1.join(); // th1이 샐행이 끝나기 전까지 이하가 실행이 안됨.
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		System.out.println(th1.total);
		
		System.out.println("****** 메인을 종료합니다 ******");
	}

}

//////////////////////////////////////////////////////

/** 1부터 100까지 출력하는 스레드 */
class NumberThread extends Thread {
	
	int total;

	public NumberThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println(super.getName() + " = " + i + ", getPriority = " + super.getPriority());
			total += i;
			
//			try {
//				Thread.sleep(100);// 0.1초 동안 대기상태
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			Thread.yield(); // 양보상태가 
		}
		System.out.println("====== " + super.getName() + " End =======");
	}
}

//////////////////////////////////////////////////////

/** A부터 Z까지 출력하는 스레드 */
class AlphaThread implements Runnable {

	@Override
	public void run() {
		// 현재 동작하고 있는 스레드 구하기
		Thread th = Thread.currentThread();
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(th.getName() + " = " + ch+ ", getPriority = " + th.getPriority());
			
//			try {
//				Thread.sleep(10);// 0.1초 동안 대기상태
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
			Thread.yield();
		}
		
		System.out.println("====== " + th.getName() + " End ======");
	}
}