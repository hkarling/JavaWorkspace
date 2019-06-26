package ex0626.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginCheckServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //브라우져에 출력되는 한글인코딩 처리 첫줄에 작성
        response.setContentType("text/html;charset=UTF-8");

        //브라우져에 출력하는 출력스트림을 구하기
        PrintWriter out =  response.getWriter();
        out.println("<html>");
        out.println("<head><title>연습...</title></head>");
        out.println("<body>");
        out.println("<h1>잘 되니?? - I can do!! </h1>");

        //post방식일때 한글인코딩설정
        request.setCharacterEncoding("UTF-8");

        //폼으로 전송된 데이터를 받기
        String userId =  request.getParameter("userId");
        String userPwd =  request.getParameter("userPwd");
        String userName =  request.getParameter("userName");

        out.println("아이디 : " + userId+"<br>");
        out.println("비번 : " + userPwd+"<br>");
        out.println("이름 : " + userName+"<br>");

        //session
        HttpSession session = request.getSession();

        //application
        ServletContext application = request.getServletContext();

        out.println("<script>");
        out.println("alert('이제 그만해~~')");
        out.println("</script>");

        out.println("</body>");
        out.println("</html>");
    }
}
