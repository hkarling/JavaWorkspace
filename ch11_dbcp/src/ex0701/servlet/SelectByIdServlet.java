package ex0701.servlet;

import ex0701.dao.MemberDAO;
import ex0701.dao.MemberDAOImpl;
import ex0701.dto.MemberDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectById")
public class SelectByIdServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MemberDAO memberDAO = new MemberDAOImpl();
        MemberDTO member = memberDAO.selectById(req.getParameter("id"));

        // 저장
        req.setAttribute("member", member);

        // 이동 - read.jsp
        req.getRequestDispatcher("read.jsp").forward(req, resp);
    }
}
