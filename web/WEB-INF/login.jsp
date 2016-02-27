<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="/error.jsp" %>

<jsp:include page="/headerIncludes.jsp" >
    <jsp:param name="title" value="Login" />
</jsp:include>

<% 
    String s = "";
    if(request.getSession().getAttribute("username") !=null){
    s = request.getSession().getAttribute("username").toString();
}
 %>


    <div class="container-fluid"> 

            <div class="text-center" style="background-color:#BE1418; border-top: #960C0F solid 5px;padding: 0 0 50px 0;width:100%;margin-top: 100px"> 

            </div>

            <div class="text-center" style="background-color:#BE1418;width:100%;border-bottom: #960C0F solid 5px;"> 
                <div style="margin: 0 auto;width:1000px">
                    <br style="clear: left;" />
                   

                    
                    <jsp:useBean id="vObj" type="beans.UserValues" scope="request" />
                    <h2><jsp:getProperty name="vObj" property="msg" /></h2>
                    
 
                    
                    <% if(request.getSession().getAttribute("username") == null){ %>
                    <form id="login" action="<%=request.getContextPath()%>/Login" method="POST">
                        <div>
                        <label for="username">Username:</label>
                        <input type="text" name="username" id="username" size="20" value="<%out.write(s);%>"  />
                        </div><br />
                        <label for="Password">Password:</label>
                        <input type="password" name="password" id="password" size="20" /><br />


                        <input type="submit" name="action" id="action" value="Login" />
                    </form>
                    <%}%>
                    
                    <br /><br />
                    <br style="clear: left;" />
                    
                </div>
            </div>
            <div class="text-center" style="background-color:#E8E8E8; border-bottom: #BABABA solid 5px;padding: 70px 0 10px 0;"> 
                	
            </div>
            
    </div>



<jsp:include page="/footerIncludes.jsp"/>
