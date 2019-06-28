package ex0627.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.concurrent.atomic.AtomicInteger;

public class UserCounterListener implements ServletContextListener, HttpSessionListener {

    ServletContext application;

    // Public constructor is required by servlet spec
    public UserCounterListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {

        // 모든 클라이언트가 공유할 counter 변수를 미리 준비한다.
        application = sce.getServletContext();
        application.setAttribute("counter", new AtomicInteger(0));
    }

    public void contextDestroyed(ServletContextEvent sce) { }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */

        // 저장된 counter 를 읽어서 증가시킨다.
        AtomicInteger at = (AtomicInteger) application.getAttribute("counter");
        int incrementCounter = at.getAndIncrement();

        System.out.println("현재 접속자수(증가됨): " +incrementCounter);

    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */

        // 저장된 counter 를 읽어서 증가시킨다.
        AtomicInteger at = (AtomicInteger) application.getAttribute("counter");
        int incrementCounter = at.decrementAndGet();

        System.out.println("현재 접속자수(감소됨): " + incrementCounter);
    }
}
