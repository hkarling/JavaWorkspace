package ch12;

import java.awt.Toolkit;

public class BeepPrintExample1 {

	public static void main(String[] args) {

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class BeepTask implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}