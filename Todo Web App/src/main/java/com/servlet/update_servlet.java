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
import java.sql.SQLException;

@WebServlet("/edit")
public class update_servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws  ServletException, IOException{
        response.setContentType("text/html");

        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String todo=request.getParameter("todo");
        String status=request.getParameter("status");


        try {
            HttpSession session =request.getSession();
            todo Todo=new todo(id,name,todo,status);
            todoDao dao=new todoDao(jdbc_connection.getConnection());
            boolean t=dao.updateTodo(Todo);

            if(t){
                session.setAttribute("success","Data Updated successfully");
                response.sendRedirect("index.jsp");
            }else{
                session.setAttribute("failed","Error!! Update failed");
                response.sendRedirect("index.jsp");
            }


        }catch (SQLException e){
            e.printStackTrace();
        }


    }

}
