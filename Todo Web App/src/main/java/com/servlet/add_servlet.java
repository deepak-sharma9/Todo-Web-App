package com.servlet;

import com.dao.todoDao;
import com.db.jdbc_connection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/add")
public class add_servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html");

        String name=request.getParameter("name");
        String todo=request.getParameter("todo");
        String status=request.getParameter("status");

            todoDao dao=new todoDao(jdbc_connection.getConnection());
            HttpSession session =request.getSession();

            if(dao.addTodo(name,todo,status)){
                session.setAttribute("success","Data added successfully");
                response.sendRedirect("index.jsp");
            }else{
                session.setAttribute("failed","Error!! No data added");
                response.sendRedirect("index.jsp");
            }





    }

}
