package network.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

/**
 * 서버와 1:1 채팅을 위한 클라이언트
 */
public class ClientChatExam {

	public ClientChatExam() {

		try {
//			Socket socket = new Socket("192.168.0.169", 8000);
			Socket socket = new Socket("127.0.0.1", 8000);
			if(socket.isConnected()) {
				System.out.println(socket.getInetAddress());
				System.out.println("연결됨!!");
				new Thread(new ReceiveThread(socket, "클라")).start();
				new SendThread(socket, "클라").start();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ClientChatExam();
	}

	class ReceiveThread implements Runnable {
		Socket socket;
		String name;

		@Override
		public void run() {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "euc-kr"));) {
				while (true) {
					String message = br.readLine();
					System.out.println(message);
					String str[] = message.split(" : ");
					if (str[1].equals("exit"))
						break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("-- 클라쪽 스레드 종료 --");
			System.exit(0);
		}

		public ReceiveThread(Socket socket, String name) {
			this.socket = socket;
			this.name = name;
		}
	}
}
