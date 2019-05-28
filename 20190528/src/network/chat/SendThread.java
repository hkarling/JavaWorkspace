package network.chat;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client와 서버가 상대측의 키보드 입력을 받아 입력한 메시지를 상대측에게 전송
 */
public class SendThread extends Thread {

	Socket socket;
	String name;

	SendThread(Socket socket, String name) {
		this.socket = socket;
		this.name = name;
	}
	
	@Override
	public void run() {
		
		// 키보드 입력을 받는다
		Scanner scanner = new Scanner(System.in);
		
		// 상대측에게 전송한다
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "euc-kr"), true);
			while(true) {
				String message = scanner.nextLine();
				pw.println(name + " : " + message);
				if(message.equals("exit"))
					break;
			}
			System.out.println(name + " 종료");
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(name + ": 오류발생...");
		} finally {
			scanner.close();
		}
	}
}
