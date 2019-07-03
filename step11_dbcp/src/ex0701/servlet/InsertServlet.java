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
import java.io.PrintWriter;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MemberDAO memberDAO = new MemberDAOImpl();

        // 넘어오는 모든 값들 받아서 dto에 저장한다.

        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String phone = req.getParameter("phone");
        String addr = req.getParameter("addr");

        MemberDTO memberDTO = new MemberDTO(id,pwd,name,Integer.parseInt(age),phone,addr, "");

        // 유효성 체크

        // id에 해당하는 중복 체크 한다.
        // 있으면 - 뒤로가기
        // 없으면 - insert 호출
        // selectAll로 이동 : response.sendRedirect("selectAll");
        if(memberDAO.idCheck(id)){
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.println("<script>");
            out.println("alert('id duplicated')");
            out.println("history.back();");
            out.println("</script>");
        } else {
            memberDAO.insert(memberDTO);
            resp.sendRedirect("selectAll");
        }

    }
}
