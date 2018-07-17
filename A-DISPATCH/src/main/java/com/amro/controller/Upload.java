package com.amro.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class Upload
 */
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(50*1024*1024);
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	        if (!isMultipart) {
	            request.setAttribute("message","This is not a multipart request.");
	            getServletContext().getRequestDispatcher("html/index.jsp").forward(request, response);
	        }
			try {
				List<FileItem> fileItems = upload.parseRequest(request);
				
				Iterator<FileItem> iterator = fileItems.iterator();
				if (!iterator.hasNext()) {
					System.out.println("No fields found");
					return;
				}
				while(iterator.hasNext()) {
					FileItem file = (FileItem)iterator.next();
					if(!file.isFormField()) {
						String fileName = file.getName();
//						getServletContext().getRealPath("/")  this is the root directory of the application
//						File file1 = new File("/Users/amroarafat/eclipse-workspace/A-DISPATCH/upload/");
						int userId = (Integer) request.getSession().getAttribute("userID");
						File file0 = new File("/Users/amroarafat/eclipse-workspace/A-DISPATCH/upload/");
						File file1 = new File(file0 ,"/"+userId);
						if(!file1.exists()) {
							file1.mkdir();
						}
						System.out.println(file1.getAbsolutePath());
						file.write(new File(file1.getAbsoluteFile()+"/"+fileName));
					}
					
				}
			} catch (Exception e) {
					System.out.println(e.getMessage());
			}
	}

}
