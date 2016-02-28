<%-- 
    Document   : admin
    Created on : Feb 26, 2016, 10:48:38 AM
    Author     : Justin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="/error.jsp" %>
<jsp:include page="/headerIncludes.jsp" >
    <jsp:param name="title" value="Admin" />
</jsp:include>



<div class="container-fluid"> 

    <div class="text-center" style="background-color:#BE1418; border-top: #960C0F solid 5px;padding: 0 0 50px 0;width:100%;margin-top: 100px"> 

    </div>

    <div class="text-center" style="background-color:#BE1418;width:100%;border-bottom: #960C0F solid 5px;"> 
        <div style="margin: 0 auto;width:1000px">
            <jsp:useBean id="adminMessage" type="beans.AdminValues" scope="request"/>          
            <br style="clear: left;" />
            <h2><jsp:getProperty name="adminMessage" property="msg" /></h2>
            <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#removeUser">
                Remove User
            </button>
            <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#addUser">
                Add User
            </button>
            <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#retrievePassword">
                Retrieve User Pass
            </button>
            <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#addAdmin">
                Add Admin User
            </button>
            <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#removeAdmin">
                Remove Admin User
            </button>
            <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#addPlayer">
                Add Player
            </button>
            <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#editPlayer">
                Edit Player
            </button>
            <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#removePlayer">
                Remove Player
            </button>
            <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#addLeague">
                Add League
            </button>
            <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#removeLeague">
                Remove League
            </button>
            <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#addNation">
                Add Nation
            </button>
            <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#removeNation">
                Remove Nation
            </button>
            <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#addClub">
                Add Club
            </button>
            <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#editClub">
                Edit Club
            </button>
            <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#removeClub">
                Remove Club
            </button>





            <br /><br />
            <br style="clear: left;" />

        </div>
    </div>
    <div class="text-center" style="background-color:#E8E8E8; border-bottom: #BABABA solid 5px;padding: 70px 0 10px 0;"> 

    </div>

</div>
<jsp:include page="/WEB-INF/ModalIncludes/removeUser.jsp" ></jsp:include>
<jsp:include page="/WEB-INF/ModalIncludes/removeAdmin.jsp" ></jsp:include>
<jsp:include page="/WEB-INF/ModalIncludes/addAdmin.jsp" ></jsp:include>
<jsp:include page="/WEB-INF/ModalIncludes/getUserPassword.jsp" ></jsp:include>
<jsp:include page="/WEB-INF/ModalIncludes/addUser.jsp" ></jsp:include>
<jsp:include page="/WEB-INF/ModalIncludes/addPlayer.jsp" ></jsp:include>
<jsp:include page="/WEB-INF/ModalIncludes/editPlayer.jsp" ></jsp:include>
<jsp:include page="/WEB-INF/ModalIncludes/removePlayer.jsp" ></jsp:include>
<jsp:include page="/WEB-INF/ModalIncludes/addLeague.jsp" ></jsp:include>
<jsp:include page="/WEB-INF/ModalIncludes/removeLeague.jsp" ></jsp:include>
<jsp:include page="/WEB-INF/ModalIncludes/addNation.jsp" ></jsp:include>
<jsp:include page="/WEB-INF/ModalIncludes/removeNation.jsp" ></jsp:include>
<jsp:include page="/WEB-INF/ModalIncludes/addClub.jsp" ></jsp:include>
<jsp:include page="/WEB-INF/ModalIncludes/editClub.jsp" ></jsp:include>
<jsp:include page="/WEB-INF/ModalIncludes/removeClub.jsp" ></jsp:include>

<jsp:include page="/footerIncludes.jsp"/>