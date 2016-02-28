<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/headerIncludes.jsp" >
    <jsp:param name="title" value="Leagues" />
</jsp:include>



<% if (request.getParameter("l") == null) {%>
Leagues:
<c:forEach var="l" items="${leagues}">
    <h1><a href="<%=request.getContextPath()%>/Leagues?l=${l.leagueId}">${l.leagueName}</a></h1>
    </c:forEach>

<% } else {%>

<div class="row container" style="display: table;">
    <div class="col-sm-3 col-md-4 col-lg-3" style="color:#fff;height:100%;;background-color: #2E2E2E;float: none;display: table-cell;vertical-align: top;">
        <div class="row text-center" style="height: 260px;border-bottom: #BD1418 solid 5px;background-color: #fff">   
            <!-- league pic -->
            <img src="http://3.bp.blogspot.com/-TppYKVyfGGk/VNqG7XoA-VI/AAAAAAAAn4w/mO6qyNl2yuo/s1600/Premier%2BLeague.png" style="width:256px;height:256px">
        </div>


        <div class="row" style="border-left: #515151 solid 0px">

            <!-- Clubs Table -->
            <div class="table-responsive">

                <table class="table" style="font-size: 10pt;">
                    <tr class="first">
                        <td>Clubs</td>
                    </tr>

                    <c:forEach var="c" items="${clubs}">
                        <tr>
                            <td class="second"><a href="<%=request.getContextPath()%>/Clubs?c=${c.clubId}">${c.clubName}</a></td>
                        </tr>
                    </c:forEach>

                </table>
            </div>

        </div>
    </div>



    <div class="col-sm-9 col-md-8 col-lg-9" style="float: none;display: table-cell;vertical-align: top;">
        <div class="row" style="background-color: #BD1418;min-height: 260px;border-bottom: #850E11 solid 5px;padding: 5% 0 0 5%;margin-bottom: 10px;">
            <div style="font-size: 92px; color: #fff">League Name</div>
        </div>

        <div class="row" style="float:left">
            <c:forEach var="p" items="${players}">
                <!-- players cards -->
                <div class="col-xs-6 col-sm-4 col-md-3 col-lg-15" style="width:166px;height:180px;">

                    <div style="background: url(<%=request.getContextPath()%>/images/playerCard-U.png)  no-repeat;height:110px; width:155px;z-index:-1;">
                        <!-- club background -->
                        <div style="border-radius:0 33px 0 0;background: url(http://futhead.cursecdn.com/static/img/16/clubs/243.png)  no-repeat 16px -30px; opacity:0.2;height:120px; width:150px;background-size: 180px 180px;position:relative;top:1px;"></div>
                    </div>

                    <div style="position:absolute; top:20px; z-index:2;right:auto;left:10px;height:164px; width:155px;">

                        <div class="text-center">

                            <!-- player picture -->
                            <img src="http://futhead.cursecdn.com/static/img/16/players/20801.png" style="width:90px;height:90px;"> 

                            <!-- national_img -->
                            <img src="http://futhead.cursecdn.com/static/img/16/nations/38.png" alt="" style="width:45px;height:45px">

                        </div>

                        <div style="height: 54px;background: url(<%=request.getContextPath()%>/images/playerCard-B.png) no-repeat center top ;" class="text-center">

                            <!-- player name -->
                            <a style="color:#4d4d4d;text-transform:capitalize;" href="<%=request.getContextPath()%>/Players?p=${p.playerId}" rel="bookmark"><strong>${p.playerName}</strong></a>

                            <!-- player position -->
                            <div style="font-size:14pt;color:#9f9f9f;text-transform:capitalize;">${p.playerPosition}</div>';

                        </div>  
                    </div>

                </div>
            </c:forEach>

        </div>


    </div>


</div>


<% }%>     



<jsp:include page="/footerIncludes.jsp"/>
