package ex0627.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListenerTest implements HttpSessionListener {

    /**
     * session이 생성될때 호출(브라우저에서 최초로 호출될 때
     *  1) session.invalidate() 호출
     *  2) session-timeout 일때 호출
     *  3) 창의 x를 클릭했을때는 호출 안됨.
     */
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        System.out.println("SessionListenerTest 의 sessionCreated() 호출됨...");
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        System.out.println("SessionListenerTest 의 sessionDestroyed() 호출됨...");
    }
}
