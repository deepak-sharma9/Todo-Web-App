package com.dao;

import com.storage.todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class todoDao {

    private Connection connection;
    public todoDao(Connection connection){
        this.connection=connection;
    }

    public List<todo> getAllTodos(){
        List<todo> todoList=new ArrayList<>();
        String query="SELECT * FROM todo_app";
        try {
            PreparedStatement pst=connection.prepareStatement(query);
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String todo=rs.getString("todo");
                String status=rs.getString("status");
                todoList.add(new todo(id,name,todo,status));
            }
        }catch (SQLException e){
            e.getMessage();
        }
        return todoList;
    }

    public boolean addTodo(String name, String todo, String status){
        String query="INSERT INTO todo_app(name,todo,status) VALUES(?,?,?)";
        try{
            PreparedStatement pst=connection.prepareStatement(query);
            pst.setString(1,name);
            pst.setString(2,todo);
            pst.setString(3,status);
            int rowsAffected= pst.executeUpdate();
            if (rowsAffected>0){
                return true;
            }

        }catch (SQLException e){
            e.getMessage();
        }
        return false;
    }

    public todo getTodoById(int id)throws SQLException{
        todo Todo=null;
        String query="SELECT * FROM todo_app WHERE id=?";
        PreparedStatement pst=connection.prepareStatement(query);
        pst.setInt(1,id);
        ResultSet rs= pst.executeQuery();
        if(rs.next()){
            Todo=new todo(rs.getInt("id"),rs.getString("name"),rs.getString("todo"),rs.getString("status"));
        }
        return Todo;
    }

    public boolean updateTodo(todo Todo)throws SQLException{
        String query="UPDATE todo_app SET name=?, todo=? ,status=? WHERE id=?";
        PreparedStatement pst=connection.prepareStatement(query);
        pst.setString(1,Todo.getName());
        pst.setString(2,Todo.getTodo());
        pst.setString(3,Todo.getStatus());
        pst.setInt(4,Todo.getId());
        return pst.executeUpdate() >0;
    }

    public boolean deleteTodo(int id){
        boolean f=false;
        try{
            String query="DELETE FROM todo_app WHERE id=?";
            PreparedStatement pst=connection.prepareStatement(query);
            pst.setInt(1,id);
            int rowsAffected=pst.executeUpdate();
            if (rowsAffected>0){
                f=true;
                return f;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return f;
        }

        public List<todo> searchByName(String name){
        List<todo> todoList=new ArrayList<>();
        String query="SELECT * FROM todo_app WHERE name LIKE ?";
        try{
            PreparedStatement pst=connection.prepareStatement(query);
            pst.setString(1,"%"+name+"%");
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                int id= rs.getInt("id");
                String Name=rs.getString("name");
                String todo=rs.getString("todo");
                String status=rs.getString("status");
                todoList.add(new todo(id,Name,todo,status));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
            return todoList;
        }


}
