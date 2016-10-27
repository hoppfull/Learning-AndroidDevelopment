package com.example.hoppf.ex08_sqlite;

public class MyModel {
    public static final String SQL_CREATETABLE = "CREATE TABLE IF NOT EXISTS MyModel(s TEXT, x INTEGER);";
    public final int id;
    public final String s;
    public final int x;

    public MyModel(String s, int x) {
        this.id = -1;
        this.s = s;
        this.x = x;
    }

    public MyModel(int id, String s, int x) {
        this.id = id;
        this.s = s;
        this.x = x;
    }
}
