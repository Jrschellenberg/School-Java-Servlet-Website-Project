<%-- 
    Document   : addPlayer
    Created on : Feb 27, 2016, 3:07:09 PM
    Author     : Justin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div class="modal fade" id="addPlayer" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Add a Player (Must Enter all Fields)</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" action="<%=request.getContextPath()%>/Admin" method="POST">


                    <div class="form-group">
                        <label for="addPlayer" class="col-sm-6 control-label">Pick a Nation:</label>
                        <div class="col-sm-6">
                            <select name="addPlayerNation">
                                <c:forEach var="n" items="${nations}">
                                    <option value="${n.nationName}">${n.nationName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="addPlayer" class="col-sm-6 control-label">Pick a Club:</label>
                        <div class="col-sm-6">
                            <select name="addPlayerClub">
                                <c:forEach var="c" items="${clubs}">
                                    <option value="${c.clubName}">${c.clubName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="playerName" class="col-sm-6 control-label">Enter Players First Name:</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="playerName" name="addPlayerFirstName" placeholder="Player Name" data-validation="length" data-validation-length="2-12">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="playerName" class="col-sm-6 control-label">Enter Players Last Name:</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="playerName" name="addPlayerLastName" placeholder="Player Name" data-validation="length" data-validation-length="2-18">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="playerDate" class="col-sm-6 control-label">Enter Players Birthday (yyyy-mm-dd):</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="playerDate" name="addPlayerDate" placeholder="Birthday" data-validation="date" data-validation-format="yyyy-mm-dd">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="addPlayer" class="col-sm-6 control-label">Player Position:</label>
                        <div class="col-sm-6">
                            <select name="addPlayerPosition">
                                <option value="Attacker">Attacker</option>
                                <option value="Midfielder">Midfielder</option>
                                <option value="Defender">Defender</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="playerHeight" class="col-sm-6 control-label">Enter Players Height in Centimeters (120-260):</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="playerHeight" name="addPlayerHeight" placeholder="Height" data-validation="number" data-validation-allowing="range[120;260]">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="playerNumber" class="col-sm-6 control-label">Enter Players Number (1-100):</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="playerNumber" name="addPlayerNumber" placeholder="Player Number" data-validation="number" data-validation-allowing="range[1;100]">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="addPlayer" class="col-sm-6 control-label">Players Foot:</label>
                        <div class="col-sm-6">
                            <select name="addPlayerFoot">
                                <option value="Left">Left</option>
                                <option value="Right">Right</option>
                                <option value="Both">Both</option>
                            </select>
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default" name="action" value="addPlayer">Continue</button>

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