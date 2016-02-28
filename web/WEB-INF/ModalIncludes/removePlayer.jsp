<%-- 
    Document   : removePlayer
    Created on : Feb 28, 2016, 1:14:54 AM
    Author     : Justin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div class="modal fade" id="removePlayer" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Remove Player</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" action="<%=request.getContextPath()%>/Admin" method="POST">
                    
                    

                    <div class="form-group">
                        <label for="removePlayer" class="col-sm-6 control-label">Player to Edit:</label>
                        <div class="col-sm-6">
                            <select name="removePlayer">
                                <c:forEach var="p" items="${players}">
                                    <option value="${p.playerName}">${p.playerName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default" name="action" value="removePlayer">Continue</button>

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
