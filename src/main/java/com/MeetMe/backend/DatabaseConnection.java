package com.MeetMe.backend;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Component
public class DatabaseConnection {
    Event event;

    public DatabaseConnection(Event event){
        this.event = event;
    }

    public void addToDB() {

        try
        {
            // create a mysql database connection
            String myUrl = "jdbc:mysql://localhost:3306/MeetMe?useSSL=false";
            Connection conn = DriverManager.getConnection(myUrl, "root", "qwerty123");

            // the mysql insert statement
            String query = "INSERT INTO event(title,date,location,description) "
                    + "VALUES(?,?,?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, event.getTitle());
            preparedStmt.setString(2, event.getDate());
            preparedStmt.setString(3, event.getLocation());
            preparedStmt.setString(4, event.getDescription());

            // execute the preparedstatement
            preparedStmt.execute();
            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}
