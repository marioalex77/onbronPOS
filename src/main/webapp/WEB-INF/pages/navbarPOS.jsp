<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: maguzman
  Date: 03/05/2017
  Time: 09:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="navbar navbar-static-top navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-inverse-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand"><spring:message code="application.name"/></a>
        </div>
        <div class="navbar-collapse collapse navbar-inverse-collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a class="dropdown-toggle tip" data-toggle="dropdown" href="#" data-placement="right" title="<spring:message code="application.language.title"/>">
                        <img src="<c:url value='/resources/images/english.png'/>" style="margin-top:-1px" align="middle">
                    </a>
                    <ul class="dropdown-menu" style="min-width: 60px;" role="menu" aria-labelledby="dLabel">
                        <li>
                            <a href="?lang=en">
                                <img src="<c:url value='/resources/images/english.png'/>" class="language-img">
                                 &nbsp;&nbsp; <spring:message code="application.language.english.title"/>
                            </a>
                            <a href="?lang=es">
                                <img src="<c:url value='/resources/images/spanish.png'/>" class="language-img">
                                &nbsp;&nbsp; <spring:message code="application.language.spanish.title"/>
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="http://demo.tecdiary.my/spos/index.php?module=settings" class="tip" data-placement="right" title="Home">
                        <i class="glyphicon glyphicon-home"></i>
                    </a>
                </li>
                <li>
                    <a href="http://demo.tecdiary.my/spos/index.php?module=settings&view=system_setting" class="tip" data-placement="right" title="Settings">
                        <i class="glyphicon glyphicon-cog"></i>
                    </a>
                </li>
                <li>
                    <a href="http://demo.tecdiary.my/spos/index.php?module=pos" class="tip" data-placement="right" title="POS Sale">
                        <i class="glyphicon glyphicon-th-large"></i>
                    </a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Hi, Admin! <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="http://demo.tecdiary.my/spos/index.php?module=auth&amp;view=change_password">Change Password</a></li>
                        <li><a href="http://demo.tecdiary.my/spos/index.php?module=auth&amp;view=logout">Logout</a></li>
                    </ul>
                </li>
            </ul>
            <div class="pull-right">
                <!--a href="http://codecanyon.net/item/simple-pos-point-of-sale-made-easy/3947976?ref=tecdiary"
                   class="tip btn btn-default btn-sm pull-left external"
                   style="padding:5px 8px; margin: 5px 5px 5px 5px;"
                   title="<strong>Liked?</strong> Let's Purchase<br><strong>Have Suggestion?</strong> Please send email to contact@tecdiary.com"
                   data-html="true" data-placement="bottom"> Buy Now </a-->
                <ul class="nav navbar-nav">
                    <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown">Products<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="index.php?module=products">List Products </a></li>
                            <li><a href="index.php?module=products&view=add">Add Product</a></li>
                            <li><a href="index.php?module=products&view=import">Import by CSV</a></li>
                            <li><a href="index.php?module=products&view=sheet">Print Barcode</a></li>
                            <li><a href="index.php?module=products&view=labels">Print Lablels</a></li>
                            <li class="divider"></li>
                            <li><a href="/categoria/list"><spring:message code="application.menu.products.listcategories"/></a></li>
                            <li><a href="index.php?module=products&view=add_category"> Add Category </a></li>
                        </ul>
                    </li>
                    <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown">Customers<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="index.php?module=customers">List Customers</a></li>
                            <li><a href="index.php?module=customers&view=add">Add Customer</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown">Sales<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="index.php?module=sales">List Sales</a></li>
                            <li><a href="index.php?module=sales&view=holded">List Opened Bills</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown">Reports<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="index.php?module=reports&view=daily_sales">Daily Sales</a></li>
                            <li><a href="index.php?module=reports&view=monthly_sales">Monthly Sales</a></li>
                            <li><a href="index.php?module=reports">Sales Reports</a></li>
                            <li class="divider"></li>
                            <li><a href="index.php?module=reports&view=top">Top Products</a></li>
                            <li><a href="index.php?module=reports&view=products">Products Reports</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>