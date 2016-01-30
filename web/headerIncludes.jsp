<%-- 
    Document   : headerIncludes
    Created on : Jan 29, 2016, 6:00:00 PM
    Author     : Justin
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> <% out.write(request.getParameter("title")); %></title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" media="screen">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" media="screen">
        <link rel="stylesheet" type="text/css" href="css/styles.css" media="screen">
    </head>
    <body>
        
