package ex0705.ajax.servlet;

import common.CustomerDAO;
import common.CustomerDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/idCheck")
public class IdCheckServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String id = request.getParameter("id");

        CustomerDAO dao = new CustomerDAOImpl();
        boolean result = dao.idCheck(id);
        if(result) {
            PrintWriter out = response.getWriter();
            out.println("중복아이디입니다.");
        }
    }
}
