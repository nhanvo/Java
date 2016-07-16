/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Reference from https://www.ntu.edu.sg/home/ehchua/programming/java/JDBC_Basic.html
 */
package com.nhanvo.jdbcexample;

import java.sql.*;

/**
 *
 * @author nhanvo
 */

public class Main {
    
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        
        JDBCMySQL jdbcMySQL = new JDBCMySQL();

        // Test SELECT
        jdbcMySQL.TestSelect();

        // UPDATE
        jdbcMySQL.TestUpdate();
        
        // DELETE
        jdbcMySQL.TestDelete();

        // INSERT
        jdbcMySQL.TestInsert();
    }
    
}
