package com.servlet;

import com.dao.todoDao;
import com.db.jdbc_connection;
import com.storage.todo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/delete")
public class delete_servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

        int id=Integer.parseInt(request.getParameter("id"));
        todoDao dao=new todoDao(jdbc_connection.getConnection());
        boolean t=dao.deleteTodo(id);

        HttpSession session =request.getSession();

        if(t){
            session.setAttribute("success","Data Deleted Successfully");
            response.sendRedirect("index.jsp");
        }else{
            session.setAttribute("failed","Error!! No data Deleted");
            response.sendRedirect("index.jsp");
        }

    }

}
