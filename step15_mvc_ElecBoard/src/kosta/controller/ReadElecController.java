package kosta.controller;

import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ReadElecController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ModelAndView mav = new ModelAndView("elecView/read.jsp");
        String modelNum = req.getParameter("modelNum");

        try {
            Electronics electronics = ElectronicsService.selectByModelNum(modelNum, true);
            req.setAttribute("elec", electronics);
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("errorMsg", e.getMessage());
        }

        return mav;
    }
}
