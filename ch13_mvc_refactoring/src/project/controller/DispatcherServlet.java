package project.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/front")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String key = req.getParameter("command");

        Controller controller = null;

        // 검색, 수정, 등록
        if(key.equals("select")) {
            // 기능 --> 대신 해줄 인터페이스를 작성
            controller = new SelectController();
        } else if (key.equals("insert")) {
            // 기능
            controller = new InsertController();
        } else if(key.equals("update")){
            // 기능
            controller = new UpdateController();
        }

        ModelAndView modelAndView = controller.handleRequest(req,resp);

        if(modelAndView.isRedirect()) {
            resp.sendRedirect(modelAndView.getPath());
        } else {
            req.getRequestDispatcher(modelAndView.getPath()).forward(req, resp);
        }
    }
}
