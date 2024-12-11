package com.servlet;

import com.dao.todoDao;
import com.db.jdbc_connection;
import com.storage.todo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class search_servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search");
        todoDao dao = new todoDao(jdbc_connection.getConnection());

        try {
            List<todo> filteredTodos = dao.searchByName(name); // Get filtered todos

            request.setAttribute("todoList", filteredTodos); // Pass data to JSP
            if (!filteredTodos.isEmpty()) {
                request.setAttribute("success", "Data Found");
            } else {
                request.setAttribute("failed", "No data Found!!");
            }

            request.getRequestDispatcher("searchPage.jsp").forward(request, response); // Forward to JSP
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
