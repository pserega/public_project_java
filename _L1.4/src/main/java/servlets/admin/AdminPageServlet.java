package servlets.admin;
import base.TimeHelper;
import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class AdminPageServlet extends HttpServlet {
    
    private static final String adminPageUrl = "/admin";
    private static final Logger logger = Logger.getLogger(AdminPageServlet.class.getName());

    public static String getAdminPageUrl() {
        return adminPageUrl;
    }
    
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        Map<String, Object> pageVariables = new HashMap<>();
        String timeString = request.getParameter("shutdown");
        if (timeString != null) {
            int timeMS = Integer.valueOf(timeString);
            logger.info("Server will be down after: "+ String.valueOf(timeMS) + " ms");
            TimeHelper.sleep(timeMS);
            logger.info("\nShutdown");
            System.exit(0);
        }
        pageVariables.put("status", "run");
        response.getWriter().println(PageGenerator.getPage("admin.tml", pageVariables));
    }
}
