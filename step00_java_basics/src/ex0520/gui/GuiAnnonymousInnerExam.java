package ex0520.gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GuiAnnonymousInnerExam extends JFrame {

	/** Serial Version ID */
	private static final long serialVersionUID = 4688231795975426811L;

	/** 버튼 필드 */
	JButton button1 = new JButton("Click 1");
	JButton button2 = new JButton("Click 2");
	JTextField txtField = new JTextField(20);

	public GuiAnnonymousInnerExam() {
		super("Gui실습이오");

		/** 옵션설정 */
		this.setSize(300, 200);

		/** 위치설정 */
//		this.setLocation(400, 300);
		this.setLocationRelativeTo(null); // 시작시 화면 정중앙에서 생성

		/** 컨테이너 위에 컴포넌트를 추가한다. */
		Container container = super.getContentPane(); // 컨테이너
		container.setLayout(new FlowLayout()); // FlowLayout으로 변경. JFrame의 기본레이아웃은 BorderLayout이다.
		container.add(button1);
		container.add(button2);
		container.add(txtField);

		/** 창을 보이게 함 */
		this.setVisible(true);

		/** 창을 껐을때 프로그램 종료 */
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/** 이벤트 등록. 보통 생성자의 마지막 부분에 작성한다 주체.addXxxListener(이벤트 처리해놓은 클래스) */
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtField.setText(e.getActionCommand() + " 클릭됨..");
			}
		});
		
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtField.setText(e.getActionCommand() + " 눌렀냐..");
			}
		});

		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				/** 기능 구현 */
				int x = e.getX();
				int y = e.getY();
				txtField.setText("x = " + x + ", y = " + y);
			}
		});
		
		txtField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// 키보드의 키를 구해옴
				int code = e.getKeyCode();
				button2.setText(e.getKeyChar() + "");
				System.out.println("code: " + code);
			}
			
		});
	}

	public static void main(String[] args) {
		new GuiAnnonymousInnerExam();
	}
}
