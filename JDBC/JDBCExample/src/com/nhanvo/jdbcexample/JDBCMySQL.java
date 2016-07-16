/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhanvo.jdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nhanvo
 */
final class JDBCMySQL {
    static FinalInfo finalInfo = new FinalInfo();
    Connection m_connection;
    Statement  m_statement;

    public JDBCMySQL() {
        try {
            Class.forName(finalInfo.JDBC_MYSQL);
            m_connection = connectDatabase();            
            m_statement = m_connection.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }

    }
    
    // Connect database
    Connection connectDatabase() throws SQLException {
        return DriverManager.getConnection(finalInfo.URL, finalInfo.USER, finalInfo.PASSWORD);
    }
    
    /**
     * Show data
     */
    void showData(ResultSet rs, String info) throws SQLException {
        System.out.println(finalInfo.NEWLINE + info + finalInfo.NEWLINE);
        while (rs.next()) {
            System.out.println(rs.getInt(finalInfo.ID) + finalInfo.TAB_FORMAT +
                rs.getString(finalInfo.AUTHOR) + finalInfo.TAB_FORMAT +
                rs.getString(finalInfo.TITLE) + finalInfo.TAB_FORMAT +
                rs.getDouble(finalInfo.PRICE) + finalInfo.TAB_FORMAT +
                rs.getInt(finalInfo.QTY));            
        }
    }
    
    /**
     * Test select data from database
     */
    void TestSelect() throws SQLException {
        ResultSet rs = m_statement.executeQuery(finalInfo.SELECT_BOOK);
        showData(rs, finalInfo.SELECT_BOOK);
    }
    
    /**
     * Test update data from database
     */
    void TestUpdate() throws SQLException {
        m_statement.executeUpdate(finalInfo.UPDATE_BOOK);
        ResultSet rs = m_statement.executeQuery(finalInfo.SELECT_BOOK);
        showData(rs, finalInfo.UPDATE_BOOK);
    }
    
    /**
     * Test delete data from database
     */
    void TestDelete() throws SQLException {
        m_statement.executeUpdate(finalInfo.DELETE_BOOK);
        ResultSet rs = m_statement.executeQuery(finalInfo.SELECT_BOOK);
        showData(rs, finalInfo.DELETE_BOOK);
    }
    
    /**
     * Test insert data from database
     */
    void TestInsert() throws SQLException {
        m_statement.executeUpdate(finalInfo.INSERT_BOOK);
        ResultSet rs = m_statement.executeQuery(finalInfo.SELECT_BOOK);
        showData(rs, finalInfo.INSERT_BOOK);
    }
};
