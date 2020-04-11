package com.example.sql_example.repository;

public class SQLScripts {
    public static String initDbScript() {
        return "create table user(" +
                "id integer primary key autoincrement," +
                "name text not null," +
                "password text not null" +
                ");";
    }

    public static String insertUserScript(String name, String password) {
        String _name = "\"" + name + "\"";
        String _password = "\"" + password + "\"";

        return "insert into user" +
                "(name, password)" +
                "values" +
                "(" + _name + "," + _password +
                ");";
    }

    public static String getUserById(int id) {
        return "select * from user where id = " + id + ";";
    }

    public static String deleteById(int id){
        return "delete from user where id = " + id + ";";
    }

    public static String getUserScript(String name, String password) {
        String _name = "\"" + name + "\"";
        String _password = "\"" + password + "\"";

        return "select * from user" +
                " where name = " + _name +
                " and password = " + _password +
                ";";
    }

    public static String getAllUsersScript() {
        return "select * from user;";
    }

    public static String getAllUsersScript(int limit) {
        return "select * from user" +
                " limit " + limit +
                ";";
    }

}