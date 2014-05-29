<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<t:authLayout>
    <jsp:attribute name="pageTitle">Agreements</jsp:attribute>
    
    <jsp:body>
    	<t:submenu/>
    	<h2>Access Time</h2>
    	<div class="hint">
			<p>
				You should add one or more access times to every day of week, when a service is available.
			</p>
			<p>
				<em><strong>Example:</strong> if a service is available 24/7, you should add every day access time from 00:00 to 23:59.</em>
			</p>
		</div>
    	
    	 <c:url value="/agreement/service-hours-add-access-time" var="formAction"/>
    	<form:form action="${formAction}" method="POST"> 
    		<fieldset>
			<legend>Service hours</legend>
			
			<table>
				<tr>
					<td><form:label path="day">Day</form:label></td>
					<td>
						<form:select path="day" required="true" >
							<form:option value="">choose day</form:option>
     						<form:options items="${days}" />
						</form:select>
					</td>
				</tr>
				<tr>
					<td><form:label path="openString">Open</form:label></td>
					<td><form:input path="openString" type="time" required="true"/></td>
				</tr>
				<tr>
					<td><form:label path="closeString">Close</form:label></td>
					<td><form:input path="closeString" type="time" required="true"/></td>
				</tr>
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

