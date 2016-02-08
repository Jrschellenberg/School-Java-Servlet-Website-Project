<ul class="hNav">
    <li class="special"><a href="register.jsp">Register</a></li>
    <li><a href="players.jsp">Players</a></li>
    <li><a href="clubs.jsp">Clubs</a></li>
    <li><a href="leagues.jsp">Leagues</a></li>
    <li><a href="nations.jsp">Nations</a></li>
    
    <% if(request.getSession().getAttribute("username") !=null){ %>
        <li><a href="<%=request.getContextPath()%>/Logout">Logout</a></li>
    <%}else{%>
    <li><a href="login.jsp">Login</a></li>
    <%}%>
    <% if(request.getSession().getAttribute("admin") != null){ %>
    <li><a href="adminpage">Admin Page</a></li>
    <%}%>
    
    
</ul>

 

        

