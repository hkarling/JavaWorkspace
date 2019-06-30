package project.servlet;

import project.dto.BoardDTO;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(urlPatterns = "/board", loadOnStartup = 1)
public class BoardServlet extends HttpServlet {

    List<BoardDTO> boardDTOList = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd a hh:mm:ss", Locale.KOREAN);

    @Override
    public void init(ServletConfig config) throws ServletException {

        System.out.println("BoardServlet.config 호출..");

        ServletContext application = config.getServletContext();

        boardDTOList.add(new BoardDTO("user1", "context1", "2019.06.10 오후 08:10:11"));
        boardDTOList.add(new BoardDTO("user2", "context2", "2019.06.11 오후 09:11:31"));
        boardDTOList.add(new BoardDTO("user3", "context3", "2019.06.12 오후 10:10:11"));

        application.setAttribute("boardList", boardDTOList);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BoardServlet.doPost 호출");

        HttpSession session = req.getSession();
        String userId = (String)session.getAttribute("userId");

        boardDTOList.add(new BoardDTO(userId, req.getParameter("txtComment"), sdf.format(new Date())));
        resp.sendRedirect("index.jsp");
    }
}
