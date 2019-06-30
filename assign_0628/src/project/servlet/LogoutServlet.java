package project.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 로그아웃 세션 정보를 삭제하고 index.jsp로 보낸다.

        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        session.invalidate();
        resp.sendRedirect("index.jsp");
    }
}