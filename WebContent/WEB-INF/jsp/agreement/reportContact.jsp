<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:authLayout>
    <jsp:attribute name="pageTitle">Contact</jsp:attribute>
    
    <jsp:body>
    <t:submenu/>
    	<h2>Contact</h2>
    	
    	<c:url value="/agreement/report-add-contact" var="formAction"/>
    	<form:form action="${formAction}" method="POST">
    		<fieldset>
			<legend>Contact</legend>

			
			<table>
				<tr>
					<td><form:label path="email">Email</form:label></td>
					<td><form:input path="email" type="email" required="true" maxlength="255"/></td>
				</tr>

				<tr>
					<td colspan="2">
						<input type="submit" value="Add"/>
					</td>
				</tr>
			</table>
			</fieldset>
		</form:form>
		
		<h3>Contacts</h3>

		<table class="list">
			<tr>
				<th>Name</th>
				<th>Delete</th>
			</tr>	
			<c:forEach var="contact" items="${contacts}" varStatus="status">
			<tr>
				<td><c:if  test="${contact.email != null}">${contact.email}</c:if></td>
				
				<td class="middle">
					<a href="<c:url value="/agreement/delete-report-contact?index=${status.index}"/>" title="Delete" class="delete" onClick="return confirm('Are you sure you want to delete this contact? This operation cannot be undone.')">
					<span>Delete</span>
					</a>
				</td>
			</tr>
			</c:forEach>
    	</table>

    </jsp:body>
</t:authLayout>

