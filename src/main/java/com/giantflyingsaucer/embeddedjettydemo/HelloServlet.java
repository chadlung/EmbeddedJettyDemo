package com.giantflyingsaucer.embeddedjettydemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HelloServlet extends HttpServlet {

    String greeting = "Hello Servlet";

    public HelloServlet() {
    }

    public HelloServlet(String hi) {
        greeting = hi;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>" + greeting + " (HelloServlet)</h1>");
        response.getWriter().println("session=" + request.getSession(true).getId());
    }
}