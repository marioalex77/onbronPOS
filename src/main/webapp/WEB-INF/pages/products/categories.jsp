<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<base href="http://demo.tecdiary.my/spos/" />
<title>Categories | Simple POS</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href="<c:url value='/resources/images/favicon.ico'/>" rel="shortcut icon"/>
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>" type="text/css" charset="utf-8">
<link rel="stylesheet" href="<c:url value='/resources/css/datatables.css'/>" type="text/css">
<link rel="stylesheet" href="http://demo.tecdiary.my/spos/assets/css/dash.css" type="text/css">
<link rel="stylesheet" href="http://demo.tecdiary.my/spos/assets/css/non-responsive.css" type="text/css">
<script src="http://demo.tecdiary.my/spos/assets/js/jquery-1.7.2.min.js"></script>
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
    <%@ include file="../navbarPOS.jsp"/>
    <div class="container">
	    <h3>Categories</h3>
	    <p class="introtext">Please use the table below to navigate or filter the results. You can download the table as csv, excel and pdf.</p>
	
	    <table id="fileData" class="table table-striped table-bordered table-condensed table-hover" style="margin-bottom:5px;">
		    <thead>
                <tr class="active">
                    <th style="width:55px;">No.</th>
                    <th>Name</th>
                    <th style="width:45px;">Actions</th>
                </tr>
            </thead>
		    <tbody>
				<tr>
                    <td>1</td>
                    <td>Fast Food</td>
                    <td><center><div class="btn-group"><a href="index.php?module=products&view=edit_category&id=1" class="tip btn btn-warning btn-xs" title="Update Category"><i class="glyphicon glyphicon-edit"></i></a> <a href="index.php?module=products&view=delete_category&id=1" onClick="return confirm('You are going to remove this category. Press OK to proceed and Cancel to Go Back')" class="tip btn btn-danger btn-xs" title="<em>delete_category</em>"><i class="glyphicon glyphicon-trash"></i></a></div></center></td>
			    </tr>
				<tr>
                    <td>2</td>
                    <td>Tea Time</td>
                    <td><center><div class="btn-group"><a href="index.php?module=products&view=edit_category&id=2" class="tip btn btn-warning btn-xs" title="Update Category"><i class="glyphicon glyphicon-edit"></i></a> <a href="index.php?module=products&view=delete_category&id=2" onClick="return confirm('You are going to remove this category. Press OK to proceed and Cancel to Go Back')" class="tip btn btn-danger btn-xs" title="<em>delete_category</em>"><i class="glyphicon glyphicon-trash"></i></a></div></center></td>
			    </tr>
				<tr>
                    <td>3</td>
                    <td>Dinner & Lunch</td>
                    <td><center><div class="btn-group"><a href="index.php?module=products&view=edit_category&id=3" class="tip btn btn-warning btn-xs" title="Update Category"><i class="glyphicon glyphicon-edit"></i></a> <a href="index.php?module=products&view=delete_category&id=3" onClick="return confirm('You are going to remove this category. Press OK to proceed and Cancel to Go Back')" class="tip btn btn-danger btn-xs" title="<em>delete_category</em>"><i class="glyphicon glyphicon-trash"></i></a></div></center></td>
			    </tr>
            	<tr>
                    <td>4</td>
                    <td>South Indian</td>
                    <td><center><div class="btn-group"><a href="index.php?module=products&view=edit_category&id=4" class="tip btn btn-warning btn-xs" title="Update Category"><i class="glyphicon glyphicon-edit"></i></a> <a href="index.php?module=products&view=delete_category&id=4" onClick="return confirm('You are going to remove this category. Press OK to proceed and Cancel to Go Back')" class="tip btn btn-danger btn-xs" title="<em>delete_category</em>"><i class="glyphicon glyphicon-trash"></i></a></div></center></td>
			    </tr>
            	<tr>
				    <td>5</td>
                    <td>Maharashtian Nashta</td>
                    <td><center><div class="btn-group"><a href="index.php?module=products&view=edit_category&id=5" class="tip btn btn-warning btn-xs" title="Update Category"><i class="glyphicon glyphicon-edit"></i></a> <a href="index.php?module=products&view=delete_category&id=5" onClick="return confirm('You are going to remove this category. Press OK to proceed and Cancel to Go Back')" class="tip btn btn-danger btn-xs" title="<em>delete_category</em>"><i class="glyphicon glyphicon-trash"></i></a></div></center></td>
			    </tr>
                <tr>
                    <td>6</td>
                    <td>June</td>
                    <td><center><div class="btn-group"><a href="index.php?module=products&view=edit_category&id=6" class="tip btn btn-warning btn-xs" title="Update Category"><i class="glyphicon glyphicon-edit"></i></a> <a href="index.php?module=products&view=delete_category&id=6" onClick="return confirm('You are going to remove this category. Press OK to proceed and Cancel to Go Back')" class="tip btn btn-danger btn-xs" title="<em>delete_category</em>"><i class="glyphicon glyphicon-trash"></i></a></div></center></td>
			    </tr>
            </tbody>
	    </table>
		<p><a href="http://demo.tecdiary.my/spos/index.php?module=products&view=add_category" class="btn btn-primary btn-sm">Add New Category</a></p>
    </div>
</div>
<div id="footer">
  <div class="container">
    <p class="credit">Copyright &copy; 2017 Simple POS v3.0 - Page rendered in 0.0173 seconds. 
    <a href="http://tecdiary.net/support/sma-guide/" target="_blank" class="tip" title="Help"><i class="icon-question-sign"></i></a>
    </p>   
  </div>
</div>
<script type="text/javascript" src="http://demo.tecdiary.my/spos/assets/js/bootstrap.min.js"></script>
<script src="http://demo.tecdiary.my/spos/assets/js/bootstrap-prettyfile.js"></script> 
<script src="http://demo.tecdiary.my/spos/assets/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.dataTables.min.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="http://demo.tecdiary.my/spos/assets/media/js/ZeroClipboard.js"></script> 
<script type="text/javascript" charset="utf-8" src="http://demo.tecdiary.my/spos/assets/media/js/TableTools.min.js"></script> 
<script type="text/javascript" src="http://demo.tecdiary.my/spos/assets/js/DT_bootstrap.js"></script>
   
</body>
</html>
