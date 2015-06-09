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

/**
 * Created by v.chibrikov on 13.09.2014.
 */
public class SignUpServlet extends HttpServlet {
    private IAccountService accountService;
    private static final String signup = "/auth/signup";

    public static String getSignup() {
        return signup;
    }
    
    public SignUpServlet(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        Map<String, Object> pageVariables = new HashMap<>();
        if (accountService.addUser(name, new UserProfile(name, password, ""))) {
            pageVariables.put("signUpStatus", "New user created");
        } else {
            pageVariables.put("signUpStatus", "User with name: " + name + " already exists");
        }

        response.getWriter().println(PageGenerator.getPage("signupstatus.html", pageVariables));
        response.setStatus(HttpServletResponse.SC_OK);
    }

}
