package project.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class VisitCountListener implements ServletContextListener, HttpSessionListener {

    ServletContext application;

    public void contextInitialized(ServletContextEvent sce) {

        // 어필리케이션이 초기화 될때 카운터들을 저장할 공간을 담아둠.
        application = sce.getServletContext();
        application.setAttribute("totalVisit", new AtomicInteger(0));
        application.setAttribute("currentVisit", new AtomicInteger(0));

    }

    public void sessionCreated(HttpSessionEvent se) {

        // 세션이 생성될때의 이벤트

        System.out.println("SessionCreated");
        AtomicInteger total = (AtomicInteger) application.getAttribute("totalVisit");
        AtomicInteger current = (AtomicInteger) application.getAttribute("currentVisit");

        total.incrementAndGet();
        current.incrementAndGet();
    }

    public void sessionDestroyed(HttpSessionEvent se) {

        // 세션이 종료될 대의 이벤트

        System.out.println("SessionDestroyed");
        AtomicInteger current = (AtomicInteger) application.getAttribute("currentVisit");
        current.decrementAndGet();
    }
}
