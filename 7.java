// ClientSideServlet.java

package exp7;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientSideServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        String username = request.getParameter("username");
        Stirng password = request.getParameter("password");

        request.setAttribute("username", username);
        request.setAttribute("password", password);
        request.getRequestDispatcher("ServerSideServlet07").forward(request, response);
    }
}

// ServerSideServlet.java
package exp7;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServerSideServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getParameter("username");
        Stirng password = (String) request.getParameter("password");

        response.getWriter().println("Username: " + username);
        response.getWriter().println("Password: " + password);
    }
}

// web.xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                             http://xmlns.jcp.org/xml/ns/javaee/webapp_4_0.xsd"
         id="WebApp_ID" version="4.0">

    <display-name>Experiment7</display-name>

    <servlet>
        <servlet-name>ClientSideServlet07</servlet-name>
        <servlet-class>com.shreekar.ClientSideServlet07</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>ClientSideServlet07</servlet-name>
        <url-pattern>/ClientSideServlet07</url-pattern>
    </servlet-mapping>

    <servlet>
        <servlet-name>ServerSideServlet07</servlet-name>
        <servlet-class>com.shreekar.ServerSideServlet07</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>ServerSideServlet07</servlet-name>
        <url-pattern>/ServerSideServlet07</url-pattern>
    </servlet-mapping>

</web-app>
