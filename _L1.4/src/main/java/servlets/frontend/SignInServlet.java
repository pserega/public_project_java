package servlets.frontend;

import base.AccountService;
import base.IAccountService;
import base.UserProfile;
import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author v.chibrikov
 */
public class SignInServlet extends HttpServlet {
    private IAccountService accountService;
    private static final String signin = "/auth/signin";
    static final Logger logger = LogManager.getLogger(SignInServlet.class.getName());

    public static String getSignin() {
        return signin;
    }
    

    public SignInServlet(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        
        //http://url:port/auth/signin?name=test&password=test
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        response.setStatus(HttpServletResponse.SC_OK);

        //The Map variables for page template - authstatus.html
        Map<String, Object> pageVariables = new HashMap<>();
        
        UserProfile profile = accountService.getUser(name);
        if (profile != null && profile.getPassword().equals(password)) {
            pageVariables.put("loginStatus", "Login passed");
        } else {
            pageVariables.put("loginStatus", "Wrong login/password");
        }

        logger.info("Signin name: " +name + " password: " +password + " " +pageVariables.get("loginStatus"));
        
        response.getWriter().println(PageGenerator.getPage("authstatus.html", pageVariables));
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        response.setStatus(HttpServletResponse.SC_OK);

        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("email", email == null ? "" : email);
        pageVariables.put("password", password == null ? "" : password);

        response.getWriter().println(PageGenerator.getPage("authresponse.txt", pageVariables));
    }
}
