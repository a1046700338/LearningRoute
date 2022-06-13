package com.exmaple.controller;

import com.exmaple.config.C3P0Utils;
import com.exmaple.pojo.user;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "queryByWord",urlPatterns = "/queryByWord")
public class queryByWordUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String word = req.getParameter("word");
        String sql = "select * from user where username like concat('%',?,'%') or password like concat('%',?,'%')";
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        try {
            List<user> query = queryRunner.query(sql, new BeanListHandler<user>(user.class), word, word);
            req.setAttribute("list",query);
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
