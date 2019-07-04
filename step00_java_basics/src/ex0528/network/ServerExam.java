package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * 클라이언트 접속을 기다리는 Server 클래스
 */
public class ServerExam {

	public ServerExam() {
		System.setProperty("file.encoding","ms949");
		try {
			Field charset = Charset.class.getDeclaredField("defaultCharset");
			charset.setAccessible(true);
			charset.set(null,null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try(ServerSocket server = new ServerSocket(8000);) {
			while(true) {
				System.out.println("Client접속을 기다립니다.");
				Socket socket = server.accept();
				System.out.println(socket.getInetAddress() + "님 접속.");
				
				// 클라이언트가 보내온 데이터 읽기
				InputStream is = socket.getInputStream();
				
				// byte단위 읽기 문자단위 읽기 -> 속도향상을 위해서 Buffered 	
				BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				String message = br.readLine();
				System.out.println("Client가 보낸 내용: " + message);
				
				// 클라이언트에게 데이터 보내기
				PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
				
				pw.println("잘부탁드립니이다아.");
				
				socket.close();
				System.out.println();		
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		new ServerExam();
	}
}
