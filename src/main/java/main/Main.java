package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AllRequestsServlet;
import servlets.MirrorReqestServlet;

import java.util.logging.Logger;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class Main {
    public static void main(String[] args) throws Exception {
        AllRequestsServlet allRequestsServlet = new AllRequestsServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(allRequestsServlet), "/*");

        MirrorReqestServlet mirrorReqestServlet = new MirrorReqestServlet();
        context.addServlet(new ServletHolder(mirrorReqestServlet), "/mirror");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();

        Logger.getGlobal().info("Server started");

        server.join();


    }
}
