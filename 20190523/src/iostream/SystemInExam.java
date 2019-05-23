package iostream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SystemInExam {

	public SystemInExam() {

		
		try {
			
			/** byte단위 읽어오기 */
//			InputStream is = System.in;
//			int i = is.read();
//			System.out.println(i + " = " + (char)i);

			/** 문자단위 읽어오기 */
//			InputStreamReader irs = new InputStreamReader(System.in);
//			int i = irs.read();
//			System.out.println(i + " = " + (char)i);
			
			/** 한 줄 단위 읽어오기 */
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			System.out.println(str);
		
			Scanner sc = new Scanner(System.in);
			
		} catch (IOException e) {
			e.printStackTrace();
		
		} finally {
//			try {
//				irs.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}

	}

	public static void main(String[] args) {

		new SystemInExam();
	}

}
