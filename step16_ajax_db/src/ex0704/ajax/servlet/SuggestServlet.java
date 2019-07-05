package ex0704.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SuggestServlet
 */
@WebServlet("/SuggestServlet")
public class SuggestServlet extends HttpServlet {
	String words []= {
	   "Java Programming","Java 시작하기","java HTML",
	   "자바연습","자바를 잘하자","자습하자",
	   "Ajax 실습","ajax 연습중","Ajax 최고~~" ,"ABCD연습",
	   "Spring 하고싶다.","Spring이란?","spring연습","Spring은 봄?"
	};
	
	/**
	 * 배열에서 단어로 시작하는 단어를 찾아 리턴하는 메소드
	 * */
	private List<String> search(String keyWord){
		List<String> list = new ArrayList<String>();
		for(String word :words) {
			if(word.toUpperCase().startsWith(keyWord.toUpperCase())) {
				list.add(word);
			}
		}
		
		return list;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		request.setCharacterEncoding("UTF-8");
		String keyWord  = request.getParameter("keyWord");
		List<String> list = this.search(keyWord);
		
		//client에게 응답 할 데이터를 자바스크립트가
		//알수 있는 데이터 형식으로 변환!! - text
		// 개수|단어,단어,단어,....
		
		String data = list.size()+"|";
		for(int i=0; i< list.size() ; i++) {
			if(i== (list.size()-1)) {
				data+=list.get(i) ;
			}else {
				data+=list.get(i)+"," ;
			}
		}
		
		PrintWriter out = response.getWriter();
		out.println(data);
		
	}

}



