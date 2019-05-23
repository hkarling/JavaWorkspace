package iostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputExam {
	/**
	 * 생성자아
	 */
	public FileInputOutputExam() {

		FileInputStream fis = null; /** 파일을 byte단위로 읽기 */
		FileOutputStream fos = null;/** 파일을 byte단위로 쓰기 */

		try {

			///////////////////////////////////////////////////////////
			/** byte 단위로 파일을 읽기 */
			fis = new FileInputStream("src/iostream/read.txt");

//			while (true) {
//				int i = fis.read();
//				if (i == -1)
//					break;
//				System.out.println(i + " = " + (char) i);
//			}

//			int i = 0;
//			while ((i = fis.read()) != -1) {
//				System.out.println(i + " = " + (char) i);
//			}

			int len = fis.available();
			System.out.println("len = " + len);
			byte b[] = new byte[len];
			fis.read(b); // byte배열의 크기만큼 읽어서 배열에 저장
			System.out.println(new String(b));
			
			///////////////////////////////////////////////////////////
			/** 파일에 저장하기 */
			fos = new FileOutputStream("src/iostream/write.txt", true);

//			fos.write(65);
//			fos.write(66);
//			fos.write(32);
//			fos.write(106);
//			fos.write(13);
//			fos.write(10);
//			fos.write(70);

			String str = "배고프다. 쉬고싶다. breaktime for 10min plz. ";
			fos.write(str.getBytes());

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {
			try {
				/** fis를 닫는다 */
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 메인메소드
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new FileInputOutputExam();
	}

}
