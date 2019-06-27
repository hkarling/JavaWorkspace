package ex0627.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * web.xml문서에 
 * <servlet>
 * 		<servlet-mapping>
 * 			<url-pattern>/test2</url-pattern>
 * 		</servlet-mapping>
 * </servlet>
 */
@WebServlet("/test2")
public class ContextParamTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String message;
	String addr;
	String dbId;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		// content-param 가져오기
		ServletContext application = config.getServletContext();
		message = application.getInitParameter("message");
		addr = application.getInitParameter("addr");
		dbId = application.getInitParameter("dbId");
	
		System.out.println("ContextParamTestServlet의 service()가 호출됨...");
		System.out.println("message : " + message);
		System.out.println("addr : " + addr);
		System.out.println("dbId : " + dbId);
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println(111);
		System.out.println("ContextParamTestServlet의 service()가 호출됨...");
		System.out.println("message : " + message);
		System.out.println("addr : " + addr);
		System.out.println("dbId : " + dbId);
	}
}
