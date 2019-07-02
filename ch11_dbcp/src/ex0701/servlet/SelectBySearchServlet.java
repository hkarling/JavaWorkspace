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

@WebServlet("/selectBySearch")
public class SelectBySearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String keyword = req.getParameter("keyWord");
        String keyField = req.getParameter("keyField");

        if(keyword.equals("id") || keyword.equals("name") || keyword.equals("addr")) {

        }

        MemberDAO memberDAO = new MemberDAOImpl();
        List<MemberDTO> list = memberDAO.selectByKey(keyField, keyword);

        req.setAttribute("list", list);
        req.getRequestDispatcher("memberSelect.jsp").forward(req, resp);
    }
}
