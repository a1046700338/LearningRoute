package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "UploadServlet", value = "/UploadServlet")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            response.setContentType("text/html;charset=utf-8");
            DiskFileItemFactory factory = new DiskFileItemFactory();
            File f = new File("E:\\Folder");
            if(!f.exists()){
                f.mkdirs();
            }
            factory.setRepository(f);
            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            fileUpload.setHeaderEncoding("utf-8");
            List<FileItem> fileitems = fileUpload.parseRequest(request);
            PrintWriter writer = response.getWriter();
            for(FileItem fileitem : fileitems){
                if(fileitem.isFormField()){
                    String name = fileitem.getFieldName();
                    if(name.equals("name")){
                        if(!fileitem.getString().equals("")){
                            String value = fileitem.getString("utf-8");
                            writer.println("上传者："+value);
                        }
                    }
                }else{
                    String filename = fileitem.getName();
                    if(filename != null && filename.equals("") ){
                        writer.println("上传的文件名："+filename);
                        filename = filename.substring(filename.lastIndexOf("\\")+1);
                        filename = UUID.randomUUID().toString()+"_"+filename;
                        String webpath = "/upload";
                        String filepath = getServletContext().getRealPath(webpath+filename);
                        File file = new File(filepath);
                        file.getParentFile().mkdirs();
                        file.createNewFile();
                        InputStream in = fileitem.getInputStream();
                        FileOutputStream out = new FileOutputStream(file);
                        byte[] buffer = new byte[1024*10];
                        int len;
                        while((len = in.read(buffer)) > 0){
                            out.write(buffer,0,len);
                        }
                        in.close();
                        out.close();
                        fileitem.delete();
                        writer.println("上传文件成功！");
                    }
                }
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
