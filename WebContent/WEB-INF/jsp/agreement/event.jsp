<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<t:authLayout>
    <jsp:attribute name="pageTitle">Agreements</jsp:attribute>
    
    <jsp:body>
    	<t:submenu/>
    	<h2>Event</h2>
    	<div class="hint">
			<p>
				Service hour event represents an unusual, irregular occurrence, like temporary shutdown or maintenance.
			</p>
			<P>
				You should always specify event opening and closing date/time.
			</p>
		</div>
    
    	
    	 <c:url value="/agreement/add-event" var="formAction"/>
    	<form:form action="${formAction}" method="POST"> 
    		<fieldset>
			<legend>Event</legend>
			
			<table>
				<tr>
					<td><form:label path="type">Event Type</form:label></td>
					<td>
						<form:select path="type" required="true">
							<form:option value="">choose event type</form:option>
     						<form:options items="${types}" />
						</form:select>
					</td>
				</tr>
				<tr>
					<td><form:label path="description">Description</form:label></td>
				</tr>
				<tr>
					<td colspan="2"><form:textarea path="description" cols="60" rows="10"/> </td>
				</tr>
				
			</table>
			
			<fieldset>
			<legend>Open</legend>
			<table>
				<tr>
					<td><form:label path="openDate">Date</form:label></td>
					<td><form:input path="openDate" type="date" required="true"/></td>
				</tr>
				<tr>
					<td><form:label path="openTime">Time</form:label></td>
					<td><form:input path="openTime" type="time" required="true"/></td>
				</tr>
			</table>
			</fieldset>
			
			<fieldset>
			<legend>Close</legend>
			<table>
				<tr>
					<td><form:label path="closeDate">Date</form:label></td>
					<td><form:input path="closeDate" type="date" required="true"/></td>
				</tr>
				<tr>
					<td><form:label path="closeTime">Time</form:label></td>
					<td><form:input path="closeTime" type="time" required="true"/></td>
				</tr>
			</table>
			</fieldset>
			
			
			<table>
				<tr>
					<td>
					<input type="submit" value="Add"/>
					</td>
				</tr>
			</table>
			
		</fieldset>
		
    	</form:form>
    	
    </jsp:body>
</t:authLayout>

