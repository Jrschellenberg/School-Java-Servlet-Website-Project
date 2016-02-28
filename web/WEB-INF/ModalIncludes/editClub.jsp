<%-- 
    Document   : editClub
    Created on : Feb 28, 2016, 3:38:21 PM
    Author     : Justin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div class="modal fade" id="editClub" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Add a Club</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" action="<%=request.getContextPath()%>/Admin" method="POST">


                    <div class="form-group">
                        <label for="addClubLeague" class="col-sm-6 control-label">Pick a Club:</label>
                        <div class="col-sm-6">
                            <select name="editClubName">
                                <c:forEach var="c" items="${clubs}">
                                    <option value="${c.clubName}">${c.clubName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>



                    <div class="form-group">
                        <label for="addClubLeague" class="col-sm-6 control-label">Pick a League Associated to the Club:</label>
                        <div class="col-sm-6">
                            <select name="editClubLeagueName">
                                <c:forEach var="l" items="${leagues}">
                                    <option value="${l.leagueName}">${l.leagueName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>



                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default" name="action" value="editClub">Continue</button>

                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

            </div>
        </div>
    </div>
</div>
<!-- Button Model End -->
