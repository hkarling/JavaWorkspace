package ex0627.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
import java.util.Map;

/**
 * XxxListener 구현 클래스
 *  1) XxxListener를 implement하고 모든 메소드 재정의
 *  2) listener를 등록
 *  	- web.xml
 *  	- @annotation
 */
public class AppListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("AppListener의 contextInitialized()호출됨..");

		/* 사용할 각 나라의 이름과 국가코드를 map에 저장하고 web Application 영역에서 사용할 수 있도록 ServletContext에 저장한다. */
		Map<String, String> map = new HashMap<>();
		map.put("kr", "대한민국");
		map.put("us", "미쿡");
		map.put("jp", "일본");
		map.put("fr", "프랑스");
		map.put("cn", "중국");
		map.put("uk", "영국");

		ServletContext application = sce.getServletContext();
		application.setAttribute("map", map);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("AppListener의 contextDestroyed()호출됨..");
	}
}
