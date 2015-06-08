import accountServer.AccountServer;
import accountServer.AccountServerI;
import base.AccountService;
import servlets.admin.AdminPageServlet;
import servlets.frontend.SignInServlet;
import servlets.frontend.SignUpServlet;
import servlets.home.HomePageServlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Run {
    
    static final Logger logger = LogManager.getLogger(Run.class.getName());
    static final String RESOURCE = "static";

    public static void main(String[] args) throws Exception {
        
        if (args.length != 1) {
            logger.error("Use port as the first argument");
            System.exit(1);
        }
        
        int port = Integer.valueOf(args[0]);
        
        //Object JVM Beans (jconsol)
        AccountServerI accountServer = new AccountServer(1);
        accountServer.registerMBean();
        logger.info("Object JVM Beans (jconsol,visualVM) at port: 84");

  
        //init Jetty Server
        Server server = new Server(port);
        logger.info(new StringBuffer("Starting at port: ").append(String.valueOf(port)).append('\n'));

        //context Servlet
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new HomePageServlet(accountServer)), HomePageServlet.getHomePageUrl());
        context.addServlet(new ServletHolder(new AdminPageServlet()), AdminPageServlet.getAdminPageUrl());
        
        AccountService accountServiceLogin = new AccountService();
        context.addServlet(new ServletHolder(new SignInServlet(accountServiceLogin)), SignInServlet.getSignin());
        context.addServlet(new ServletHolder(new SignUpServlet(accountServiceLogin)), SignUpServlet.getSignup());

        //http static url
        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setDirectoriesListed(true);
        resource_handler.setResourceBase(RESOURCE);
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});
        server.setHandler(handlers);

        server.start();
        logger.info("Server started ... ");
        
        server.join();
    }
}
