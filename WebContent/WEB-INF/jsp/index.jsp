<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
    <jsp:attribute name="pageTitle">Entering page</jsp:attribute>
    
    <jsp:body>
    	
    	<c:if  test="${message != null}">
    		<div class="message-error">
    			${message}
    		</div>
    	</c:if>
    	
    	<h2>Welcome!</h2>
		
		<c:url value="/login" var="formAction"/>
		<form:form method="POST" action="${formAction}">
		
		<fieldset>
			<legend>Sign in</legend>
			
			
			<table>
			<tr>
			<td><form:label path="login">Login</form:label></td>
			<td><form:input path="login"  required="true"/></td>
			</tr>
			<tr>
			<td><form:label path="password">Password</form:label></td>
			<td><form:password path="password" /></td>
			</tr>
			<tr>
			<td colspan="2">
			<input type="submit" value="Sign in"/>
			</td>
			</tr>
			</table>
		</fieldset>
		</form:form>
		
		<p>
		<!--  <a href="<c:url value="/registration"/>" title="Sign on">Not yet a member?</a> -->
   		</p>
    </jsp:body>
</t:layout>

