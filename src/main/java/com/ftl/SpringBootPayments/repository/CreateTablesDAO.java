package com.ftl.SpringBootPayments.repository;

import com.ftl.SpringBootPayments.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class CreateTablesDAO {
    private static final Logger logger = (Logger) LogManager.getLogger("LOG_TO_FILE");

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<User> mapper = BeanPropertyRowMapper.newInstance(User.class);

    @Autowired
    public CreateTablesDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createTables() {

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

        jdbcTemplate.execute(sb.toString());
        logger.info( "Tables were created from sql file");
        return sb.toString();
    }


}
