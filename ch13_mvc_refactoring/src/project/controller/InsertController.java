package project.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("InsertController calls..");

        // 등록에 해당하는 service -> dao 호출 그 결과를 어딘가 저장.

        return new ModelAndView("front?command=select", true);
    }
}
