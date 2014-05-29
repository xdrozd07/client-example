<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:authLayout>
    <jsp:attribute name="pageTitle">Listeners</jsp:attribute>
    
    <jsp:body>
    <t:submenu/>
    	<h2>Listener</h2>
    	
    	<c:url value="/agreement/add-availability-threshold-listener" var="formAction"/>
    	<form:form action="${formAction}" method="POST">
    		<fieldset>
			<legend>Listener</legend>
			
			<table>
			
			<tr>
				<td><form:label path="address">Address</form:label></td>
				<td><form:input path="address" required="true" maxlength="255" /></td>
			</tr>
					
			<tr>
				<td colspan="2">
					<input type="submit" value="Add"/>
				</td>
			</tr>
			</table>
			</fieldset>
		</form:form>
		
		<h3>Listeners</h3>

		<table class="list">
			<tr>
				<th>Address</th>
				<th>Delete</th>
			</tr>	
			<c:forEach var="listener" items="${listeners}" varStatus="status">
			<tr>
				<td class="middle"><c:if  test="${listener.address != null}">${listener.address}</c:if></td>	
				
				<td class="middle">
					<a href="<c:url value="/agreement/delete-availability-threshold-listener?index=${status.index}"/>" title="Delete" class="delete" onClick="return confirm('Are you sure you want to delete this listener? This operation cannot be undone.')">
					<span>Delete</span>
					</a>
				</td>
			</tr>
			</c:forEach>
    	</table>

    </jsp:body>
</t:authLayout>

