package gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GuiExam extends JFrame implements ActionListener {

	/** Serial Version ID */
	private static final long serialVersionUID = -8305288678203900476L;

	/** 버튼 필드 */
	JButton button1 = new JButton("Click 1");
	JButton button2 = new JButton("Click 2");
	JTextField txtField = new JTextField(20);

	public GuiExam() {
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
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		this.addMouseListener(new MouseExam(txtField));

	}

	public static void main(String[] args) {
		new GuiExam();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("버튼이 눌려졌음");
		
		/** 현재이벤트를 발생시킨 주체(Component)를 찾기 */
		Object obj = e.getSource();
		
		if(obj == button1)
//			System.out.println(e.getActionCommand() + " 눌려졌음.");
			
			// JTextField 위에 문자열 넣기
			txtField.setText(e.getActionCommand() + " 눌려졌음");
		else
//			System.exit(0);	// 프로그램 종료
			txtField.setText(e.getActionCommand() + " 클릭");

	}
}

////////////////////////////////////////////////////////////////////

/** 마우스이벤트 클래스 */
class MouseExam extends MouseAdapter {
	
	JTextField txtField;
	
	public MouseExam() {
		
	}
	
	public MouseExam(JTextField txtField) {
		this.txtField = txtField;
	}

	/** 필요한 메서드 재정의 */
	@Override
	public void mouseClicked(MouseEvent e) {
		
		/** 기능 구현 */
		int x = e.getX();
		int y = e.getY();
//		System.out.println("x = " + x + ", y = " + y);
		txtField.setText("x = " + x + ", y = " + y);
	}
}