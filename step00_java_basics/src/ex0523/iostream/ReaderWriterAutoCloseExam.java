package iostream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderWriterAutoCloseExam {

	public ReaderWriterAutoCloseExam() {

		/** 바로 문자단위로 파일 읽기 */
		
		try(BufferedReader br = new BufferedReader(new FileReader("src/iostream/read.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("src/iostream/write.txt"));) {

			/** Buffered를 이용하여 읽기 */
			String str = null;
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
			
			/** Buffered를 이용하여 쓰기 */
			bw.write("졸지말아라.");
			bw.newLine();
			bw.write("안녕!!\n");
			bw.write("따란....");
			bw.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ReaderWriterAutoCloseExam();
	}
}
