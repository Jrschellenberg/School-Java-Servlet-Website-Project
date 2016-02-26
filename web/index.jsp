<%-- 
    Document   : Index
    Created on : Jan 29, 2016, 1:41:01 PM
    Author     : Justin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Shoot 24 </title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" media="screen">
        <link rel="stylesheet" type="text/css" href="css/normalize.css" media="screen">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" media="screen">
        <link rel="stylesheet" type="text/css" href="css/styles.css" media="screen">
    </head>
    <body>


        <div class="container-fluid"> 
            <div class="text-center"> 
                  
                <img src="images/logo.jpg" style="margin-bottom: 10px;">
                
                <jsp:include page="/menu.jsp"  />
                   
            </div>

            <div class="text-center" style="background-color:#BE1418; border-top: #960C0F solid 5px;padding: 70px 0 50px 0;width:100%"> 
                <div class="text-center">  
                    <form id="search" action="<%=request.getContextPath()%>/Search" method="GET" enctype="text/plain" class="navbar-form">
                        <div class="sf_search" style="padding: 10px 0 10px 0;">
                            <%if(request.getSession().getAttribute("username") !=null){%>
                            <h1>Hey <%out.write(request.getSession().getAttribute("username").toString());%></h1>
                            <%}%>
                            <input  class="sf_input" type="text" name="q" id="q" value="Search Your Favorite Player" style="font-size:16pt;width:400px;height:30px;text-align: center">   
                        </div>
                    </form>
                </div>
            </div>

            <div style="background-color:#BE1418;width:100%;border-bottom: #960C0F solid 5px;"> 
                <div style="margin: 0 auto;width:1000px">
                    <br style="clear: left;" />
                </div>
            </div>
            <div class="text-center" style="background-color:#E8E8E8; border-bottom: #BABABA solid 5px;padding: 70px 0 10px 0;"> 
                	
            </div>
            
        </div>


      
<jsp:include page="/footerIncludes.jsp"/>