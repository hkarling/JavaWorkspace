package ex0701.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 넘어오는 모든 값들 받아서 dto에 저장한다.

        // id에 해당하는 중복 체크 한다.
            // 있으면 - 뒤로가기
            // 없으면 - insert 호출
            // selectAll로 이동 : response.sendRedirect("selectAll");
    }
}
