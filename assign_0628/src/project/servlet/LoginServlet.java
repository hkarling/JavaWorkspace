package project.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    Map<String, String> accountMap = new HashMap<>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd a hh:mm:ss", Locale.KOREAN);

    @Override
    public void init(ServletConfig config) throws ServletException {

        // 테스트용 계정 정보들

        accountMap.put("user1", "1234");
        accountMap.put("user2", "2345");
        accountMap.put("user3", "3456");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("txtId");
        String userPwd = req.getParameter("txtPwd");

        if(accountMap.containsKey(userId) && accountMap.get(userId).equals(userPwd)) {

            HttpSession session = req.getSession();
            session.setAttribute("userId", userId);
            session.setAttribute("loginTime", sdf.format(new Date()));

            resp.sendRedirect("index.jsp");

        } else {
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.println("<script>");
            out.println("alert('로그인정보가 일치하지 않습니다.');");
            out.println("history.back();");
            out.println("</script>");
        }
    }
}
