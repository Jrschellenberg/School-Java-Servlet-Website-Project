<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="/error.jsp" %>
<jsp:include page="/headerIncludes.jsp" >
    <jsp:param name="title" value="Admin" />
</jsp:include>



<div class="container-fluid"> 

    <div class="text-center" style="width:100%;margin: 100px 0 20px 0"> 

    </div>

    <div class="text-center" style="border-top: #960C0F solid 5px;padding: 10px 0 10px 0;background-color:#BE1418;width:100%;border-bottom: #960C0F solid 5px;"> 

        <div class="container">

            <div class="row" >
                <div class="col-md-3 adminButtonBackground">
                    <button class="admin" type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#removeUser">Remove User</button><br />
                    <button class="admin" type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#addUser">Add User</button><br />
                    <button class="admin" type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#retrievePassword">Retrieve User Pass</button><br />
                    <button class="admin" type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#addAdmin">Add Admin User</button><br />
                    <button class="admin" type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#removeAdmin">Remove Admin User</button>
                </div>

                <div class="col-md-3 adminButtonBackground">
                    <button class="admin" type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#addPlayer">Add Player</button><br />
                    <button class="admin" type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#editPlayer">Edit Player</button><br />
                    <button class="admin" type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#removePlayer">Remove Player</button><br />
                </div>

                <div class="col-md-3 adminButtonBackground">
                    <button class="admin" type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#addLeague">Add League</button><br />
                    <button class="admin" type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#removeLeague">Remove League</button>
                    <button class="admin" type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#addNation">Add Nation</button><br />
                    <button class="admin" type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#removeNation">Remove Nation</button>
                </div>

                <div class="col-md-2 adminButtonBackground">
                    <button class="admin" type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#addClub">Add Club</button><br />
                    <button class="admin" type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#editClub">Edit Club</button><br />
                    <button class="admin" type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#removeClub">Remove Club</button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="text-center" style="background-color:#E8E8E8; border-bottom: #BABABA solid 5px;padding: 5px 0 10px 0;margin-bottom: 20px"> 
    <jsp:useBean id="adminMessage" type="beans.AdminValues" scope="request"/>          

    <h2><jsp:getProperty name="adminMessage" property="msg" /></h2>
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