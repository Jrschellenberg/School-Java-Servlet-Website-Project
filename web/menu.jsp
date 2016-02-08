<% 
    String style = "";
    if(request.getParameter("title") ==null ){ 
        style = "homeNav";
    }else{
        style = "hNav";
    }
%>
<ul class="<%out.write(style);%>">
    <li><a href="<%=request.getContextPath()%>/PlayerServlet">Players</a></li>
    <li><a href="clubs.jsp">Clubs</a></li>
    <li><a href="leagues.jsp">Leagues</a></li>
    <li><a href="nations.jsp">Nations</a></li>
    
    <% if(request.getSession().getAttribute("username") !=null){ %>
        <li><a href="<%=request.getContextPath()%>/Controller?action=Logout">Logout</a></li>
    <%}else{%>
    <li><a href="login.jsp">Login</a></li>
    <li class="special"><a href="register.jsp">Register</a></li>
    <%}%>
    <% if(request.getSession().getAttribute("admin") != null){ %>
    <li class="special"><a href="adminpage">Admin Page</a></li>
    <%}%>
    
    
</ul>

 

        

