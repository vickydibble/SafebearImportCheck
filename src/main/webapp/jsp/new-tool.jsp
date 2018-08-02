<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel="stylesheet" href="../css/bootstrap.min.css">   		
        <script src="../js/bootstrap.min.js"></script>
        <title>New Tool</title>
    </head>
    <body>
        <div class="container">
            <form action="/tools" method="post"  role="form" data-toggle="validator" >
                <c:if test ="${empty action}">                        	
                    <c:set var="action" value="add"/>
                </c:if>
                <input type="hidden" id="action" name="action" value="${action}">
                <input type="hidden" id="idTool" name="idTool" value="${tool.id}">
                <h2>Tool</h2>
                <div class="form-group col-xs-4">
                    <label for="name" class="control-label col-xs-4">Name:</label>
                    <input type="text" name="name" id="name" class="form-control" value="${tool.name}" required="true"/>

                    <label for="use" class="control-label col-xs-4">Use:</label>
                    <input type="text" name="use" id="use" class="form-control" value="${tool.use}" required="true"/>

                    <label for="website" class="control-label col-xs-4">Website:</label>
                    <input type="text" name="website" id="website" class="form-control" value="${tool.website}" placeholder="www.acme.com" required="true"/>

                    <br></br>
                    <button type="submit" class="btn btn-primary  btn-md">Accept</button> 
                </div>                                                      
            </form>
        </div>
    </body>
</html>