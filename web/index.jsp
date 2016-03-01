<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shoot 24</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" media="screen">
        <link rel="stylesheet" type="text/css" href="css/normalize.css" media="screen">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" media="screen">
        <link rel="stylesheet" type="text/css" href="css/styles.css" media="screen">
    </head>
    <body>
        <div class="container-fluid"> 
            <div class="text-center"> 
                <img src="images/logo.jpg" style="margin-bottom: 10px;">
                <jsp:include page="/menu.jsp"  /> <%-- including the menue here (menu.jsp) --%>
            </div>

            <div class="text-center" style="background-color:#BE1418; border-top: #960C0F solid 5px;border-bottom: #960C0F solid 5px;padding: 40px 0 40px 0;width:100%"> 
                <div class="text-center">  
                    <form id="searchHome" action="<%=request.getContextPath()%>/Search" method="GET" enctype="text/plain">
                        <div style="padding: 10px 0 10px 0;">
                            <input  class="searchHome" type="text" name="q" id="q" placeholder="Search Your Favorite Player">   
                        </div>
                    </form>       
                </div>
            </div>

            <div class="text-center" style="background-color:#E8E8E8; border-bottom: #BABABA solid 5px;padding: 10px 0 10px 0;">
                <%-- checking if the user logged in to show a welcome message with the user name  --%>
                <%if (request.getSession().getAttribute("username") != null) {%>
                <h2>Hey <%out.write(request.getSession().getAttribute("username").toString());%> !</h2>
                <%}%>
            </div>

        </div>


         <%-- including the footer here (footerIncludes.jsp) --%>
        <jsp:include page="/footerIncludes.jsp"/>