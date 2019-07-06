package ex0523.iostream;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.swing.JOptionPane;

public class FileExam {
	/**
	 * 생성자
	 * 
	 * @throws IOException 허허허허허....
	 */
	public FileExam() throws IOException {

		/** 사용자 입력을 받는 UI */
		String pathname = JOptionPane.showInputDialog("파일이름은?");

		File file = new File(pathname);

		if (file.exists()) { // 파일의 존재여부 확인
			if(file.isDirectory()) {	// 폴더인지?
				System.out.println("****** 폴더 정보 ******");
				String[] filenames = file.list();
				for(String names : filenames)
					System.out.println(names);
			} else {
				System.out.println("****** 파일 정보 ******");
				System.out.println("읽기가능 : " + file.canRead());
				System.out.println("쓰기가능 : " + file.canWrite());
				System.out.println("절대경로 : " + file.getAbsolutePath());
				System.out.println("파일이름 : " + file.getName());
				System.out.println("파일크기 : " + file.length());
				System.out.println("마지막수정일 : " + new Date(file.lastModified()).toLocaleString());
				
				file.delete();
			}
		} else {
			System.out.println(pathname + "이 없으므로 만들겠음.");

			/** 파일이나 폴더경로는 프로젝트 폴더를 기준으로 작성된다. */
//			file.mkdir();
			file.createNewFile();
		}
	}

	/**
	 * 메인메서드
	 * 
	 * @param args
	 * @throws IOException 허허허허허허허.........
	 */
	public static void main(String[] args) throws IOException {

		new FileExam();
	}

}
