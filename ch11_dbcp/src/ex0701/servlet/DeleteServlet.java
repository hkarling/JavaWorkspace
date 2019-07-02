package ex0701.servlet;

import ex0701.dao.MemberDAO;
import ex0701.dao.MemberDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        // 넘어오는 아이디 받기
        String id = req.getParameter("id");

        // dao 에 삭제 호출..
        MemberDAO memberDAO = new MemberDAOImpl();
        int result = memberDAO.delete(id);
        if(result > 0){
            // 결과가 성공이면 index 로 이동 redirect
            resp.sendRedirect("index.jsp");
        } else {
            // 실패이면 오류 메시지 출력 후 뒤로 이동.
            PrintWriter out = resp.getWriter();
            out.println("<script>");
            out.println("alert('아이디가 없습니다.');");
            out.println("history.back();");
            out.println("<script>");
        }
    }
}
