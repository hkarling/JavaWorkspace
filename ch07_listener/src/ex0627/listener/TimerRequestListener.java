package ex0627.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener()
public class TimerRequestListener implements ServletRequestListener {

    long start, end;

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("TimerRequestListener 의 requestInitialized 호출..");

        start = System.nanoTime();
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("TimerRequestListener 의 requestDestroyed 호출..");

        end = System.nanoTime();
        String url = ((HttpServletRequest)sre.getServletRequest()).getRequestURL().toString();
        System.out.println(url + "이 총 걸린시간: " + (end-start) + "ns");
    }
}
