package dai_phan.practice.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "CharsetFilter", value = "/*")
public class CharsetFilter implements Filter {


    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        // Respect the client-specified character encoding
        // (see HTTP specification section 3.4.1)
        //if (null == request.getCharacterEncoding()) {
            request.setCharacterEncoding("UTF-8");
       // }
        // Set the default response content type and encoding
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }
}
