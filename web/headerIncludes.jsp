<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%-- Custom title depends on the page you are browsing using the Parameter (title) --%>
        <title> Shoot 24 | <% out.write(request.getParameter("title"));%></title> 
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" media="screen">
        <link rel="stylesheet" type="text/css" href="css/normalize.css" media="screen">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" media="screen">
        <link rel="stylesheet" type="text/css" href="css/styles.css" media="screen">
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

                        <a class="navbar-brand" title="Home" href="<%=request.getContextPath()%>/">
                            <img src="images/logo-small.png" alt="shoot 24" style="width:181px;height: 49px;">
                        </a>
                        <form id="search" action="<%=request.getContextPath()%>/Search" method="GET" enctype="text/plain" style="float:  right;">
                            <div><input class="searchHeader"  type="text" name="q" id="q" placeholder="Search for any player..."></div>
                        </form>
                    </div>

                    <div class="collapse navbar-collapse navbar-responsive-collapse navbar-right">
                        <jsp:include page="/menu.jsp"/><%-- including the menue here (menu.jsp) --%>  
                    </div>

                </div> 
            </div> 
        </header> 