package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

public class ClientExam {

	public ClientExam() {
		System.setProperty("file.encoding","ms949");
		try {
			Field charset = Charset.class.getDeclaredField("defaultCharset");
			charset.setAccessible(true);
			charset.set(null,null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//149
//		try(Socket socket = new Socket("192.168.0.169", 8000);) {
		try(Socket socket = new Socket("127.0.0.1", 8000);) {
			
			// 서버에게 데이터를 보내기
			OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			
			String str = new String("안녕하세요.");
			pw.println(new String(str.getBytes("ms949")));
			
			// 서버가 보내는 데이터 받기
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String message = br.readLine();
			System.out.println("서버가 보내온 메시지: " + message);
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		new ClientExam();
	}
}
