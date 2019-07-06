package ex0523.iostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileCopyExam {

	/**
	 * 생성자
	 */
	public FileCopyExam() {
		String readFile = JOptionPane.showInputDialog("읽을 파일이름은?");
		String writeFile = JOptionPane.showInputDialog("저장 파일이름은?");
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		long start = System.nanoTime();
		
		try {
			fis = new FileInputStream(readFile);
			fos = new FileOutputStream(writeFile);
			
			byte[] content = new byte[fis.available()];
			
			fis.read(content);
			
			fos.write(content);
			
					
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		long end = System.nanoTime();

		System.out.println("총 걸리시간 : " + (end - start) + "ns");

		System.out.println("복사되었슴다.");

	}

	/**
	 * 메인메소드
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		new FileCopyExam();
}

}
