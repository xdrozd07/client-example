<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:authLayout>
    <jsp:attribute name="pageTitle">Contact</jsp:attribute>
    
    <jsp:body>
    <t:submenu/>
    	<h2>Metrics</h2>
    	
    	<c:if  test="${metricChangedFlag == true}">
    		<div class="message-warning">
	    		<h3>Please save the agreement before continue</h3>
	    		<p>
		    			We have noticed, that you have added some new metrics. Unfortunately, due to technological restrictions
		    			of Web services usage, there is a need to save the agreement before creating adding metrics to the report.
	    		</p>
	    		<p>
	    		<a href="<c:url value="/agreement/save"/>" >You can save the agreement here.</a>
	    			
	    		</p>
    		</div>
    	</c:if>
    	<c:if  test="${metricChangedFlag == false}">
    	
    		
			<c:if  test="${perfomanceMetricsSet}">
	    	<c:url value="/agreement/report-add-perfomance-metric" var="performanceFormAction"/>
	    	<form:form action="${performanceFormAction}" method="POST">
	    		<fieldset>
				<legend>Performance Metric</legend>
	
				
				<table>
					<tr>
						<td><form:label path="index">Metric name</form:label></td>
						<td><form:select path="index" items="${perfomanceMetrics}" /></td>
					</tr>
	
					<tr>
						<td colspan="2">
							<input type="submit" value="Add"/>
						</td>
					</tr>
				</table>
				</fieldset>
			</form:form>
			</c:if>
			
			
			<c:if  test="${availabilityMetricsSet}">
			<c:url value="/agreement/report-add-availability-metric" var="availabilityFormAction"/>
	    	<form:form action="${availabilityFormAction}" method="POST">
	    		<fieldset>
				<legend>Availability Metric</legend>
	
				
				<table>
					<tr>
						<td><form:label path="index">Metric name</form:label></td>
						<td><form:select path="index" items="${availabilityMetrics}" /></td>
					</tr>
	
					<tr>
						<td colspan="2">
							<input type="submit" value="Add"/>
						</td>
					</tr>
				</table>
				</fieldset>
			</form:form>
			</c:if>
		</c:if>
		<h3>Defined metrics</h3>

		<table class="list">
			<tr>
				<th>Name</th>
				<th>Delete</th>
			</tr>	
			<c:forEach var="metric" items="${reportMetrics}" varStatus="status">
			<tr>
				<td><c:if  test="${metric.name != null}">${metric.name}</c:if></td>
				
				<td class="middle">
					<a href="<c:url value="/agreement/delete-report-metric?index=${status.index}"/>" title="Delete" class="delete" onClick="return confirm('Are you sure you want to delete this metric? This operation cannot be undone.')">
					<span>Delete</span>
					</a>
				</td>
			</tr>
			</c:forEach>
    	</table>

    </jsp:body>
</t:authLayout>

