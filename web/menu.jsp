<% 
    String style = "";
    if(request.getParameter("title") ==null ){ 
        style = "homeNav";
    }else{
        style = "hNav";
    }
%>
<ul class="<%out.write(style);%>">
    <li><a href="<%=request.getContextPath()%>/Players">Players</a></li>
    <li><a href="<%=request.getContextPath()%>/Clubs">Clubs</a></li>
    <li><a href="<%=request.getContextPath()%>/Leagues">Leagues</a></li>
    <li><a href="<%=request.getContextPath()%>/Nations">Nations</a></li>
    
    <% if(request.getSession().getAttribute("username") !=null){ %>
        <li><a href="<%=request.getContextPath()%>/Controller?action=Logout">Logout</a></li>
    <%}else{%>
    <li><a href="<%=request.getContextPath()%>/Login">Login</a></li>
    <li class="special"><a href="register.jsp">Register</a></li>
    <%}%>
    <% if(request.getSession().getAttribute("admin") != null){ %>
    <li class="special"><a href="adminpage">Admin Page</a></li>
    <%}%>
    
    
</ul>

 

        

