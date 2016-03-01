
<%-- Checking if title is null(index page) to use diffrent style for the Menue --%>
<%
    String style = "";
    if (request.getParameter("title") == null) {
        style = "homeNav";
    } else {
        style = "hNav";
    }
%>
<ul class="<%out.write(style);%>">

    <li><a href="<%=request.getContextPath()%>/Leagues">Leagues</a></li>
    <li><a href="<%=request.getContextPath()%>/Clubs">Clubs</a></li>
    <li><a href="<%=request.getContextPath()%>/Players">Players</a></li>
    <li><a href="<%=request.getContextPath()%>/Nations">Nations</a></li>

    <%-- Checking if user logged in to show (logout) link --%>
    <% if (request.getSession().getAttribute("username") != null) {%>
    <li><a href="<%=request.getContextPath()%>/Login?action=Logout">Logout (<%out.write(request.getSession().getAttribute("username").toString());%>)</a></li>
        
    <%} else {%><%-- Otherwise show Login and Register links --%>
    <li><a href="<%=request.getContextPath()%>/Login">Login</a></li>
    <li class="special"><a href="<%=request.getContextPath()%>/Register">Register</a></li>
        <%}%>

    <%-- Checking if user is Admin to show (admin) link --%>
    <% if (request.getSession().getAttribute("admin") != null) {%>
    <li class="special"><a href="<%=request.getContextPath()%>/Admin">Admin</a></li>
        <%}%>
</ul>





