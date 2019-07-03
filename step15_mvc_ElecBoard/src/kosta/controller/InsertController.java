package kosta.controller;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class InsertController implements Controller {

    ElectronicsService service = new ElectronicsService();

    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ModelAndView mav = new ModelAndView("/errorView/error.jsp");

        ServletContext application = req.getServletContext();
        String saveDir = application.getRealPath("/save");
        int maxSize = 1024*1024*100; // 100mb
        String encoding = "UTF-8";

        MultipartRequest mr = new MultipartRequest(req,saveDir, maxSize, encoding, new DefaultFileRenamePolicy());

        String modelNum = mr.getParameter("model_num");
        String modelName = mr.getParameter("model_name");
        String price = mr.getParameter("price");
        String description = mr.getParameter("description");
        String password = mr.getParameter("password");

        Electronics electronics = new Electronics(modelNum, modelName, Integer.parseInt(price), description, password);

        // 만약 파일첨부가 되었다면 파일이름과 파일크기를 저장
        if(mr.getFilesystemName("file") != null) {
            // 파일이름
            electronics.setFname(mr.getFilesystemName("file"));
            // 파일 크기
            electronics.setFsize((int)mr.getFile("file").length());
        }

        try {
            service.insert(electronics);
            mav.setPath("elec");
            mav.setRedirect(true);
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("errMessage", e.getMessage());
        }
        return mav;
    }
}
