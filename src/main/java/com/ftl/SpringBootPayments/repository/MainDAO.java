package com.ftl.SpringBootPayments.repository;

import org.springframework.stereotype.Repository;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class MainDAO {
    public void createTables(Connection connection) {

        String s = new String();
        StringBuffer sb = new StringBuffer();
        FileReader fr = null;
        try {
            fr = new FileReader(new File("sql.sql"));
            BufferedReader br = new BufferedReader(fr);


            while((s = br.readLine()) != null)
            {
                sb.append(s);
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(String.valueOf(sb));
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //LOG.log(Level.INFO, "Tables created");
    }


}
