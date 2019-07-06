package ex0528.network.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * 클라이언트와 1:1 체팅을 위한 Server
 */

public class ServerChatExam {

	public ServerChatExam() {

		try (ServerSocket server = new ServerSocket(8000);) {
			System.out.println(" ** 클라이언트 접속 대기중입니다 ***");
			Socket socket = server.accept(); // 대기

			// 보내는 스레드
			new SendThread(socket, "서버").start();

			// 받는 스레드
			new Thread() {

				@Override
				public void run() {
					try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "euc-kr"));) {
						while (true) {
							String message = br.readLine();
							System.out.println(message);
							String str[] = message.split(":");
							if (str[1].equals("exit"))
								break;
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println("-- 서버측 스레드 종료 --");
					System.exit(0);
				}
			}.start();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		new ServerChatExam();
	}
}
