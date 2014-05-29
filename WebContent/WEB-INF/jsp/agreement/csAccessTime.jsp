<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<t:authLayout>
    <jsp:attribute name="pageTitle">Access time</jsp:attribute>
    
    <jsp:body>
    	<t:submenu/>
    	<h2>Access Time</h2>
       	 <div class="hint">
			<p>
				Access times of customer support are very similar to a service hours. Define opening and closing time to every day of week.
			</p>
		</div>
    	
    	 <c:url value="/agreement/customer-support-add-access-time" var="formAction"/>
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

