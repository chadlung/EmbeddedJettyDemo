package com.giantflyingsaucer.embeddedjettydemo;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


public class App
{
    public static void main( String[] args )
    {
        try {
            Server server = new Server(8080);

            ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context.setContextPath("/demo");
            context.addServlet(new ServletHolder(new HelloServlet()),"/*");
            context.addServlet(new ServletHolder(new HelloServlet("This is servlet 1")),"/1/*");
            context.addServlet(new ServletHolder(new HelloServlet2("This is servlet 2")),"/2/*");

            server.setHandler(context);
            server.setStopAtShutdown(true);
            server.start();
            server.join();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
