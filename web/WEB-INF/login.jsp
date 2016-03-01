<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="/error.jsp" %>

<jsp:include page="/headerIncludes.jsp" >
    <jsp:param name="title" value="Login" />
</jsp:include>

<%
    String s = "";
    String name = "";
    if (request.getAttribute("name") != null) {
        name = request.getAttribute("name").toString();
    }
    if (request.getSession().getAttribute("username") != null) {
        s = request.getSession().getAttribute("username").toString();
    }
%>


<div class="container-fluid"> 

    <div class="text-center" style="width:100%;margin: 100px 0 20px 0"> 
        <jsp:useBean id="vObj" type="beans.UserValues" scope="request" />
        <h2 style="color:#fff"><jsp:getProperty name="vObj" property="msg" /></h2>
    </div>
    <% if (request.getSession().getAttribute("username") == null) {%>
    <div class="text-center" style="border-top: #960C0F solid 5px;padding: 10px 0 10px 0;background-color:#BE1418;width:100%;border-bottom: #960C0F solid 5px;"> 
        <div style="margin: 0 auto;width:1000px">

            <form id="login" action="<%=request.getContextPath()%>/Login" method="POST">
                <input class="user" type="text" name="username" id="username" size="20" placeholder="Username" value="<%out.write(name);%>" data-validation="length" data-validation-length="2-30" />
                <input class="user" type="password" name="password" id="password" size="20" placeholder="Password" data-validation="length" data-validation-length="2-32" /><br />

        </div>
    </div>
    <div class="text-center" style="background-color:#E8E8E8; border-bottom: #BABABA solid 5px;padding: 5px 0 10px 0;"> 
        <input  class="userButton" type="submit" name="action" id="action" value="Login" />
        </form>

    </div>
    <%}%>
</div>



<jsp:include page="/footerIncludes.jsp"/>
