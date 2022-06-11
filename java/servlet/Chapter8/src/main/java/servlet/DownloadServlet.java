package servlet;
import java.io.*;
import java.net.URLEncoder;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(name = "DownloadServlet",urlPatterns = "/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String fileName = request.getParameter("filename");
        System.out.println(fileName);
        fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");
        // 上传的文件都是保存在/WEB-INF/upload目录下的子目录当中
        String fileSaveRootPath = this.getServletContext().getRealPath("/WEB-INF/upload");
        // 得到要下载的文件
        File file = new File(fileSaveRootPath + "\\" + fileName);
        // 如果文件不存在
        if (!file.exists()) {
            request.setAttribute("message", "您要下载的资源已被删除！！");
            request.getRequestDispatcher("/download.jsp").forward(request, response);
            return;
        }
        // 设置响应头，控制浏览器下载该文件

        // 设置文件MIME类型
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        FileInputStream in = new FileInputStream(file);

        OutputStream out = response.getOutputStream();



        byte buffer[] = new byte[1024];

        int len = 0;

        while ((len = in.read(buffer)) > 0) {

            out.write(buffer, 0, len);

        }

        in.close();

        out.close();

    }
    public void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        doGet(request, response);
    }
}
