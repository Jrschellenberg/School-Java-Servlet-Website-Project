<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/headerIncludes.jsp" >
    <jsp:param name="title" value="Clubs" />
</jsp:include>


<% if (request.getParameter("c") == null) {%>

<div class="container-fluid"> 

    <div class="text-center" style="background-color:#BE1418;width:100%;border-bottom: #960C0F solid 5px;border-top: #960C0F solid 5px;margin: 100px 0 100px 0"> 
        <div style="margin: 0 auto;width:1000px;">

            <div class="row">
                <div class="col-sm-9 col-md-8 col-lg-9" style="float: none;display: table-cell;">
                    <div class="row">
                        <c:forEach var="c" items="${clubs}">
                            <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2" style="margin: 5px 0;">
                                <div class="url_box" style="width:150px;height:75px;;">
                                    <a href="<%=request.getContextPath()%>/Clubs?c=${c.clubId}">
                                        <div style="padding-top: 4px">
                                            <img src="<%=request.getContextPath()%>/images/clubs/${c.clubPicture}" alt="" style="width:48px;height:48px">
                                            <h1 class="small">${c.clubName}</h1>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </c:forEach>

                    </div>
                </div>
            </div>

        </div>
    </div>     
</div>


<% } else {%>

<div class="container-fluid"> 
    <div class="text-center" style="background-color:#BE1418;width:100%;border-bottom: #960C0F solid 5px;margin: 30px 0 10px 0"> 
        <div style="margin: 0 auto;width:1000px;font-size: 72px; color: #fff">
            <img src="<%=request.getContextPath()%>/images//clubs/<c:out value="${players[0].playerClubPicture}"/>" style="width:72px;height:72px">
            <c:out value="${players[0].playerClub}"/>     
            <img src="<%=request.getContextPath()%>/images//clubs/<c:out value="${players[0].playerClubPicture}"/>" style="width:72px;height:72px">
        </div>
    </div>

</div>                    
<div class="row container" style="display: table;">

    <div class="col-sm-9 col-md-8 col-lg-9" style="float: none;display: table-cell;vertical-align: top;">

        <div class="row">
            <c:forEach var="p" items="${players}">
                <%@ include file="playerCard.jsp" %>
            </c:forEach>
        </div>


    </div>

</div>

<% }%>     

</div>

<jsp:include page="/footerIncludes.jsp"/>