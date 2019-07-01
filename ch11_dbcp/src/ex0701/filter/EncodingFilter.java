package ex0701.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class EncodingFilter extends HttpFilter {

    String encoding = "UTF-8";

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        // 한글 인코딩
        req.setCharacterEncoding(encoding);
        chain.doFilter(req, resp);
    }
}
