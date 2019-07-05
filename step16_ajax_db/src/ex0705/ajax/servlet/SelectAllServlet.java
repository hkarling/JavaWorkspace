package ex0705.ajax.servlet;

import common.CustomerDAO;
import common.CustomerDAOImpl;
import common.CustomerDTO;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/selectAll")
public class SelectAllServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDAO dao = new CustomerDAOImpl();

        List<CustomerDTO> list = dao.selectAll();

        // list 를 json 형태로 변환 -> ~.jar 필요
        JSONArray jsonArr = JSONArray.fromObject(list);

        response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
        out.println(jsonArr);
    }
}
