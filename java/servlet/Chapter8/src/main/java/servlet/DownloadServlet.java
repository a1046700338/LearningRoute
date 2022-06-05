package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet(name = "DownloadServlet", value = "/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String filename = request.getParameter("filename");
        String folder = "E\\Folder\\upload";
        response.addHeader("Content-Type","application/octet-stream");
        response.addHeader("Content-Disposition","attachment;filename="+filename);
        InputStream in = getServletContext().getResourceAsStream(folder+filename);
        OutputStream out = response.getOutputStream();
        byte[] buffer = new byte[1024*10];
        int len;
        while((len = in.read(buffer)) != -1){
            out.write(buffer,0,len);
        }
    }
}
