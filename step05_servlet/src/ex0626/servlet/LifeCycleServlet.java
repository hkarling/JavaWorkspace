package ex0626.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * - servlet을 만드는 방법
 *      1) HttpServlet 상속받는다
 *      2) 반드시 퍼블릭이어야한다.
 *      3) 필요한 메소드를 재정의한다. (init, service, doGet, doPost, destroy)
 *      4) 실행을 위해서는 반드시 서블릿을 등록한다.
 *          - web.xml 문서
 *          - @Annotation 등록
 */

public class LifeCycleServlet extends HttpServlet {

    public LifeCycleServlet() {

        System.out.println("LifeCycleServlet 생성자 호출됨...");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init() 호출됨...");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(111);
        System.out.println("service() 호출됨...");
        super.service(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet() 호출됨...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost() 호출됨...");
    }

    @Override
    public void destroy() {
        System.out.println("destroy() 호출됨...");
    }
}
