package test;

import utils.MyDatabase;

import java.sql.Connection;

public class main {
    public static void main(String[] args) {
        MyDatabase db=MyDatabase.getInstance();
        Connection con=db.getConnection();
    }
}
