package com.exmaple.controller;

import com.exmaple.config.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "update" ,urlPatterns = "/update")
public class updateUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String username = req.getParameter("name");
        String password = req.getParameter("password");

        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "update user set  username = ? , password = ? where id = ?";
        try {
            int update = queryRunner.update(sql, username, password,id);
            resp.sendRedirect("/query");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
