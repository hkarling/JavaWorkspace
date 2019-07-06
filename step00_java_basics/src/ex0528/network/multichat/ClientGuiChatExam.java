package ex0528.network.multichat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ClientGuiChatExam extends JFrame {
	JTextArea textArea = new JTextArea();
	JScrollPane jsp = new JScrollPane(textArea);
	JTextField text = new JTextField();

	Socket socket;
	PrintWriter pw;
	BufferedReader br;

	public ClientGuiChatExam() {

		textArea.setFocusable(false); // 텍스트에어리어에 커서 놓기 금지
		textArea.setBackground(new Color(153, 255, 204));
		text.requestFocus(true); // 텍스트필드에 커서 놓기

		/** 컴포넌트 붙이기 */
		Container con = this.getContentPane();
		con.add(text, BorderLayout.SOUTH);
		con.add(jsp);

		/** 창 속성 설정 */
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		/** 창 띄우기 및 종료 옵션 */
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		connect();

		// 이벤트 등록
		text.addActionListener(new ActionListener() {

			@SuppressWarnings("unlikely-arg-type")
			@Override
			public void actionPerformed(ActionEvent e) {
				// textField 값을 읽어서 서버에게 보낸다.
				pw.println(text.getText());
				if (text.equals("exit")) {
					try {
						socket.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.exit(0);
				}
				text.setText("");

			}
		});
	} // 생성자 끗

	/** 서버에 접속하는 메소드 */
	void connect() {
		try {
//			socket = new Socket("192.168.0.169", 8000);
			socket = new Socket("127.0.0.1", 8000);
			socket.setSoLinger(true, 0); // TIME_WAIT 줄이기

			// 대화명 입력
			String name = JOptionPane.showInputDialog("대화명을 입력하시오.");

			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "euc-kr"), true);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "euc-kr"));

			// 대화명 보내기
			pw.println(name);

			// 서버가 보내오는 데이터를 읽는 스레드가 필요.
			new Thread() {

				@Override
				public void run() {
					try {
						while (true) {
							String message = br.readLine();
							textArea.append(message + "\n");
							textArea.setCaretPosition(textArea.getText().length());
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ClientGuiChatExam();
	}
}
