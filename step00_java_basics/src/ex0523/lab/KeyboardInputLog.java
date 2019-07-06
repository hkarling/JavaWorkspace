package ex0523.lab;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardInputLog {

	/**
	 * 생성자
	 */
	public KeyboardInputLog() {
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new FileWriter("src/lab/log.txt"));
			
			String str = null;
			
			while(true) {
				System.out.print("입력: ");
				str = br.readLine();
				
				if(str.equals("exit")) {
					System.out.println("끄읕~~!!");
					break;	
				}
				System.out.println(str);
				bw.write(str);
				bw.newLine();
			}
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 메인메소드 
	 * @param args
	 */
	public static void main(String[] args) {
		new KeyboardInputLog();
	}

}
