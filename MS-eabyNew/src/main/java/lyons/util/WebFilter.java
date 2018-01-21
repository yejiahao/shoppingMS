package lyons.util;

import javax.servlet.*;
import java.io.IOException;

/**
 * 页面编码格式过滤器
 */
@SuppressWarnings("serial")
public class WebFilter implements Filter {
    private FilterConfig config;

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String encoding = config.getInitParameter("encoding");
        request.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
