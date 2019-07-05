package ex0705.ajax.servlet;

import common.CustomerDAO;
import common.CustomerDAOImpl;
import common.CustomerDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String tel = request.getParameter("tel");
        String addr = request.getParameter("addr");

//        System.out.println(id + name+ age+ phone+ addr);

        CustomerDAO dao = new CustomerDAOImpl();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            int result = dao.insert(new CustomerDTO(id, name, Integer.parseInt(age), tel, addr));
            out.println(result);
        } catch (NumberFormatException e) {

        }
    }
}
