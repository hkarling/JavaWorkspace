package ex0701.servlet;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/UpLoad")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String name = request.getParameter("name");
//        String subject = request.getParameter("subject");
//        String file = request.getParameter("file");

//        System.out.println("name : " + name);
//        System.out.println("name : " + subject);
//        System.out.println("name : " + file);

        /* 폼에서 enctype="multipart/form-data" 설정된 경우 업로드 전용 클래스를 사용해야 한다. */

        ServletContext application = request.getServletContext();

        String saveDir = application.getRealPath("/save");
        int maxSize = 1024 * 1024 * 100;
        String encoding = "UTF-8";

        MultipartRequest mr = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());

        String name = mr.getParameter("name");
        String subject = mr.getParameter("subject");
        String fileName = mr.getFilesystemName("file");
        String originalName = mr.getOriginalFileName("file");

        System.out.println("name : " + name);
        System.out.println("name : " + subject);
        System.out.println("fileName : " + fileName);
        System.out.println("originalFileName : " + originalName);

        // file 용량 구하기
        long fileSize = mr.getFile("file").length();

        // 다운로드를 위해 save 폴더의 모든 파일이름 가져오기
        String[] fileList = new File(saveDir).list();


        // view 쪽으로 전달될 데이터를 준비
        /*
        request.setAttribute("name", name);
        request.setAttribute("subject", subject);
        request.setAttribute("fileName", fileName);
        request.setAttribute("originalName", originalName);
        request.setAttribute("fileSize", fileSize);
        request.setAttribute("fileList", fileList);

        request.getRequestDispatcher("uploadResult.jsp").forward(request,response);
        */

        // view 쪽에 전달할 데이터 멥에 저장하기
        Map<String, Object> map = new HashMap<>();

        map.put("name", name);
        map.put("subject", subject);
        map.put("fileName", fileName);
        map.put("originalName", originalName);
        map.put("fileSize", fileSize);
        map.put("fileList", fileList);

        request.setAttribute("map", map);
        request.getRequestDispatcher("uploadResultMap.jsp").forward(request,response);
    }
}
