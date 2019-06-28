package ex0628.filter;

import javax.servlet.*;
import java.io.IOException;

public class SimpleFilter implements javax.servlet.Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("SimpleFilter의 init 호출...");

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        // 사전처리
        System.out.println("SimpleFilter 의 사전처리입니다.");

        chain.doFilter(req, res );

        // 사후처리
        System.out.println("SimpleFilter 의 사후처리입니다.");
    }

    @Override
    public void destroy() {
        System.out.println("SimpleFilter 의 destroy 호출...");
    }
}
