package ex0701.servlet;

import ex0701.dao.MemberDAO;
import ex0701.dao.MemberDAOImpl;

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

        //memberDAO.selectById(id);

        // 저장

        // 이동 - read.jsp


    }
}
