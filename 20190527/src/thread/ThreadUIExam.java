package thread;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ThreadUIExam extends JFrame implements Runnable {

	JTextField text1 = new JTextField(10);
	JTextField text2 = new JTextField(10);
	JButton button = new JButton("Click");

	public ThreadUIExam() {

		// Component들을 올린다.
		this.setLayout(new FlowLayout());
		Container con = this.getContentPane();
		con.add(text1);
		con.add(text2);
		con.add(button);

		this.setSize(500, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 시계 움직이기

		new Thread(this).start();
		new Decimal().start();

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 스레드 호출
				new Thread(new Runnable() {

					@Override
					public void run() {
						for (char ch = 'A'; ch <= 'Z'; ch++) {
							text2.setText(ch + "");
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}).start();
			}
		});
	}

	/** JFrame Title에 시계 움직이기 */
	@Override
	public void run() {
		while (true) {
			// 현재 날짜와 시간 설정
			Calendar now = Calendar.getInstance();
			int y = now.get(Calendar.YEAR);
			int m = now.get(Calendar.MONTH);
			int d = now.get(Calendar.DATE);
			int h = now.get(Calendar.HOUR);
			int min = now.get(Calendar.MINUTE);
			int s = now.get(Calendar.SECOND);

			StringBuilder sb = new StringBuilder();
			sb.append(y + "년 ");
			sb.append(m + "월 ");
			sb.append(d + "일  ");
			sb.append(h + ":");
			sb.append(min + ":");
			sb.append(s + "");
			super.setTitle(sb.toString());

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new ThreadUIExam();
	}

	/** 이너클래스 1~1000까지 text에 추가 */
	class Decimal extends Thread {

		@Override
		public void run() {
			for (int i = 1; i <= 1000; i++) {
				text1.setText(i + "");
				try {
					Thread.sleep(100); // 0.1초 대기
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
} // 클래스 종료
