<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/headerIncludes.jsp" >
    <jsp:param name="title" value="Players" />
</jsp:include>

<% if (request.getParameter("p") == null) {%>

<div class="container-fluid" style="margin: 30px 0 10px 0"> 

    <div class="row " style="display: table;">

        <div class="col-sm-9 col-md-8 col-lg-11" style="float: none;display: table-cell;vertical-align: top;">

            <div class="row">
                <c:forEach var="p" items="${allplayers}">
                    <%@ include file="playerCard.jsp" %>
                </c:forEach>
            </div>


        </div>

    </div>
</div>    


<% } else {%>
<br /><br />
<jsp:useBean id="playerValues" type="beans.PlayerValues" scope="request" />
<div class="container">

    <div class="row">

        <div class="col-md-2 text-right">
            <img src="<%=request.getContextPath()%>/images/players/<jsp:getProperty name="playerValues" property="playerPicture" />" style="position: relative;z-index:101;bottom: -25px;left:4%;width:100px;height:100px">
        </div>

        <div class="col-md-6">
            <h1 class="single-title" style="position: relative;top:35px">
                <img src="<%=request.getContextPath()%>/images/nations/<jsp:getProperty name="playerValues" property="playerNationPicture" />" alt="" style="width:45px;height:25px">
                <jsp:getProperty name="playerValues" property="playerName" />
            </h1>
        </div>

        <div class="col-md-3">
            <ul class="nav nav-tabs" style="position: relative;top:58px">  
                <li class="active career"><a href="#about" role="tab" data-toggle="tab">About</a></li>
                <li class="career"><a href="#career" role="tab" data-toggle="tab">Career</a></li>
                <li class="career" ><a href="#news" role="tab" data-toggle="tab">News</a></li>

            </ul>
        </div>

    </div>
</div> 

<div style="background-color: #fff;padding:10px;border-bottom: #BD1418 solid 5px;border-top: #BD1418 solid 8px;position: relative;z-index:100;"> 
    <div class="container" style="padding: 0;">
        <div style="position: relative;top:-18px;left:4%;background: url(<%=request.getContextPath()%>/images/player-background.jpg) no-repeat;height:37px; width:160px;"></div>
        <div class="row">
            <div class="col-md-3 text-center">   
                <img src="<%=request.getContextPath()%>/images//clubs/<jsp:getProperty name="playerValues" property="playerClubPicture" />" style="width:225px;height:225px">
            </div>
            <div class="col-md-9 tab-content">
                <div class="row tab-pane fade in active" id="about">

                    <div class="row" style="padding-bottom:1px;border-bottom: #E7E7E7 solid 1px;margin: 0px 0 20px 0;">
                        <div class="col-md-6">Club: <jsp:getProperty name="playerValues" property="playerClub" /></div>
                        <div class="col-md-6">Nation: <jsp:getProperty name="playerValues" property="playerNation" /></div>
                    </div>

                    <div class="row" style="padding-bottom:1px;border-bottom: #E7E7E7 solid 1px;margin: 10px 0 20px 0;">
                        <div class="col-md-6">BirthDay: <jsp:getProperty name="playerValues" property="playerBirthday" /></div>
                        <div class="col-md-6">Position: <jsp:getProperty name="playerValues" property="playerPosition" /></div>
                    </div>

                    <div class="row" style="padding-bottom:1px;border-bottom: #E7E7E7 solid 1px;margin: 10px 0 20px 0;">
                        <div class="col-md-6">Number: <jsp:getProperty name="playerValues" property="playerNumber" /></div>
                        <div class="col-md-6">Height: <jsp:getProperty name="playerValues" property="playerHeight" /></div>
                    </div>

                    <div class="row" style="padding-bottom:1px;border-bottom: #E7E7E7 solid 1px;margin: 10px 0 20px 0;">
                        <div class="col-md-6">Foot: <jsp:getProperty name="playerValues" property="playerFoot" /></div>
                        
                    </div>

                </div> 

                <div class="row tab-pane fade" id="career">
                    <div class="row" style="padding-bottom:1px;border-bottom: #E7E7E7 solid 1px;margin: 0px 0 20px 0;">Career Coming Soon !</div>
                </div>

                <div class="row tab-pane fade" id="news">
                    <div class="row" style="padding-bottom:1px;border-bottom: #E7E7E7 solid 1px;margin: 0px 0 20px 0;">
                        News Coming Soon !
                        <!-- <jsp:getProperty name="playerValues" property="playerPicture" /> -->


                    </div>
                </div>

            </div>
        </div>
    </div>
</div>


<c:forEach var="comments" items="${allcomments}">
    <div>
        ${comments.commentText} <br> ${comments.commentDate} <br> ${comments.userName}
    </div>

    <c:choose>

        <c:when test="${sessionScope.admin != null}">
            <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#editComment${comments.commentId}">
                Edit Comment
            </button>
            <form action="<%=request.getContextPath()%>/Players?p=<%out.write(request.getAttribute("player").toString());%>" method="POST" >
                <input type="hidden" name="removeCommentId" id="username" size="20" value="${comments.commentId}" />
                <input class="btn btn-default navbar-btn" type="submit" name="action" value="Remove" />
            </form>
            <jsp:include page="/WEB-INF/ModalIncludes/editComment.jsp" >
                <jsp:param name="p" value="${player}" />
                <jsp:param name="id" value="${comments.commentId}" />
            </jsp:include>

        </c:when>
        <c:when test="${sessionScope.username == comments.userName}">   
            <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#editComment${comments.commentId}">
                Edit Comment
            </button>
            <form action="<%=request.getContextPath()%>/Players?p=<%out.write(request.getAttribute("player").toString());%>" method="POST" >
                <input type="hidden" name="removeCommentId" id="username" size="20" value="${comments.commentId}" />
                <input class="btn btn-default navbar-btn" type="submit" name="action" value="Remove" />
            </form>
            <jsp:include page="/WEB-INF/ModalIncludes/editComment.jsp" >
                <jsp:param name="p" value="${player}" />
                <jsp:param name="id" value="${comments.commentId}" />
            </jsp:include>
        </c:when>
    </c:choose>


</c:forEach>



<%if (request.getSession().getAttribute("username") != null) {%>
<button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#addComment">
    Leave a Comment
</button>
<jsp:include page="/WEB-INF/ModalIncludes/addComment.jsp" >
    <jsp:param name="p" value="${player}" />
</jsp:include>


<%}%>






<% }%>

<jsp:include page="/footerIncludes.jsp"/>