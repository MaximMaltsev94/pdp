package pdp.servlets;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

public class ChaosMonkeyFilter implements Filter {

    private Random random = new Random(System.currentTimeMillis());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String chaosMonkey = req.getParameter("chaosMonkey");
        if(chaosMonkey != null) {
            int i = random.nextInt(101);
            System.out.println("ChaosMonkeyFilter: generated - " + i);
            if(i <= 30) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            } else if (i <= 60) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}
