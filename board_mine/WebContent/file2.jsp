<%@page import="java.io.IOException"%>
<%@page import="net.coobird.thumbnailator.geometry.Positions"%>
<%@page import="net.coobird.thumbnailator.Thumbnails"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

String saveDir = "E:\\upload";
int size = 10 * 1024 * 1024;

//System.out.println(saveDir);
//System.out.println(saveDir.toString());

File currentDir = new File(saveDir);

DiskFileItemFactory factory = new DiskFileItemFactory();
factory.setRepository(currentDir);
factory.setSizeThreshold(size);

ServletFileUpload upload = new ServletFileUpload(factory);

List<FileItem> items = upload.parseRequest(request);

for(FileItem fi : items) {
	System.out.println("=====================");
	System.out.println(fi);
	System.out.println(fi.getFieldName()); // input name 에 썼던 이름
	System.out.println(fi.getName());  // 파일명
	System.out.println(fi.getName().lastIndexOf("."));  // 파일명
	System.out.println(fi.isFormField()); // true : 일반 input , textarea / false 
	System.out.println(fi.getSize());
	
}



%>
</body>
</html>