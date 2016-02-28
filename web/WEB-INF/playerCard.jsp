<div class="col-xs-6 col-sm-4 col-md-3 col-lg-15" style="width:166px;height:180px;">

    <div style="background: url(<%=request.getContextPath()%>/images/playerCard-U.png)  no-repeat;height:110px; width:155px;z-index:-1;">
        <!-- club background -->
        <div style="border-radius:0 33px 0 0;background: url(http://futhead.cursecdn.com/static/img/16/clubs/243.png)  no-repeat 16px -30px; opacity:0.2;height:120px; width:150px;background-size: 180px 180px;position:relative;top:1px;"></div>
    </div>

    <div style="position:absolute; top:20px; z-index:2;right:auto;left:10px;height:164px; width:155px;">

        <div class="text-center">

            <!-- player picture -->
            <img src="http://futhead.cursecdn.com/static/img/16/players/20801.png" style="width:90px;height:90px;"> 

            <!-- national_img -->
            <img src="http://futhead.cursecdn.com/static/img/16/nations/38.png" alt="" style="width:45px;height:45px">

        </div>

        <div style="height: 54px;background: url(<%=request.getContextPath()%>/images/playerCard-B.png) no-repeat center top ;" class="text-center">

            <!-- player name -->
            <a style="color:#4d4d4d;text-transform:capitalize;" href="<%=request.getContextPath()%>/Players?p=${p.playerId}" rel="bookmark"><strong>${p.playerName}</strong></a>

            <!-- player position -->
            <div style="font-size:14pt;color:#9f9f9f;text-transform:capitalize;">${p.playerPosition}</div>';

        </div>  
    </div>

</div>