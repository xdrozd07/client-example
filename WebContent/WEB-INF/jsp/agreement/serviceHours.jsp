<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:authLayout>
    <jsp:attribute name="pageTitle">Agreements</jsp:attribute>
    
    <jsp:body>
    	<t:submenu/>
    	<h2>Service hours</h2>
    	
    	<div class="hint">
			<p>
				Basic informations about a times, when the service is (or is not) available should take a place  here. The most important is to add <em>access time</em>
				and <em>event</em> informations.
			</p>
		</div>
    	<c:url value="/agreement/add-service-hours" var="formAction"/>
    	<form:form action="${formAction}" method="POST"> 
    		<fieldset>
			<legend>Service hours</legend>
				
			<table>
				<tr>
					<td><form:label path="description">Description</form:label></td>
				</tr>
				<tr>
					<td><form:textarea path="description" cols="60" rows="10"/> </td>
				</tr>
				<tr>
					<td>
					<input type="submit" value="Save"/>
					</td>
				</tr>
			</table>
		</fieldset>
		
    	</form:form>
    	
    	
    	<h3>Access times</h3>
    	
    	<a href="<c:url value="/agreement/service-hours-access-time"/>" title="Add" class="add">
			Add access time
		</a>
		<table class="list">
			<tr>
				<th>Day</th>
				<th>Open</th>
				<th>Close</th>
				<th>Delete</th>
			</tr>	
			<c:forEach var="accessTime" items="${accessTimes}" varStatus="status">
			<tr>
				<td class="middle">
					<c:if  test="${accessTime.day != null}">${accessTime.day}</c:if>
				</td>
				<td class="middle">
					<c:if  test="${accessTime.open != null}">
						<fmt:formatDate value="${accessTime.open}" pattern="HH:mm" /> 
					</c:if>
				</td>
				<td class="middle">
					<c:if  test="${accessTime.close != null}">
						<fmt:formatDate value="${accessTime.close}" pattern="HH:mm" /> 
					</c:if>
				</td>
				
				<td class="middle">
					<a href="<c:url value="/agreement/service-hours-delete-access-time?index=${status.index}"/>" title="Delete" class="delete" onClick="return confirm('Are you sure you want to delete this access time? This operation cannot be undone.')">
					<span>Delete</span>
					</a>
				</td>
			</tr>
			</c:forEach>
    	</table>
    	
    	<h3>Events</h3>
    	
    	<a href="<c:url value="/agreement/event"/>" title="Add" class="add">
			Add Event
		</a>
		<table class="list">
			<tr>
				<th>Start</th>
				<th>End</th>
				<th>Type</th>
				<th>Description</th>
				<th>Delete</th>
			</tr>	
			<c:forEach var="event" items="${events}" varStatus="status">
			<tr>
				<td class="middle">
					<c:if  test="${event.open != null}">
						<fmt:formatDate value="${event.open}" pattern="HH:mm yyyy-MM-dd" /> 
					</c:if>
				</td>
				<td class="middle">
					<c:if  test="${event.close != null}">
						<fmt:formatDate value="${event.close}" pattern="HH:mm yyyy-MM-dd" /> 
					</c:if>
				</td>
				<td class="middle"><c:if  test="${event.type != null}">${event.type}</c:if></td>
				<td class="middle"><c:if  test="${event.description != null}">${event.description}</c:if></td>
				
				<td class="middle">
					<a href="<c:url value="/agreement/delete-event?index=${status.index}"/>" title="Delete" class="delete" onClick="return confirm('Are you sure you want to delete this event? This operation cannot be undone.')">
					<span>Delete</span>
					</a>
				</td>
			</tr>
			</c:forEach>
    	</table>    	
    	 
    </jsp:body>
</t:authLayout>

