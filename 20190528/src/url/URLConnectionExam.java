package url;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class URLConnectionExam {

	public URLConnectionExam() {
		try {
//			URL url = new URL("https://www.daum.net/");
			URL url = new URL("http://192.168.0.128/Edu/Book1.xlsx");
			BufferedInputStream bis = new BufferedInputStream(url.openStream());
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/url/book1.xlsx"));
			
//			byte b[] = new byte[bis.available()];
//			bis.read(b);
//			bos.write(b);
//			System.out.println(new String(b));
			
			int i = 0;
			while((i= bis.read()) != -1) {
				bos.write(i);
			}
			
			bis.close();
			bos.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new URLConnectionExam();
	}
}
