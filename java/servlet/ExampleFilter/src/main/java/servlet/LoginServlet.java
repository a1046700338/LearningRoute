package servlet;

import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        if("admin".equals(username) && "123456".equals(password)){
            user.setUsername(username);
            user.setPassword(password);
            request.getSession().setAttribute("user",user);
            String autologin = request.getParameter("autologin");
            if(autologin != null){
                Cookie cookie = new Cookie("autologin",username+"-"+password);
                cookie.setMaxAge(Integer.parseInt(autologin));
                cookie.setPath(request.getContextPath());
                response.addCookie(cookie);
            }
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else{
            request.setAttribute("errorMsg","用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
