<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/headerIncludes.jsp" >
    <jsp:param name="title" value="Leagues" />
</jsp:include>



<% if (request.getParameter("l") == null) {%>

<div class="container-fluid"> 

    <div class="text-center" style="background-color:#BE1418;width:100%;border-bottom: #960C0F solid 5px;border-top: #960C0F solid 5px;margin-top: 100px"> 
        <div style="margin: 0 auto;width:1000px;">

            <div class="row container" style="display: table;">
                <div class="col-sm-9 col-md-8 col-lg-9" style="float: none;display: table-cell;vertical-align: top;">
                    <div class="row">

                        <c:forEach var="l" items="${leagues}">
                            <div class="col-xs-6 col-sm-4 col-md-3 col-lg-15" style="margin: 5px 0 5px 3px;"> 
                                <div class="url_box" style="width:173px;height:180px;">
                                    <a href="<%=request.getContextPath()%>/Leagues?l=${l.leagueId}">
                                        <div>
                                            <img src="<%=request.getContextPath()%>/images/leagues/${l.leaguePicture}" style="width:128px;height:128px">
                                            <h1>${l.leagueName}</h1>
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

<div class="row container" style="display: table;">
    <div class="col-sm-3 col-md-4 col-lg-3" style="color:#fff;height:100%;;background-color: #2E2E2E;float: none;display: table-cell;">
        <div class="row text-center" style="min-height: 200px;border-bottom: #BD1418 solid 5px;background-color: #fff">   
            <img src="http://3.bp.blogspot.com/-TppYKVyfGGk/VNqG7XoA-VI/AAAAAAAAn4w/mO6qyNl2yuo/s1600/Premier%2BLeague.png" style="width:180px;height:180px;">
        </div>


        <div class="row" style="border-left: #515151 solid 0px;height: 100vh;">

            <!-- Clubs Table -->
            <div class="table-responsive">
                <div class="table_title">Clubs</div>
                <c:forEach var="c" items="${clubs}">
                    <div class="url_table">
                        <a href="<%=request.getContextPath()%>/Clubs?c=${c.clubId}">
                            <div>
                                <img src="<%=request.getContextPath()%>/images/clubs/${c.clubPicture}" style="width:16px;height:16px">
                                <h2>${c.clubName}</h2>
                            </div>
                        </a>
                    </div>
                </c:forEach>


            </div>

        </div>
    </div>



    <div class="col-sm-9 col-md-8 col-lg-9" style="float: none;display: table-cell;vertical-align: top;width: 100%">
        <div class="row" style="background-color: #BD1418;min-height: 200px;border-bottom: #850E11 solid 5px;padding: 5% 0 0 2%;margin-bottom: 10px;">
            <div>
                <h1 style="font-size: 80px;"><c:out value="${clubs[0].clubLeagueName}"/></h1>
            </div>
        </div>

        <div class="row" style="float:left">
            <c:forEach var="p" items="${players}">
                <%@ include file="playerCard.jsp" %>
            </c:forEach>
        </div>


    </div>


</div>


<% }%>     



<jsp:include page="/footerIncludes.jsp"/>
