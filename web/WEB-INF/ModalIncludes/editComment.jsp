<%-- 
    Document   : editComment
    Created on : Feb 29, 2016, 5:38:16 PM
    Author     : Justin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div class="modal fade" id="editComment<%out.write(request.getParameter("id"));%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Leave a Comment</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" action="<%=request.getContextPath()%>/Players?p=<%out.write(request.getParameter("p"));%>" method="POST">


                    <div class="form-group">
                        <label for="addClubName" class="col-sm-6 control-label">Leave a Comment:</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="addLeagueName" name="editComment" placeholder="Leave a Comment" data-validation="length" data-validation-length="max21845">
                        </div>
                    </div>
                    <input type="hidden" class="form-control" id="addLeagueName" name="editCommentId" value="<%out.write(request.getParameter("id"));%>">





                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default" name="action" value="editComment">Continue</button>

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
