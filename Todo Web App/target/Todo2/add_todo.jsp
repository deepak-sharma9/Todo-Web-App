<%--
  Created by IntelliJ IDEA.
  User: deepak sharma
  Date: 05-12-2024
  Time: 10:13 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="component/css.jsp"%>
</head>

<body style="background-color: #f0f1f2; ">
<%@include file="component/navbar.jsp"%>

<div class="container">
    <div class="row p-5">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-body>">
                    <h3 class="text-center text-success">Add Todo</h3>
                    <form action="add" method="post">

                        <div class="form-group mx-3">
                            <label for="name" >Name</label>
                            <input type="text" class="form-control" id="name" aria-describedby="emailHelp" name="name">
                        </div>

                        <div class="form-group mx-3">
                            <label for="task" >TODO</label>
                            <input type="text" class="form-control" id="task" aria-describedby="emailHelp" name="todo">
                        </div>

                        <div class="form-group mx-3">
                            <label for="Select" >Status</label>
                            <select id="Select" class="form-control" name="status">
                                <option selected>--select--</option>
                                <option value="pending">Pending</option>
                                <option value="complete">Complete</option>
                            </select>
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">ADD</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
