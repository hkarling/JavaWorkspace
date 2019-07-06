package ex0523.iostream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderWriterExam {

	public ReaderWriterExam() {

		FileReader fr = null;
		BufferedReader br = null;

		/** 바로 문자단위로 파일 읽기 */
		BufferedWriter bw = null;
		
		try {
			/** 문자단위 파일 읽기 */
			fr = new FileReader("src/ex0523/iostream/read.txt");
//			int i = 0;
//			while ((i = fr.read()) != -1) {
//				System.out.println(i + " = " + (char) i);
//			}
			br = new BufferedReader(fr);

			/** Buffered를 이용하여 읽기 */
			String str = null;
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
			
			/** Buffered를 이용하여 쓰기 */
			bw = new BufferedWriter(new FileWriter("src/ex0523/iostream/write.txt"));
			bw.write("졸지말아라.");
			bw.newLine();
			bw.write("안녕!!\n");
			bw.write("따란....");
			bw.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				br.close();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new ReaderWriterExam();
	}
}
