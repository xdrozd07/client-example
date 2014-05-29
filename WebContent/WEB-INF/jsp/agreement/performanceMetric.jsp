<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:authLayout>
    <jsp:attribute name="pageTitle">Metric</jsp:attribute>
    
    <jsp:body>
    <t:submenu/>
    	<h2>Metric</h2>
    	
    	<c:url value="/agreement/add-performance-metric" var="formAction"/>
    	<form:form action="${formAction}" method="POST">
    		<fieldset>
			<legend>Metric</legend>
			
			<table>
			
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" required="true" maxlength="255" /></td>
			</tr>
			<tr>
				<td><form:label path="inputType">Input Type</form:label></td>
				<td>
					<form:select path="inputType" required="true" >
						<form:option value="">choose input type</form:option>
						<form:options  items="${types}"/>
					</form:select>
				</td>
			</tr>
			<!-- 
			<tr>
				<td><form:label path="inputFormat">Input Format</form:label></td>
				<td><form:input path="inputFormat" maxlength="255" /></td>
			</tr> -->
			<tr>
				<td><form:label path="inputAddress">Input Address</form:label></td>
				<td><form:input path="inputAddress" required="true" maxlength="255" /></td>
			</tr>
					
			<tr>
				<td colspan="2">
					<input type="submit" value="Add"/>
				</td>
			</tr>
			</table>
			</fieldset>
		</form:form>
		

    </jsp:body>
</t:authLayout>

