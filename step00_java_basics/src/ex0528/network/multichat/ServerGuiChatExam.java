package ex0528.network.multichat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 클라이언트간의 멀티 채팅을 위한 서버 프로그램 서버는 접속한 클라이언트를 스레드로 만들어 List에 관리한다.
 */
public class ServerGuiChatExam {

	ServerSocket server = null;
	Socket socket;
	List<ClientSocketThread> list = new ArrayList<>();

	public ServerGuiChatExam() {
		try {
			server = new ServerSocket(8000);

			while (true) {
				socket = server.accept();
				System.out.println(socket.getInetAddress() + "님이 접속하였습니다.");
				ClientSocketThread th = new ClientSocketThread();
				th.start();
				list.add(th);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 소켓을 받아서 읽기, 보내기 가능한 스레드
	 */
	class ClientSocketThread extends Thread {
		BufferedReader br;
		PrintWriter pw;
		String name;
		String ip;

		@Override
		public void run() {
			try {
				// 윈도우와 통신시 한글 깨짐때문에 따로 케릭터셋을 정해줌...
				br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "euc-kr"));
				pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "euc-kr"), true);
				ip = socket.getInetAddress().toString();

				// 대화명 받아서 출력
				name = br.readLine();
				sendMessage("[" + name + "]님 입장하셨다.");

				while (true) {
					String message = br.readLine();
					sendMessage("[" + name + "] " + message);
				}
			} catch (Exception e) {
//				e.printStackTrace();
				System.out.println(name + "님이 나갔음.");
				list.remove(this);
				sendMessage("["+name+"]님이 퇴장하였음.");
			}
		}
	} // 이너클래스 종료

	/** 접속한 모든 클라이언트에 메시지 발송 */
	public void sendMessage(String message) {
		for (ClientSocketThread cst : list) {
			cst.pw.println(message);
		}
	}

	public static void main(String[] args) {
		new ServerGuiChatExam();
	}
}
