<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:authLayout>
    <jsp:attribute name="pageTitle">Signatures</jsp:attribute>
    
    <jsp:body>
    	<t:submenu/>
    	
    	<c:url value="/agreement/add-signatory" var="formAction"/>
    	<form:form action="${formAction}" method="POST"> 
    		<fieldset>
			<legend>Signature</legend>
			
			<table>
				<tr>
					<td><form:label path="name">Name</form:label></td>
					<td><form:input path="name" required="true" maxlength="255" /></td>
				</tr>
				<tr>
					<td><form:label path="dateString">Date</form:label></td>
					<td><form:input path="dateString" type="date" required="true" /></td>
				</tr>
				<tr>
					<td>
					<input type="submit" value="Add"/>
					</td>
				</tr>
			</table>
		</fieldset>
		
			
    	</form:form>
    	
    	<h3>Signatures</h3>
    	
		<table class="list">
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Delete</th>
			</tr>	
			<c:forEach var="signature" items="${signatories}" varStatus="status">
			<tr>
				<td><c:if  test="${signature.name != null}">${signature.name}</c:if></td>
				<td class="middle">
					<c:if  test="${signature.date != null}">
						<fmt:formatDate value="${signature.date}" pattern="yyyy-MM-dd" /> 
					</c:if>
				</td>
				
				<td class="middle">
					<a href="<c:url value="/agreement/delete-signatory?index=${status.index}"/>" title="Delete" class="delete" onClick="return confirm('Are you sure you want to delete this signature? This operation cannot be undone.')">
						<span>Delete</span>
					</a>
				</td>
			</tr>
			</c:forEach>
    	</table>    	
    	
    </jsp:body>
</t:authLayout>

