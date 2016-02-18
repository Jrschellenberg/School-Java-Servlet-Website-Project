<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/headerIncludes.jsp" >
    <jsp:param name="title" value="Players" />
</jsp:include>

<% if (request.getParameter("p") == null){ %>
<c:forEach var="p" items="${allplayers}">
    <h1><a href="<%=request.getContextPath()%>/players?p=${p.playerId}">${p.playerName}</a></h1>
</c:forEach>
<% }else{ %>
<jsp:useBean id="playerValues" type="beans.PlayerValues" scope="request" />
<h1> Players Name ... <jsp:getProperty name="playerValues" property="playerName" /></h1>
<h1> Players Birthday ...<jsp:getProperty name="playerValues" property="playerBirthday" /></h1>
<h1> Players Picture ...<jsp:getProperty name="playerValues" property="playerPicture" /></h1>
<h1> Players Position ...<jsp:getProperty name="playerValues" property="playerPosition" /></h1>
<h1> Players Height ...<jsp:getProperty name="playerValues" property="playerHeight" /></h1>
<h1> Players Number ...<jsp:getProperty name="playerValues" property="playerNumber" /></h1>
<h1> Players Foot ...<jsp:getProperty name="playerValues" property="playerFoot" /></h1>
<h1> Players Club ...<jsp:getProperty name="playerValues" property="playerClub" /></h1>
<h1> Players Nation ...<jsp:getProperty name="playerValues" property="playerNation" /></h1>
<% } %>

<jsp:include page="/footerIncludes.jsp"/>