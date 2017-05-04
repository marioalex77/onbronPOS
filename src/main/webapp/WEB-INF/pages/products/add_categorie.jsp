<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <!--<base href="http://demo.tecdiary.my/spos/" />-->
        <title>Add New Category | <spring:message code="application.name"/></title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="shortcut icon" href="<c:url value='/resources/images/favicon.ico'/>"/>
        <link rel="stylesheet" href="<c:url value='/resources/css/bootstrapPOS.css'/>" type="text/css" charset="utf-8">
        <link rel="stylesheet" href="<c:url value='/resources/css/datatables.css'/>" type="text/css">
        <link rel="stylesheet" href="<c:url value='/resources/css/dash.css'/>" type="text/css">
        <link rel="stylesheet" href="<c:url value='/resources/css/non-responsive.css'/>" type="text/css">
        <script src="<c:url value='/resources/js/jquery-1.7.2.min.js'/>"></script>
        <script type="text/javascript">
        $(document).ready(function() {
            $('.tip').tooltip();
            $('.alert').click(function(){ $(this).fadeTo(500, 0).slideUp(500, function(){ $(this).remove(); }); });
            window.setTimeout(function() { $(".alert").fadeTo(500, 0).slideUp(500, function(){ $(this).remove(); }); }, 8000);
        });
        </script>
    </head>
    <body>
        <div id="wrap">
            <jsp:include page="../navbarPOS.jsp"/>
            <div class="container">
                <h3>Add New Category</h3>
                <p>Please enter the information below.</p>
                <form:form action="/categoria/guardar" method="POST" modelAttribute="categoria">
                    <div style="display:none">
                        <form:input type="hidden" path="idCategoria" id="idCategoria"/>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label for="name" class="control-label">Name</label>
                                <form:input path="nombre" id="nombre" class="form-control input-sm"/>
                                <form:errors path="salary" cssClass="error"/>
                                <div class="inline-help">Please enter the name of Category</div>
                            </div>
                        </div>
                    </div>
                    <input type="submit" name="submit" value="Add New Category" class="btn btn-primary btn-sm" />
                </form:form>
            </div>
            <jsp:include page="../footerPOS.jsp"/>
        </div>
        <script type="text/javascript" src="<c:url value='/resources/js/bootstrapPOS.min.js'/>"></script>
        <script src="<c:url value='/resources/js/bootstrap-prettyfile.js'/>"></script>
        <script src="<c:url value='/resources/js/bootstrap-datepicker.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/resources/js/jquery.dataTables.min.js'/>"></script>
        <script type="text/javascript" charset="utf-8" src="<c:url value='/resources/js/ZeroClipboard.js'/>"></script>
        <script type="text/javascript" charset="utf-8" src="<c:url value='/resources/js/TableTools.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/resources/js/DT_bootstrap.js'/>"></script>
    </body>
</html>
