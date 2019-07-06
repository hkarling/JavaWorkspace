package ex0523.iostream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

public class BufferedFileCopyExam {
	public BufferedFileCopyExam() {
		
		String readFile = JOptionPane.showInputDialog("읽을 파일이름은?");

		String writeFile = JOptionPane.showInputDialog("저장 파일이름은?");

		// byte단위로로 읽기/ 쓰기 - Buffered이용(속도향상을위해서)
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		long start = System.nanoTime();

		try {
			bis = new BufferedInputStream(new FileInputStream(readFile));
			bos = new BufferedOutputStream(new FileOutputStream(writeFile));

			int i = 0;
			while ((i = bis.read()) != -1) {
				bos.write(i);
			}
			System.out.println("복사되었습니다...^^");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
				bos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		long end = System.nanoTime();

		System.out.println("총 걸리시간 : " + (end - start) + "ns");

	}

	public static void main(String[] args) {
		new BufferedFileCopyExam();

	}

}