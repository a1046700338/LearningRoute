package servlet;

import pojo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        User user = new User();
        String ErrorMsg = "用户名或密码不正确!";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username != user.getUsername() && password != user.getPassword()){
            request.getSession().setAttribute("ErrorMsg",ErrorMsg);
        }else{
            response.sendRedirect(getServletContext().getContextPath()+"/user.jsp");
        }
    }
}
