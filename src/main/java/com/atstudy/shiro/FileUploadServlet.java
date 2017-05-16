package com.atstudy.shiro;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by admin on 2017/5/15.
 */
@Controller
public class FileUploadServlet{

    @RequestMapping(value = "/fileuploadServlet",method = {RequestMethod.POST})
    public void fileUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("doPost ... ");
        request.setAttribute("filePath","filePathValud");

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletContext servletContext = request.getSession().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);

        ServletFileUpload upload = new ServletFileUpload(factory);

        List<FileItem> items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        String fileRootPath = servletContext.getRealPath("/files/");

        Iterator<FileItem> iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = iter.next();

            if (item.isFormField()) {

                String name = item.getFieldName();
                String value = item.getString();
            } else {
                String fieldName = item.getFieldName();
                String fileName = item.getName();
                String contentType = item.getContentType();
                boolean isInMemory = item.isInMemory();
                long sizeInBytes = item.getSize();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                File uploadedFile = new File(fileRootPath + sdf.format(new Date())+".jpg");
                try {
                    item.write(uploadedFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        request.getRequestDispatcher("fileupload.jsp").forward(request,response);
    }
}
