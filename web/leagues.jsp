<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="headerIncludes.jsp" >
    <jsp:param name="title" value="Leagues" />
</jsp:include>


<div class="container-fluid"> 

            <div class="text-center" style="background-color:#BE1418; border-top: #960C0F solid 5px;padding: 0 0 50px 0;width:100%;margin-top: 100px"> 

            </div>

            <div class="text-center" style="background-color:#BE1418;width:100%;border-bottom: #960C0F solid 5px;"> 
                <div style="margin: 0 auto;width:1000px">
                    <br style="clear: left;" />
                    
                    
                    <% if (request.getParameter("l") == null){ %>
                    Leagues:
                    <c:forEach var="l" items="${leagues}">
                        <h1><a href="<%=request.getContextPath()%>/leagues?l=${l.leagueId}">${l.leagueName}</a></h1>
                    </c:forEach>
                        <% }else{ %>
                    <br />
                    Clubs:
                    <c:forEach var="c" items="${clubs}">
                        <h1><a href="<%=request.getContextPath()%>/clubs?c=${c.clubId}">${c.clubName}</a></h1>
                    </c:forEach>
                    <br />
                    players:
                    <c:forEach var="p" items="${players}">
                        <h1><a href="<%=request.getContextPath()%>/players?p=${p.playerId}">${p.playerName}</a></h1>
                    </c:forEach>
                     <% } %>     
                    <br />
                    <br style="clear: left;" />
                    
                </div>
            </div>
            <div class="text-center" style="background-color:#E8E8E8; border-bottom: #BABABA solid 5px;padding: 10px 0 10px 0;"> 
                
                
            </div>
            
    </div>


<jsp:include page="footerIncludes.jsp"/>
