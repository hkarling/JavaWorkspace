package thread;

public class SynchronizedExam {
	
	public static void main(String[] args) {
		System.out.println("***메인 시작합니다.....");
		//공유객체를 생성
		Bank bank = new Bank();
		CustomerThread th1 =new CustomerThread("생산자", true);
		CustomerThread th2 =new CustomerThread("소비자", false);
		
		th1.start();
		th2.start();
		
		System.out.println("***메인 종료합니다.******");
	}
}

////////////////////////////////////////////////////////////

/** 여러 스레드가 공유할 객체 */
class Bank {
	public int balance; // 잔액
	
	/** 입금(생산자)하고 출금(소비자)하는 메소드
	 * @param name 생산자 or 소비
	 * @param state true이면 입금, false면 소비
	 * 
	 * -- wait()나 notifyAll()메소드는 반드시 synchronized 블럭 안에서 사용가능하다.
	 */
	public synchronized void balanceChange(String name, boolean state) {
		if(state) { // 입금
			if(balance < 1) {
//			synchronized (this) {
				System.out.print(name + " -> 현재 잔액: " + balance + ", ");
				balance++;
				System.out.println(name + "-> 증가후 잔액: " + balance);	
//			}
			} else {
				try {
					System.out.println("생산자 대기중입니다...");
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else { // 출금
			if(balance > 0) {
//			synchronized (this) {
				System.out.print(name + " -> 현재 잔액: " + balance + ", ");
				balance--;
				System.out.println(name + "-> 감소후 잔액: " + balance);	
//			}
			} else {
				try {
					System.out.println("소비자 대기중입니다...");
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		notifyAll();
	}
}

////////////////////////////////////////////////////////////

class CustomerThread extends Thread {
	
	static Bank bank = new Bank();
	boolean state;
	
	CustomerThread(String name, boolean state) {
		super(name);
		this.state = state;
	}
	
	@Override
	public void run() {
		for(int i=0; i< 50; i++) {
			bank.balanceChange(this.getName(), state);
		}
		System.out.println("--- "+this.getName() + " 종료 ---");
	}
}