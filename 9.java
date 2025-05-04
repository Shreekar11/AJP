package com.todo; // here add you package name;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.http.HttpSession;

public class ToDoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String task = request.getParameter("task");
        HttpSession session = request.getSession();
        List<String> tasks = (List<String>) session.getAttribute("tasks");

        if (tasks == null) {
            tasks = new ArrayList<>();
            session.setAttribute("tasks", tasks);
        }

        if (task != null && !task.trim().isEmpty()) {
            tasks.add(task);
        }

        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String taskToDelete = request.getParameter("task");
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        List<String> tasks = (List<String>) session.getAttribute("tasks");
        if("delete".equals(action) && tasks != null) {
            tasks.remove(taskToDelete);
        }
        response.sendRedirect("index.jsp");
    }
}

// web.xml

<?xml version="1.0" encoding="UTF-8"?>
<web-app id="WebApp_ID" version="2.4"
         xmlns="http://java.sun.com/xml/ns/j2ee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee
                             http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd">

    <display-name>JSP_ToDoList</display-name>

    <servlet>
        <servlet-name>ToDoServlet</servlet-name>
        <servlet-class>com.todo.ToDoServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>ToDoServlet</servlet-name>
        <url-pattern>/ToDoServlet</url-pattern>
    </servlet-mapping>

    <welcome-file-list>
        <welcome-file>index.html</welcome-file>
        <welcome-file>index.htm</welcome-file>
        <welcome-file>index.jsp</welcome-file>
        <welcome-file>default.html</welcome-file>
        <welcome-file>default.htm</welcome-file>
        <welcome-file>default.jsp</welcome-file>
    </welcome-file-list>

</web-app>
