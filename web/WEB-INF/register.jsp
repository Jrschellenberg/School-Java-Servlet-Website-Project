<jsp:include page="/headerIncludes.jsp" >
    <jsp:param name="title" value="Register" />
</jsp:include>

<div class="container-fluid"> 

    <div class="text-center" style="background-color:#BE1418; border-top: #960C0F solid 5px;padding: 0 0 50px 0;width:100%;margin-top: 100px"> 

    </div>

    <div class="text-center" style="background-color:#BE1418;width:100%;border-bottom: #960C0F solid 5px;"> 
        <div style="margin: 0 auto;width:1000px">
            <br style="clear: left;" />


            <jsp:useBean id="vObj" type="beans.UserValues" scope="request" />
            <h2><jsp:getProperty name="vObj" property="msg" /></h2>

            <style>
                span.help-block.form-error { 
                    color: yellow;
                }
            </style>
            <form id="register" action="<%=request.getContextPath()%>/Register" method="POST">
                <div>
                    <label for="username">Username:</label>
                    <input type="text" name="username" id="username" size="20" data-validation="length" data-validation-length="2-30" />
                </div><br />
                <label for="Password">Password:</label>
                <input type="password" name="password" id="password" size="20" data-validation="length" data-validation-length="2-32" /><br />

                <input type="submit" name="action" value="Register" />
            </form>

            <br /><br />
            <br style="clear: left;" />

        </div>
    </div>
    <div class="text-center" style="background-color:#E8E8E8; border-bottom: #BABABA solid 5px;padding: 70px 0 10px 0;"> 

    </div>

</div>

<jsp:include page="/footerIncludes.jsp"/>
