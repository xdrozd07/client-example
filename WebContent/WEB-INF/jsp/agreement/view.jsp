<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:authLayout>
    <jsp:attribute name="pageTitle">View</jsp:attribute>
    
    <jsp:body>
    	<h2>Preview</h2>
    	
    	<h3>Basic information</h3>
    	<table class="view">
    		<tr>
    			<th>Name of agreement:</th>
    			<td>
	    			<c:if  test="${agreement.name != null}">${agreement.name}</c:if>
    			</td>
    		</tr>
    		
    		<tr>
    			<th>Valid from:</th>
    			<td>
	    			<c:if  test="${agreement.validFrom != null}"> 
	    				<fmt:formatDate value="${agreement.validFrom}" pattern="yyyy-MM-dd"  />
					</c:if>
    			</td>
    		</tr>
    		
    		<tr>
    			<th>Valid to:</th>
    			<td>
	    			<c:if  test="${agreement.validTo != null}"> 
	    				<fmt:formatDate value="${agreement.validTo}" pattern="yyyy-MM-dd"  />
					</c:if>
    			</td>
    		</tr>
    		
    		<tr>
    			<th>Service description:</th>
    			<td>
	    			<c:if  test="${agreement.serviceDescription != null}"> 
	    				${agreement.serviceDescription}
					</c:if>
    			</td>
    		</tr>
    		
    		<tr>
    			<th>SLA description:</th>
    			<td>
	    			<c:if  test="${agreement.slaDescription != null}"> 
	    				${agreement.slaDescription}
					</c:if>
    			</td>
    		</tr>
    		
    		<tr>
    			<th>Security description:</th>
    			<td>
	    			<c:if  test="${agreement.securityDescription != null}"> 
	    				${agreement.securityDescription}
					</c:if>
    			</td>
    		</tr>
    	</table>
    	
    	<h3>Involved parties</h3>
    	
		<table class="view">
			<tr>
				<th>Name</th>
				<th class="middle">Role</th>
				<th>Contact</th>
			</tr>	
			<c:forEach var="party" items="${agreement.involvedParties}" varStatus="status">
			<tr>
				<td><c:if  test="${party.name != null}">${party.name}</c:if></td>
				<td class="middle"><c:if  test="${party.role != null}">${party.role}</c:if></td>
				<td>
					<c:if  test="${party.contact != null}">
						<c:if  test="${!empty party.contact.email}">${party.contact.email}<br></c:if>
						<c:if  test="${!empty party.contact.web}" >${party.contact.web}<br></c:if>
						<c:if  test="${!empty party.contact.telephone}">${party.contact.telephone}<br></c:if>
						
						<c:if  test="${!empty party.contact.street}">${party.contact.street}</c:if><c:if  test="${!empty party.contact.town}">, ${party.contact.town}</c:if><c:if  test="${!empty party.contact.country}">, ${party.contact.country}<br></c:if>
					</c:if>
				</td>
			</tr>
			</c:forEach>
    	</table>    	
    	
    	
    	<h3>Service hours</h3>
    	<table class="view">
    		<tr>
    			<td>
	    			<c:if  test="${!empty agreement.serviceHours.description}">${agreement.serviceHours.description}</c:if>
    			</td>
    		</tr>
   		</table>
   		
   		<h4>Access times</h4>
   		<table class="view">
			<tr>
				<th class="middle">Day</th>
				<th class="middle">Open</th>
				<th class="middle">Close</th>
			</tr>	
			<c:forEach var="accessTime" items="${agreement.serviceHours.accessTimes}" varStatus="status">
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
			</tr>
			</c:forEach>
    	</table>
    	
    	
    	<h3>Customer support</h3>
    	<table class="view">
    		<tr>
    			<th>Description:</th>
    			<td>
	    			<c:if  test="${!empty agreement.customerSupport.description}">${agreement.customerSupport.description}</c:if>
    			</td>
    		</tr>
    		<tr>
    			<th>Response definition:</th>
    			<td>
	    			<c:if  test="${!empty agreement.customerSupport.response}">${agreement.customerSupport.response}</c:if>
    			</td>
    		</tr>
    		<tr>
    			<th>Note:</th>
    			<td>
	    			<c:if  test="${!empty agreement.customerSupport.note}">${agreement.customerSupport.note}</c:if>
    			</td>
    		</tr>
    		<tr>
    			<th>Response time:</th>
    			<td>
	    			<c:if  test="${agreement.customerSupport.responseTime != null}">
						<fmt:formatDate value="${agreement.customerSupport.responseTime}" pattern="dd/HH" />  [day(s)/hour(s)]
					</c:if>
    			</td>
    		</tr>
   		</table>

   		<h4>Access times</h4>
   		<table class="view">
			<tr>
				<th class="middle">Day</th>
				<th class="middle">Open</th>
				<th class="middle">Close</th>
			</tr>	
			<c:forEach var="accessTime" items="${agreement.customerSupport.accessTimes}" varStatus="status">
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
			</tr>
			</c:forEach>
    	</table>
    	
    	<h3>Change management</h3>
    	<table class="view">
    	
    		<c:if  test="${!empty agreement.changemanagement.description}">
    		<tr>
    			<th>Description</th>
    			<td>
	    			${agreement.changemanagement.description}
    			</td>
    		</tr>
   			</c:if>
   			<c:if  test="${!empty agreement.changemanagement.contact}">
    		<tr>
    			<th>Contact</th>
    			<td>
	    			<c:if  test="${!empty agreement.changemanagement.contact.email}">${agreement.changemanagement.contact.email}<br></c:if>
					<c:if  test="${!empty agreement.changemanagement.contact.web}" >${agreement.changemanagement.contact.web}<br></c:if>
					<c:if  test="${!empty agreement.changemanagement.contact.telephone}">${agreement.changemanagement.contact.telephone}<br></c:if>
						
					<c:if  test="${!empty agreement.changemanagement.contact.street}">${agreement.changemanagement.contact.street}</c:if><c:if  test="${!empty agreement.changemanagement.contact.town}">, ${agreement.changemanagement.contact.town}</c:if><c:if  test="${!empty agreement.changemanagement.contact.country}">, ${agreement.changemanagement.contact.country}<br></c:if>
					
    			</td>
    		</tr>
   			</c:if>
   		</table>
   		
   		
    	<h3>Performance</h3>
    	    <table class="view">
    	
    		<c:if  test="${!empty agreement.performance.description}">
    		<tr>
    			<th>Description</th>
    			<td>
	    			${agreement.performance.description}
    			</td>
    		</tr>
   			</c:if>
   		</table>
   		
   		<h4>Metrics</h4>
   		<table class="view">
			<tr>
				<th>Name</th>
			</tr>	
			<c:forEach var="metric" items="${agreement.performance.metrics}" varStatus="status">
			<tr>
				<td>
					<c:if  test="${metric.name != null}">${metric.name}</c:if>
				</td>
			</tr>
			</c:forEach>
    	</table>
    	
    	<h3>Availability</h3>
   		<table class="view">
			<tr>
				<th>Description</th>
				<th class="middle">Metric</th>
			</tr>	
			<c:forEach var="availability" items="${agreement.availability}" varStatus="status">
			<tr>
				<td>
					<c:if  test="${availability.description != null}">${availability.description}</c:if>
				</td>
				<td>
					<c:if  test="${availability.metric.name != null}">${availability.metric.name}</c:if>
				</td>
			</tr>
			</c:forEach>
    	</table>


		<h3>Reports</h3>
   		<table class="view">
			<tr>
				<th>Name</th>
				<th class="middle">Frequency</th>
				<th class="middle">Day</th>
				<th class="middle">Hour</th>
				<th class="middle">Metrics</th>
			</tr>	
			<c:forEach var="report" items="${agreement.reports}">
			<tr>
				<td>
					<c:if  test="${report.name != null}">${report.name}</c:if>
				</td>
				<td class="middle">
					<c:if  test="${report.frequency != null}">${report.frequency}</c:if>
				</td>
				<td class="middle">
					<c:if  test="${report.day != null}">${report.day}</c:if>
				</td>
				<td class="middle">
					<c:if  test="${report.hour != null}">${report.hour}</c:if>
				</td>
				<td>
					<c:forEach var="metrics" items="${report.metrics}">
						<c:if  test="${metrics.name != null}">${metrics.name},</c:if>
					</c:forEach>
				</td>
			</tr>
			</c:forEach>
    	</table>	
    </jsp:body>
</t:authLayout>

