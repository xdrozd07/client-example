<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:authLayout>
    <jsp:attribute name="pageTitle">Availability</jsp:attribute>
    
    <jsp:body>
    <t:submenu/>
    	<h2>Availability</h2>
    	<div class="hint">
			<p>
				This should contain the definition of target availability, which will the provider seek to deliver within agreed service hours.
				As is common, availability in this system is specified as maximal time of service to be unavailable (duration in seconds) per specified period. 
			</p>
			<p>
				There should be defined right one metric in every availability configuration item, but you may add more than one availability configuration items.
			</p>
			<p>
				<em>
					<strong>Example: </strong> If you are building the agreement to cover a typical webhosting service, you may specify one availability configuration item to cover
					file server availability, second to mail server availability and last one to database server availability perhaps. 
				
				</em>
			</p>
		</div>
    	
    	<c:url value="/agreement/add-availability" var="formAction"/>
    	<form:form action="${formAction}" method="POST">
    		<fieldset>
			<legend>Availability</legend>
			
			<table>
				<tr>
					<td><form:label path="description">Description</form:label></td>
				</tr>
				<tr>
					<td><form:textarea path="description"  cols="60" rows="15"/></td>
				</tr>
			</table>
			<fieldset>
			<legend>Metric</legend>
				<table>
				
				<tr>
					<td><form:label path="metric.name">Name</form:label></td>
					<td><form:input path="metric.name" required="true" maxlength="255"/></td>
				</tr>
				<tr>
					<td><form:label path="metric.inputType">Input Type</form:label></td>
					<td>
						<form:select path="metric.inputType" required="true">
							<form:option value="">choose</form:option>
							<form:options items="${types}"/> 
						</form:select>
					</td>
				</tr>
				<!-- 
				<tr>
					<td><form:label path="metric.inputFormat">Input Format</form:label></td>
					<td><form:input path="metric.inputFormat" maxlength="255"/></td>
				</tr> -->
				<tr>
					<td><form:label path="metric.inputAddress">Input Address</form:label></td>
					<td><form:input path="metric.inputAddress" required="true" maxlength="255" /></td>
				</tr>
				</table>
			
			</fieldset>
			<table>	
				<tr>
					<td colspan="2">
						<input type="submit" value="Add"/>
					</td>
				</tr>
			</table>
			</fieldset>
		</form:form>
		
		<h3>Availabilities</h3>

		<table class="list">
			<tr>
				<th>Description</th>
				<th>Metric Name</th>
				<th>Input address</th>
				<th>Input type</th>
				<th>Input format</th>
				<th>Values</th>
				<th>Thresholds</th>
				<th>Delete</th>
			</tr>	
			<c:forEach var="availability" items="${availabilities}" varStatus="status">
			<tr>
				<td><c:if  test="${availability.description != null}">${availability.description}</c:if></td>
				
				<td><c:if  test="${availability.metric.name != null}">${availability.metric.name}</c:if></td>
				<td class="middle"><c:if  test="${availability.metric.inputAddress != null}">${availability.metric.inputAddress}</c:if></td>
				<td class="middle"><c:if  test="${availability.metric.inputType != null}">${availability.metric.inputType}</c:if></td>
				<td class="middle"><c:if  test="${availability.metric.inputFormat != null}">${availability.metric.inputFormat}</c:if></td>
				
				<td class="middle">
					<a href="<c:url value="/agreement/availability-metric-values?index=${status.index}"/>" title="Values" class="edit">
					<span>"Values"</span>
					</a>
				</td>
				
				<td class="middle">
					<a href="<c:url value="/agreement/availability-tresholds?index=${status.index}"/>" title="Thresholds" class="edit">
					<span>Thresholds</span>
					</a>
				</td>
				
				<td class="middle">
					<a href="<c:url value="/agreement/delete-availability?index=${status.index}"/>" title="Delete" class="delete" onClick="return confirm('Are you sure you want to delete this availability? This operation cannot be undone.')">
					<span>Delete</span>
					</a>
				</td>
			</tr>
			</c:forEach>
    	</table>

    </jsp:body>
</t:authLayout>

