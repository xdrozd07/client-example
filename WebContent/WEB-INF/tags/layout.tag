<%@tag description="Layout for pages where user is not signed in" pageEncoding="UTF-8"%>
<%@attribute name="pageTitle" fragment="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="cs">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="author" content="Drozd Radek" />
		<meta name="description" content="SLA Management Client - client for SLA management web service,  diploma thesis FIT VUT, 2014" />
		<meta name="keywords" content="SLA management, ITIL, Web Service" />
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value="/style/style.css" />">
		<title><jsp:invoke fragment="pageTitle"/> | SLA Management Client</title>
		
		<!-- jQuery validation -->
		<script type="text/javascript" src="<c:url value="/js/jquery/jquery.js" />"></script>
		<script type="text/javascript" src="<c:url value="/js/validation/jquery.validate.min.js" />"></script>
		<script type="text/javascript">
		$().ready(function() {
			$("form").validate();
			
		});
		</script>
		
	</head>
	<div id="wrapper">
  
    <div id="head">
      <h1 id="headline">SLA Management Client</h1>
      <h2 id="subtitle">Arrange your agreements</h2>
    </div>
    
    <div id="content">
		<jsp:doBody/>
    </div>
    
    <div id="footer">
    	<p>
    	Author: Radek Drozd, Diploma thesis, BUT FIT 2014
    	</p>
    </div>
  </div>

</html>
