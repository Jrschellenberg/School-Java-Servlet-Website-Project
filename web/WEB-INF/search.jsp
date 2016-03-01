<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/headerIncludes.jsp" >
    <jsp:param name="title" value="Search" />
</jsp:include>


   <div class="container-fluid" style="margin: 30px 0 10px 0"> 
    <div class="row " style="display: table;margin: 0 auto;width:1000px">

        <div class="col-sm-4 col-md-8 col-lg-11" style="float: none;display: table-cell;vertical-align: top;">

            <div class="row">
                <c:forEach var="p" items="${playerValues}">
                    <%@ include file="playerCard.jsp" %>
                </c:forEach>
            </div>


        </div>

    </div>
</div>  



<jsp:include page="/footerIncludes.jsp"/>
