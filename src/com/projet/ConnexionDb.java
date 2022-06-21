package com.projet;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionDb {

    private static ConnexionDb connexionDb = null;
    private Connection connection;
    public ConnexionDb(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String password = "";
            Connection conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/gestioninscriptiondb",
                            user,password);

           connection = conn;
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
    public static ConnexionDb getInstance(){
       if(connexionDb == null){
           connexionDb = new ConnexionDb();
       }
       return connexionDb;
    }
    public Connection getConnection(){
        return connection;
    }

}
