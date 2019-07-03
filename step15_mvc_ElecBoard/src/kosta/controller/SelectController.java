package kosta.controller;

import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SelectController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Electronics> list = null;
        String url = "elecView/list.jsp";
        try {
            list = ElectronicsService.selectAll();
            req.setAttribute("list", list);

        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("errorMsg", e.getMessage());
            url = "errorView/error.jsp";
        }

        return new ModelAndView(url);
    }
}
