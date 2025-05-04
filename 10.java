package com.calculator; // here add you package name

import jakarta.servlet.ServletException;
import jakarta.servlet.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

public class CalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");
        String operation = request.getParameter("operation");

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result = 0.0;

        switch (operation) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Division by zero is not allowed.");
                    return;
                }
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid operation.");
                return;
        }

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Result: " + result + "</h1>");
        out.println("<a href='index.html'>Go Back</a>");
        out.println("</body></html>");
    }
}

// web.xml

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                             http://xmlns.jcp.org/xml/ns/javaee/webapp_4_0.xsd"
         id="WebApp_ID" version="4.0">

    <display-name>CalculatorApp</display-name>

    <servlet>
        <servlet-name>CalculatorServlet</servlet-name>
        <servlet-class>com.calculator.CalculatorServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>CalculatorServlet</servlet-name>
        <url-pattern>/CalculatorServlet</url-pattern>
    </servlet-mapping>
</web-app>