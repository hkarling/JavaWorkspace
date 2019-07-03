package project.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SelectController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("SelectController calls..");

        // 검색에 해당하는 service -> dao 호출 그 결과를 어딘가 저장.

        req.setAttribute("message", "검색된 결과입니다.");

        return new ModelAndView("selectResult.jsp");
    }
}
