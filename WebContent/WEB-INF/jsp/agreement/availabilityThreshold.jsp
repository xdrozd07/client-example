<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:authLayout>
    <jsp:attribute name="pageTitle">Threshold</jsp:attribute>
    
    <jsp:body>
    <t:submenu/>
    	<h2>Threshold</h2>
    	
    	<c:url value="/agreement/add-availability-threshold" var="formAction"/>
    	<form:form action="${formAction}" method="POST">
    		<fieldset>
			<legend>Threshold</legend>
			
			<table>
			
			<tr>
				<td><form:label path="value">Threshold value</form:label></td>
				<td><form:input path="value" required="true" number="true" /></td>
			</tr>
					
			<tr>
				<td colspan="2">
					<input type="submit" value="Add"/>
				</td>
			</tr>
			</table>
			</fieldset>
		</form:form>
		
		<h3>Thresholds</h3>

		<table class="list">
			<tr>
				<th>Value</th>
				<th>Listeners</th>
				<th>Delete</th>
			</tr>	
			<c:forEach var="threshold" items="${thresholds}" varStatus="status">
			<tr>
				<td class="middle"><c:if  test="${threshold.value != null}">${threshold.value}</c:if></td>
				
				<td class="middle">
					<a href="<c:url value="/agreement/availability-threshold-listeners?index=${status.index}"/>" title="Listeners" class="edit">
					<span>Listeners</span>
					</a>
				</td>
				
				
				<td class="middle">
					<a href="<c:url value="/agreement/delete-availability-threshold?index=${status.index}"/>" title="Delete" class="delete" onClick="return confirm('Are you sure you want to delete this threshold? This operation cannot be undone.')">
					<span>Delete</span>
					</a>
				</td>
			</tr>
			</c:forEach>
    	</table>

    </jsp:body>
</t:authLayout>

