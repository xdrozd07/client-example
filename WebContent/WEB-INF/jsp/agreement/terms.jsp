<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:authLayout>
    <jsp:attribute name="pageTitle">Glossaries</jsp:attribute>
    
    <jsp:body>
    <t:submenu/>
    	<h2>Glossaries</h2>
    	
    	<c:url value="/agreement/add-term" var="formAction"/>
    	<form:form action="${formAction}" method="POST">
    		<fieldset>
			<legend>New Glossary</legend>
			
			<table>
			
			<tr>
				<td><form:label path="term">Term</form:label></td>
				<td><form:input path="term" required="true"  maxlength="255"/></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<form:label path="definition" >Definition</form:label>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<form:textarea path="definition"  cols="40" rows="8" required="true" />
				</td>
			</tr>
					
			<tr>
				<td colspan="2">
					<input type="submit" value="Add"/>
				</td>
			</tr>
			</table>
			</fieldset>
		</form:form>
		
		<h3>Terms</h3>

		<table class="list">
			<tr>
				<th>Term</th>
				<th>Definition</th>
				<th>Delete</th>
			</tr>	
			<c:forEach var="term" items="${terms}" varStatus="status">
			<tr>
				<td><c:if  test="${term.term != null}">${term.term}</c:if></td>
				<td><c:if  test="${term.definition != null}">${term.definition}</c:if></td>

				
				<td class="middle">
					<a href="<c:url value="/agreement/delete-term?index=${status.index}"/>" title="Delete" class="delete" onClick="return confirm('Are you sure you want to delete this term? This operation cannot be undone.')">
					<span>Delete</span>
					</a>
				</td>
			</tr>
			</c:forEach>
    	</table>

    </jsp:body>
</t:authLayout>

