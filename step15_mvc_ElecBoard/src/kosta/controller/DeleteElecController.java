package kosta.controller;

import kosta.model.service.ElectronicsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteElecController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ModelAndView mav = new ModelAndView("elec", true);

        String modelNum = req.getParameter("modelNum");
        String password = req.getParameter("password");

        try {
            ElectronicsService.delete(modelNum,password);

        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("errorMsg", e.getMessage());
            mav.setPath("errorView/error.jsp");
        }
        return mav;
    }
}
