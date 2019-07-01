package ex0701.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        // 넘어오는 아이디 받기

        // dao 에 삭제 호출..

        // 결과가 성공이면 index 로 이동 redirect

        // 실패이면 오류 메시지 출력 후 뒤로 이동. forward
    }
}
