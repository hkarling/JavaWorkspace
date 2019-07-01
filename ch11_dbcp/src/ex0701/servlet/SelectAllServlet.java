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
import java.util.List;

@WebServlet("/selectAll")
public class SelectAllServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // service -> dao -> 그 결과를 받아서 결과 뷰로 이동
        MemberDAO memberDAO = new MemberDAOImpl();
        List<MemberDTO> list = memberDAO.selectAll();

        // 뷰쪽에 전달될 데이터를 scope영역에 저장.
        req.setAttribute("list", list);

        req.getRequestDispatcher("memberSelect.jsp").forward(req, resp);
    }
}
