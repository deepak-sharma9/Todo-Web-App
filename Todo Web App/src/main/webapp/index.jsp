<%@ page import="com.storage.todo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dao.todoDao" %>
<%@ page import="com.db.jdbc_connection" %>
<html>
<head>
    <%@include file="component/css.jsp"%>

</head>


<body  class="d-flex flex-column min-vh-100">
<%@include file="component/navbar.jsp"%>
<main class="flex-grow-1">
<h1 class="text-center text-success">TODO-APP</h1>

<%
    String successMessage=(String) session.getAttribute("success");
    if(successMessage!=null){
%>
<div class="alert alert-success" role="alert"> <%= successMessage%> </div>
<%
        session.removeAttribute("success");
    }
    %>

<%
    String failedMessage=(String) session.getAttribute("failed");
    if(failedMessage!=null){
%>
<div class="alert alert-success" role="alert"> <%= successMessage%> </div>
<%
        session.removeAttribute("failed");
    }
%>



<div class="container ">
    <table class="table table-striped " border="1px">
        <thead class="bg-success text-white ">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Todo</th>
            <th scope="col">Status</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <%

            todoDao dao=new todoDao(jdbc_connection.getConnection());
            List<todo> todoList=dao.getAllTodos();

//            List<todo> todoList = (List<todo>) session.getAttribute("todoList");
            if (todoList != null) {
                for (todo Todo : todoList) {
        %>
        <tr>
            <td><%= Todo.getId() %></td>
            <td><%= Todo.getName() %></td>
            <td><%= Todo.getTodo() %></td>
            <td><%= Todo.getStatus() %></td>
            <td>
                <a href="edit.jsp?id=<%= Todo.getId() %>" class="btn btn-sm btn-success">Edit</a>
                <a href="delete?id=<%=Todo.getId()%>" class="btn btn-sm btn-danger">Delete</a>
            </td>
        </tr>
        <%
            }
        }
            else {
        %>
        <tr>
            <td colspan="4">No Todos Found</td>
        </tr>
        <%
            }
        %>

        </tbody>
    </table>

</div>
</main>

</body>
</html>
