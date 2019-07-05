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

import net.sf.json.JSONArray;

/**
 * Servlet implementation class SuggestServlet
 */
@WebServlet("/SuggestJsonLibServlet")
public class SuggestJsonLibServlet extends HttpServlet {
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
		
		//list를 json로 변환해서 보내기
		JSONArray jsonArr = JSONArray.fromObject(list);
		
		PrintWriter out = response.getWriter();
		out.println(jsonArr);
		
	}

}



