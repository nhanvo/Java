/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhanvo.jdbcexample;

/**
 *
 * @author nhanvo
 */
class FinalInfo {
    // Database information
    final String URL = "jdbc:mysql://localhost:3306/ebookshop";    
    final String USER = "root";
    final String PASSWORD = "root";

    // JDBC-MYSQL Driver
    final String JDBC_MYSQL= "com.mysql.jdbc.Driver";

    // SQL Command
    final String ID = "id";
    final String AUTHOR = "author";
    final String TITLE = "title";
    final String PRICE = "price";
    final String QTY = "qty";
    final String SELECT_BOOK = "select * from books";
    final String UPDATE_BOOK = "update books set price = price*0.7, qty = qty+1 where (id%2=0)";
    final String DELETE_BOOK = "delete from books where id>=3000 and id<4000";
    final String INSERT_BOOK = "insert into books values "
        + "(3001, 'Java Cookbook in 24 hour', 'Kumar', 11.11, 11),"
        + "(3002, 'Java Development for newbie', 'Jonh Thomson', 22.22, 22),"
        + "(3003, 'Java Thinking for you', 'Jack Handrew', 33.33, 33)";
    
    // Format display
    final String TAB_FORMAT = "\t";
    final String NEWLINE = "\n";
};
