package ex0704.ajax.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/PostGetAjax")
public class PostGetAjaxServlet extends HttpServlet {

    String[] imgNames = { "spring.jpg", "android.jpg", "jquery.jpg", "jsmasterbook.jpg"};

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String book = request.getParameter("book");

        String imgName = imgNames[Integer.parseInt(book)];

        PrintWriter out = response.getWriter();
        out.println(imgName);
        System.out.println(imgName);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("배고프다.");
    }
}
