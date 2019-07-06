package ex0522.map;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

public class PropertiesExam {

	// key 와 value 형태로 저장 (Map구조) - 단, key와 value 모두 String
	Properties pro = new Properties();

	public PropertiesExam() {
		// 저장하기
		pro.setProperty("AAA", "가가가");
		pro.setProperty("BBB", "나나나");
		pro.setProperty("CCC", "다다다");

		// 꺼내기
		// Set<Object> keySet = pro.keySet();
		Set<String> keys = pro.stringPropertyNames();

		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = pro.getProperty(key);
			System.out.println(key + " = " + value);
		}
	}

	/**
	 * 외부 ~.properties파일을 로딩하는 방법 1. Java의 IO 2. ResourceBundle
	 */
	public void ioTest() {
		
		Properties pro = new Properties();
		
		try {
			pro.load(new FileInputStream("src/map/test.properties"));
			Set<String> keys = pro.stringPropertyNames();

			Iterator<String> it = keys.iterator();
			while (it.hasNext()) {
				String key = it.next();
				String value = pro.getProperty(key);
				System.out.println(key + " = " + value);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void resourceTest() {
		/** ResourceBundl은 확장자 ~.properties 파일을 읽는 전용객채. 따라서 파일명을 설정할때 확장자 생략
		 * 파일을 찾아오는 기준이 classes폴더를 기준으로 한다.*/
		ResourceBundle re =  ResourceBundle.getBundle("map/test");
		Iterator<String> keys = re.keySet().iterator();
		while(keys.hasNext()) {
			String key = keys.next();
			String value = re.getString(key);
			System.out.println(key + " = " + value);
		}
		
	}

	public static void main(String[] args) {
		PropertiesExam pe = new PropertiesExam();
		System.out.println("\n1. test.properties 파일 IO 이용하기");
		pe.ioTest();
		System.out.println("\n2. ResourceBundle 클래스 이용하기");
		pe.resourceTest();
	}
}
