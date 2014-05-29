<%@tag description="Layout for pages where user is not signed in" pageEncoding="UTF-8"%>
<%@attribute name="pageTitle" fragment="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="cs">
	<head>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="author" content="Drozd Radek" />
		<meta name="description" content="SLA Management Client - client for SLA management web service,  diploma thesis FIT BUT, 2014" />
		<meta name="keywords" content="SLA management, ITIL, Web Service" />
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value="/style/style.css" />">
		
		<!-- tinyMCE -->
		<script type="text/javascript" src="<c:url value="/js/tinymce/tinymce.min.js" />"></script>
		<script type="text/javascript">
		tinymce.init({
		    selector: "textarea",
		    setup: function(editor) {
		        editor.on('change', function(e) {
		            console.log('change event', e);
					tinyMCE.triggerSave();
					$("#" + editor.id).valid();
		        });
		    },
		    menubar : false,
		    plugins: "table autolink lists link ",
		    toolbar: "insertfile undo redo | styleselect | table | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link "
		 });
		</script>
		
		<!-- jQuery validation -->
		<script type="text/javascript" src="<c:url value="/js/jquery/jquery.js" />"></script>
		<script type="text/javascript" src="<c:url value="/js/validation/jquery.validate.min.js" />"></script>
		<script type="text/javascript">
		$().ready(function() {
			$("form").validate();

		});
		</script>

		<title><jsp:invoke fragment="pageTitle"/> | SLA Management Client</title>
	</head>
	<div id="wrapper">
  
    <div id="head">
      <h1 id="headline">SLA Management Client</h1>
      <h2 id="subtitle">Arrange your agreements</h2>
      
      <div id="user">
      	<span>
			${user.getLogin()} 
	      	[<a href="<c:url value="/logout"/>" title="Log me out">Log out</a>]
      	</span>
      	
      </div>
      
    </div>
    
    <ul id="menu">
    	<li>
    		<a href="<c:url value="/agreement/new"/>" title="Log me out">New agreement</a>
    	</li>
    	<li>
    		<a href="<c:url value="/agreement/list"/>" title="Log me out">Agreements</a>
    	</li>
    </ul>
    
    <div id="content">
		<jsp:doBody/>
    </div>
    
    <div id="footer">
    	<p>
    	Radek Drozd, Diploma thesis, BUT FIT 2014
    	</p>
    </div>
  </div>

</html>
