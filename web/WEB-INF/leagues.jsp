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
                            <div class="col-xs-6 col-sm-4 col-md-3 col-lg-15" style="width:166px;height:180px;background-color:#960C0F; margin: 1px 0 1px 1px; ">
                                    <img src="http://3.bp.blogspot.com/-TppYKVyfGGk/VNqG7XoA-VI/AAAAAAAAn4w/mO6qyNl2yuo/s1600/Premier%2BLeague.png" style="width:128px;height:128px">
                                    <h1><a href="<%=request.getContextPath()%>/Leagues?l=${l.leagueId}">${l.leagueName}</a></h1> 
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
            <div style="font-size: 112px; color: #fff">
                <c:out value="${clubs[0].clubLeagueName}"/>
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
