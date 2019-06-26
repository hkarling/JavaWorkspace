package assign02;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // characterset 설정
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 아이디와 패스워드 -_-
        String dbId = "jang", dbPwd = "1234";

        // 값 가져옴.
        String userid = request.getParameter("userId");
        String userpw = request.getParameter("userPwd");
        String name = request.getParameter("userName");


        PrintWriter out = response.getWriter();

        if (userid.equals(dbId) && userpw.equals(dbPwd)) {
            request.getRequestDispatcher("LoginOk.jsp").forward(request, response);
        } else {
            out.println("<script>");
            out.println("alert('" + name + "님 정보를 다시확인하시오.');");
            out.println("history.back();");
            out.println("</script>");
        }
    }
}
