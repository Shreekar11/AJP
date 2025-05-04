<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Simple To-Do List</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background: #f0f2f5;
            color: #333;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #34495e;
        }
        form {
            display: flex;
            justify-content: center;
            margin-bottom: 20px;
        }
        form input[type="text"] {
            width: 60%;
            padding: 10px;
            border: 2px solid #bdc3c7;
            border-radius: 4px 0 0 4px;
            font-size: 16px;
            outline: none;
        }
        form button {
            background: #2980b9;
            color: #fff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 0 4px 4px 0;
        }
        form button:hover {
            background: #3498db;
        }
        h2 {
            color: #2c3e50;
            text-align: center;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        ul li {
            background: #ecf0f1;
            margin: 5px 0;
            padding: 10px;
            border-radius: 4px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        ul li a {
            text-decoration: none;
            color: #e74c3c;
            font-weight: bold;
            transition: color 0.2s;
        }
        ul li a:hover {
            color: #c0392b;
        }
    </style>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h1>To-Do List</h1>
        <form action="ToDoServlet" method="post">
            <input type="text" name="task" required placeholder="Enter a new task">
            <button type="submit">Add Task</button>
        </form>

        <h2>Tasks:</h2>
        <ul>
            <%
                java.util.List<String> tasks = (java.util.List<String>) session.getAttribute("tasks");
                if (tasks != null) {
                    for (String task : tasks) {
            %>
                <li>
                    <span><%= task %></span>
                    <a href="ToDoServlet?task=<%= task %>&action=delete">Delete</a>
                </li>
            <%
                    }
                }
            %>
        </ul>
    </div>
</body>
</html>
