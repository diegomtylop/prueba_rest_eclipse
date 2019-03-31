package com.aliadoit.database;


import com.aliadoit.entities.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class UserDaoDataBase {
	
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	//Datos de conexión
	private static final String CONNECTION_URL = "jdbc:mysql://localhost/feedback?user=sqluser&password=sqluserpw";
	
    public List<User> getAllUsers() throws Exception{

        List<User> userList = new ArrayList<User>();
        try {
			// This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection( CONNECTION_URL);

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from feedback.usuarios");
            
            // Convierte los resultados de la base de datos en una lista de objetos java
            while (resultSet.next()) {
                // It is possible to get the columns via name
                // also possible to get the columns via the column number
                // which starts at 1
                // e.g. resultSet.getSTring(2);
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String profession = resultSet.getString("profession");
                
                User userFromRow = new User(id, name, profession);
                userList.add( userFromRow );
            }

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
        return userList;
    }
    
    
    public User getUser(int idUser) throws Exception {
        try {
			// This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection( CONNECTION_URL);

            // Statements allow to issue SQL queries to the database
            preparedStatement = connect.prepareStatement("select * from feedback.usuarios where id = ?");
            
            preparedStatement.setInt(1, idUser);
            
            resultSet = preparedStatement.executeQuery();
           
            //Convierte la fila retornada en un objeto de tipo User
            if( resultSet.next() ) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String profession = resultSet.getString("profession");
                
                User userFromRow = new User(id, name, profession);
                return userFromRow;
            }else {
            	return null;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
    
 // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
}