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
        <title> Shoot 24 | <% out.write(request.getParameter("title")); %></title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css" media="screen">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/normalize.css" media="screen">
        <link href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css" rel="stylesheet" media="screen">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/styles.css" media="screen">
    </head>
    <body>
        <header role="banner">

            <div class="navbar navbar-default navbar-fixed-top">

                <div class="container">

                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>

                        <a class="navbar-brand" title="description" href="<%=request.getContextPath()%>/Home"><img src="images/logo-small.png" style="width:181px;height: 49px;"></a>

                                <form id="search" action="<%=request.getContextPath()%>/Search" method="GET" enctype="text/plain" style="float:  right;">
                                    <div>
                                        <input class="searchHeader"  type="text" name="q" id="q" placeholder="Search for any player...">   
                                    </div>
                                </form>
                    </div>

                    <div class="collapse navbar-collapse navbar-responsive-collapse navbar-right">
                        <jsp:include page="/menu.jsp"/>  
                    </div>

                </div> <!-- end .container -->
            </div> <!-- end .navbar -->

        </header> <!-- end header -->