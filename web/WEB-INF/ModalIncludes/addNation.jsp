<%-- 
    Document   : addNation
    Created on : Feb 28, 2016, 1:10:52 PM
    Author     : Justin
--%>
<script type= "text/javascript" src = "<%=request.getContextPath()%>/js/countries.js"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div class="modal fade" id="addNation" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Remove a League</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" action="<%=request.getContextPath()%>/Admin" method="POST">

                    <div class="form-group">
                        <label for="removeLeague" class="col-sm-6 control-label">Pick a Nation to Add:</label>
                        <div class="col-sm-6">
                            <select id="country2" name="addNationName"></select>
                            <script language="javascript">
                                populateCountries("country2");
                            </script>
                        </div>
                    </div>



                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default" name="action" value="addNation">Continue</button>

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
