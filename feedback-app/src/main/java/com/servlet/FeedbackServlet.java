package com.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class FeedbackServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("yourName");
        String bookName = req.getParameter("bookName");
        String feedback = req.getParameter("feedback");

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            connection = DriverManager.getConnection("jdbc:mysql://localhost/user_management?user=root&password=Naga@123");

            String sql = "INSERT INTO feedback (name, book_name, feedback) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, bookName);
            preparedStatement.setString(3, feedback);

            preparedStatement.executeUpdate();
            res.getWriter().println("Feedback saved...");

        } catch (SQLException e) {
            e.printStackTrace();
            res.getWriter().println("Error while saving feedback!");
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
