package be.ifosup.login;

import java.sql.*;

public class LoginDAO {
    public static boolean valid(String nom, String pass){
        boolean action = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver OK");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String url="jdbc:mysql://localhost:3306/5IPO1?serverTimezone=CET";
        String user ="root";
        String password="";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultat = null;
        try{
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Connexion OK");
        }catch(SQLException e){
            System.out.println(e);
        }
        // verifier le user/pass dans la DB
        try{
            statement = connection.createStatement();
            PreparedStatement requete = connection.prepareStatement("SELECT * FROM login WHERE user=? AND password=?");
            requete.setString(1,nom);
            requete.setString(2,pass);
            resultat = requete.executeQuery();
            if (resultat.next()){
                action = true;
            }
        }catch(SQLException e){
            System.out.println(e);
        } finally {
            try {
                if (resultat != null) resultat.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return action;
    }
}

