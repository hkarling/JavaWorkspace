package kosta.controller;

import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ModelAndView mav = new ModelAndView("elecView/read.jsp");

        String modelNum = req.getParameter("modelNum");
        String modelName = req.getParameter("model_name");
        String price = req.getParameter("price");
        String description = req.getParameter("description");
        String password = req.getParameter("password");

        try {
            ElectronicsService.update(new Electronics(modelNum, modelName,Integer.parseInt(price), description, password));
            Electronics electronics = ElectronicsService.selectByModelNum(modelNum, false);
            req.setAttribute("elec", electronics);
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("errorMsg", e.getMessage());
            mav.setPath("errorView/error.jsp");
        }
        return mav;
    }
}
