//package com.ftl.SpringBootPayments.repository;
//
//import org.springframework.stereotype.Repository;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.sql.Connection;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//@Repository
//public class ReadFromInitFileDAO {
//
//    public List<String> readFromInitFile () {
//        List<String> stringsFromFile = new ArrayList<>();
//        String str = "";
//        try (FileReader reader = new FileReader("initdata.txt")) {
//            int c;
//            while ((c = reader.read()) != -1) {
//                if ((char) c == '\n') {
//                    //System.out.println(str);
//                    stringsFromFile.add(str);
//                    str = "";
//                    continue;
//                }
//                str += (char) c;
//            }
//            //LOG.log(Level.INFO, "Read from init file");
//        } catch (
//                IOException e) {
//            System.out.println(e.getMessage());
//            //LOG.log(Level.SEVERE, "Exception:", e);
//        }
//
//    return stringsFromFile;
//    }
//}
