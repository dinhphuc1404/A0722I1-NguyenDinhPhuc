package com.example.quan_ly_user.config;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.LogRecord;

public class CharsetFilter implements Filter {
    private String encoding;
    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("requestEncoding");
        if (encoding == null) encoding = "UTF-8";
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Respect the client-specified character encoding
        // (see HTTP specification section 3.4.1)
        if (null == request.getCharacterEncoding()) {
            request.setCharacterEncoding(encoding);
        }

        // Set the default response content type and encoding
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}
