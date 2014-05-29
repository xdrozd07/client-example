<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:authLayout>
    <jsp:attribute name="pageTitle">Glossaries</jsp:attribute>
    
    <jsp:body>
    <t:submenu/>
    	<h2>Glossaries</h2>
    	
    	<div class="hint">
			<p>
				Glossaries are mainly used as a base to unify a terminology/terms used in the agreement or service description
				across the involved parties organizations. This should avoid the misunderstanding and problems which can it result to.
			</p>
			<p>
				You may add more than one glossary, if you need. One perhaps for general terms. Other one for a specific part of service etc.
			</p>
		</div>
    	
    	<c:url value="/agreement/add-glossary" var="formAction"/>
    	<form:form action="${formAction}" method="POST">
    		<fieldset>
			<legend>New Glossary</legend>
			
			<table>
			
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name"  required="true" maxlength="255"/></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<form:label path="description">Description</form:label>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<form:textarea path="description"  cols="60" rows="10"/>
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
		
		<h3>Glossaries</h3>

		<table class="list">
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Terms</th>
				<th>Delete</th>
			</tr>	
			<c:forEach var="glossary" items="${glossaries}" varStatus="status">
			<tr>
				<td><c:if  test="${glossary.name != null}">${glossary.name}</c:if></td>
				<td class="middle"><c:if  test="${glossary.description != null}">${glossary.description}</c:if></td>
				
				<td class="middle">
					<a href="<c:url value="/agreement/terms?index=${status.index}"/>" title="Terms" class="edit">
					<span>Terms</span>
					</a>
				</td>
				
				<td class="middle">
					<a href="<c:url value="/agreement/delete-glossary?index=${status.index}"/>" title="Delete" class="delete" onClick="return confirm('Are you sure you want to delete this glossary? This operation cannot be undone.')">
					<span>Delete</span>
					</a>
				</td>
			</tr>
			</c:forEach>
    	</table>

    </jsp:body>
</t:authLayout>

