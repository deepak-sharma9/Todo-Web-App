package com.storage;

public class todo {
    private int id;
    private String name;
    private String todo;
    private String status;

    public todo(int id, String name, String todo, String status){
        this.id=id;
        this.name=name;
        this.todo=todo;
        this.status=status;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getTodo(){
        return todo;
    }
    public void setTodo(String todo){
        this.todo=todo;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;
    }

}
