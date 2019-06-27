package ex0627.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

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
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("AppListener의 contextDestroyed()호출됨..");
	}
}
