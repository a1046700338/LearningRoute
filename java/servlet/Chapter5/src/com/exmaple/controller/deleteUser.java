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

@WebServlet(name = "delete" ,urlPatterns = "/delete")
public class deleteUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String sql = "delete from user where id = ?";
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        try {
            int execute = queryRunner.execute(sql, id);
            resp.sendRedirect("/query");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
