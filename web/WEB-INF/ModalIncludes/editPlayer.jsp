<%-- 
    Document   : editPlayer
    Created on : Feb 27, 2016, 10:45:04 PM
    Author     : Justin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div class="modal fade" id="editPlayer" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Edit a Player (Must Enter all Fields)</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" action="<%=request.getContextPath()%>/Admin" method="POST">



                    <div class="form-group">
                        <label for="addPlayer" class="col-sm-6 control-label">Player to Edit:</label>
                        <div class="col-sm-6">
                            <select name="editPlayerName">
                                <c:forEach var="p" items="${players}">
                                    <option value="${p.playerName}">${p.playerName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="editPlayer" class="col-sm-6 control-label">Pick a Nation:</label>
                        <div class="col-sm-6">
                            <select name="editPlayerNation">
                                <c:forEach var="n" items="${nations}">
                                    <option value="${n.nationName}">${n.nationName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="editPlayer" class="col-sm-6 control-label">Pick a Club:</label>
                        <div class="col-sm-6">
                            <select name="editPlayerClub">
                                <c:forEach var="c" items="${clubs}">
                                    <option value="${c.clubName}">${c.clubName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="playerDate" class="col-sm-6 control-label">Enter Players Birthday (yyyy-mm-dd):</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="playerDate" name="editPlayerDate" placeholder="Birthday" data-validation="date" data-validation-format="yyyy-mm-dd">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="addPlayer" class="col-sm-6 control-label">Player Position:</label>
                        <div class="col-sm-6">
                            <select name="editPlayerPosition">
                                <option value="Attacker">Attacker</option>
                                <option value="Midfielder">Midfielder</option>
                                <option value="Defender">Defender</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="playerHeight" class="col-sm-6 control-label">Enter Players Height in Centimeters (120-260):</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="playerHeight" name="editPlayerHeight" placeholder="Height" data-validation="number" data-validation-allowing="range[120;260]">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="playerNumber" class="col-sm-6 control-label">Enter Players Number (1-100):</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="playerNumber" name="editPlayerNumber" placeholder="Player Number" data-validation="number" data-validation-allowing="range[1;100]">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="addPlayer" class="col-sm-6 control-label">Players Foot:</label>
                        <div class="col-sm-6">
                            <select name="editPlayerFoot">
                                <option value="Left">Left</option>
                                <option value="Right">Right</option>
                                <option value="Both">Both</option>
                            </select>
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default" name="action" value="editPlayer">Continue</button>

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