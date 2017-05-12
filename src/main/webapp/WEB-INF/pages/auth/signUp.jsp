<%--
  Created by IntelliJ IDEA.
  User: maguzman
  Date: 12/05/2017
  Time: 09:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, maximum-scale=1, initial-scale=1, user-scalable=0">
    <meta charset="utf-8">
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <title><spring:message code="signUp.title"/> | <spring:message code="application.name"/></title>
    <link rel="shortcut icon" href="<c:url value='/resources/images/favicon.ico'/>"/>
    <link rel="stylesheet" href="<c:url value='/resources/css/bootstrapPOS.css'/>" type="text/css" media="screen" charset="utf-8">
    <script type="text/javascript" src="<c:url value='/resources/js/jquery.min.js'/>"></script>
    <style>
        .container {
            width: 100%;
            max-width: 100%;
        }
        .container.padded > .row {
            margin: 0;
        }
        .padded {
            padding: 15px;
        }
        .separate-sections {
            margin: 0;
            list-style: none;
            padding-bottom: 5px;
        }
        .separate-sections > li, .separate-sections > div {
            margin-bottom: 15px !important;
        }
        .separate-sections > li:last-child, .separate-sections > div:last-child {
            margin-bottom: 0px;
        }
        i {
            margin: 0 10px;
        }
    </style>
</head>
<body>
    <spring:url value="/registrarse" var="actionUrl" />
    <spring:url value="/login" var="login" />
    <spring:url value="/" var="home" />
    <div class="container">
        <div class="col-md-4 col-md-offset-4" id="login-box">
            <div class="padded" style="text-align:center;margin-top: 40px;">
                <img src="<c:url value='/resources/images/logo.png'/>" alt="Mario's Bistro POS"/>
                <div class="panel panel-warning" style="margin-top: 20px;">
                    <div class="panel-heading"><spring:message code='signUp.container.title'/></div>
                    <div class="panel-body" style="padding-bottom:0;">
                        <form action="${actionUrl}" method="post" accept-charset="utf-8" class="separate-sections">
                            <div class="input-group">
                                <span class="input-group-addon">
                                    <i class="glyphicon glyphicon-envelope"></i>
                                </span>
                                <input type="email" name="correo" class="form-control" placeholder="Email" />
                            </div>
                            <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="glyphicon glyphicon-lock"></i>
                                        </span>
                                <input type="password" name="password" class="form-control" placeholder="Password" />
                            </div>
                            <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="glyphicon glyphicon-lock"></i>
                                        </span>
                                <input type="password" name="confirmpassword" class="form-control" placeholder="ConfirmPassword" />
                            </div>
                            <div class="input-group">
                                 <span class="input-group-addon">
                                        <i class="glyphicon glyphicon-user"></i>
                                 </span>
                                <input type="email" name="correo" class="form-control" placeholder="Nombres" />
                            </div>
                            <div class="input-group">
                                 <span class="input-group-addon">
                                        <i class="glyphicon glyphicon-user"></i>
                                 </span>
                                <input type="email" name="correo" class="form-control" placeholder="Primer Apellido" />
                            </div>
                            <div class="input-group">
                                 <span class="input-group-addon">
                                        <i class="glyphicon glyphicon-user"></i>
                                 </span>
                                <input type="email" name="correo" class="form-control" placeholder="Segundo Apellido" />
                            </div>
                            <div class="input-group">
                                 <span class="input-group-addon">
                                        <i class="glyphicon glyphicon-user"></i>
                                 </span>
                                <input type="email" name="correo" class="form-control" placeholder="Genero" />
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <button type="submit" class="btn btn-success btn-block">
                                        <spring:message code='signUp.submit'/> <i class="glyphicon glyphicon-floppy-saved"></i>
                                    </button>
                                </div>
                                <div class="col-md-12">
                                    <a href="${login}" class="btn btn-default btn-block">
                                        <i class="glyphicon glyphicon-log-in"></i><spring:message code='signUp.cancelar'/></a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">&copy; 2017 <spring:message code="application.company"/> <a href="#" class="btn btn-primary btn-block"><i class="glyphicon glyphicon-hand-right"></i> Facebook</a> </div>
                </div>
            </div>
        </div>
    </div>
    <script src="http://demo.tecdiary.my/spos/assets/js/jquery-ui.min.js"></script>
</body>
</html>
