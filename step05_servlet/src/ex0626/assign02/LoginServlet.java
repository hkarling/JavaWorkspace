package ex0626.assign02;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    // 아이디와 패스워드 -_-
    String dbId = "jang", dbPwd = "1234";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // characterset 설정
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 값 가져옴.
        String userid = request.getParameter("userId");
        String userpw = request.getParameter("userPwd");
        String name = request.getParameter("userName");

        PrintWriter out = response.getWriter();

        if (userid.equals(dbId) && userpw.equals(dbPwd)) {

            HttpSession session = request.getSession();
            session.setAttribute("userId", userid);
            session.setAttribute("userPwd", userpw);
            session.setAttribute("userName", name);

            response.sendRedirect("assign02/LoginOk.jsp");

//            request.getRequestDispatcher("assign02/LoginOk.jsp").forward(request, response);
        } else {
            out.println("<script>");
            out.println("alert('" + name + "님 정보를 다시확인하시오.');");
            out.println("history.back();");
            out.println("</script>");
        }
    }
}
