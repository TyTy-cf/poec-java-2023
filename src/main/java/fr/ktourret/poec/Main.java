package fr.ktourret.poec;

import fr.ktourret.poec.my_mvc.service.DBConnect;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        Connection c1 = DBConnect.getConnection();
        Connection c2 = DBConnect.getConnection();
        System.out.println(c1);
        System.out.println(c2);
    }

}