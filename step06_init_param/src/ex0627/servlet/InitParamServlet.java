package ex0627.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InitParamServlet extends HttpServlet {

    String dbId;
    String pwd;
    String message;
    String addr;

    @Override
    public void init() throws ServletException {

        // init-param 의 정보 가져오기
        dbId = super.getInitParameter("dbId");
        pwd = super.getInitParameter("pwd");
        
		ServletContext application = super.getServletContext();
		message = application.getInitParameter("message");
		addr = application.getInitParameter("addr");

        System.out.println("InitParamServlet 의 init() 호출됨...");
		System.out.println("message : " + message);
		System.out.println("addr : " + addr);
		System.out.println("dbId : " + dbId);
		
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("InitParamServlet 의 service() 호출됨...");

        System.out.println("dbId = " + dbId);
        System.out.println("pwd = " + pwd);
		System.out.println("message : " + message);
		System.out.println("addr : " + addr);
    }
}
