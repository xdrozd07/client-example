<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:authLayout>
    <jsp:attribute name="pageTitle">Performance</jsp:attribute>
    
    <jsp:body>
    <t:submenu/>
    	<h2>Performance</h2>
    	<div class="hint">
			<p>
				This should include definition of target metrics used for performance measurement. You may add a brief description if you find it useful.
			</p>
			<p>
				All metrics should be named, and also source for measured data must be included.
			</p>
			<p>
				If you decide to define thresholds, you may add listeners, which will be contacted in a case of breaking the threshold.
			</p>
			<p>
				All performance metrics can be used in a report definition.
			</p>
		</div>
    	
    	<c:url value="/agreement/save-performance" var="formAction"/>
    	<form:form action="${formAction}" method="POST">
    		<fieldset>
			<legend>Performance</legend>
			
			<table>
			
			<tr>
				<td><form:label path="description">Description</form:label></td>
			</tr>
			
			<tr>
				<td><form:textarea path="description"  cols="60" rows="10"/></td>
			</tr>
					
			<tr>
				<td>
					<input type="submit" value="Save"/>
				</td>
			</tr>
			</table>
			</fieldset>
		</form:form>
		
		<h3>Metrics</h3>
		<a href="<c:url value="/agreement/performance-metric"/>" title="Add" class="add">
			Add Metric
		</a>

		<table class="list">
			<tr>
				<th>Name</th>
				<th>Input address</th>
				<th>Input type</th>
				<th>Input format</th>
				<th>Values</th>
				<th>Thresholds</th>
				<th>Delete</th>
			</tr>	
			<c:forEach var="metric" items="${metrics}" varStatus="status">
			<tr>
				<td><c:if  test="${metric.name != null}">${metric.name}</c:if></td>
				<td class="middle"><c:if  test="${metric.inputAddress != null}">${metric.inputAddress}</c:if></td>
				<td class="middle"><c:if  test="${metric.inputType != null}">${metric.inputType}</c:if></td>
				<td class="middle"><c:if  test="${metric.inputFormat != null}">${metric.inputFormat}</c:if></td>
				
				<td class="middle">
					<a href="<c:url value="/agreement/performance-metric-values?index=${status.index}"/>" title="Values" class="edit">
					<span>"Values"</span>
					</a>
				</td>
				
				<td class="middle">
					<a href="<c:url value="/agreement/performance-metric-tresholds?index=${status.index}"/>" title="Thresholds" class="edit">
					<span>Thresholds</span>
					</a>
				</td>
				
				<td class="middle">
					<a href="<c:url value="/agreement/delete-performance-metric?index=${status.index}"/>" title="Delete" class="delete" onClick="return confirm('Are you sure you want to delete this metric? This operation cannot be undone.')">
					<span>Delete</span>
					</a>
				</td>
			</tr>
			</c:forEach>
    	</table>

    </jsp:body>
</t:authLayout>

