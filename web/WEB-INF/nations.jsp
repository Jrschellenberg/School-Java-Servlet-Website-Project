<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/headerIncludes.jsp" >
    <jsp:param name="title" value="Nations" />
</jsp:include>

<% if (request.getParameter("n") == null) {%>

<div class="container-fluid"> 

    <div class="text-center" style="background-color:#BE1418;width:100%;border-bottom: #960C0F solid 5px;border-top: #960C0F solid 5px;margin: 100px 0 100px 0"> 
        <div style="margin: 0 auto;width:1000px;">

            <div class="row">
                <div class="col-sm-9 col-md-8 col-lg-9" style="float: none;display: table-cell;">
                    <div class="row">

                        <c:forEach var="n" items="${nations}">
                            <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2" style="margin: 5px 0;">
                                <div class="url_box" style="width:140px;height:75px;">
                                    <a href="<%=request.getContextPath()%>/Nations?n=${n.nationId}">
                                        <div>
                                            <img src="http://futhead.cursecdn.com/static/img/16/nations/38.png" alt="" style="width:50px;height:50px">
                                            <h1 class="small">${n.nationName}</h1>
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
        <div style="margin: 0 auto;width:1000px;font-size: 92px; color: #fff"> 
            <c:out value="${players[0].playerNation}"/> 
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

<jsp:include page="/footerIncludes.jsp"/>