<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:authLayout>
    <jsp:attribute name="pageTitle">Customer support</jsp:attribute>
    
    <jsp:body>
    <t:submenu/>
    	<h2>Customer support</h2>
    	 <div class="hint">
			<p>
				You should specify, how the agreement understood the customer support - in which way is it provided,
				how and when can you contact it, what the customer support covers.
			</p>
			<p>
				It is useful to define strict limit for a request response. Also the definition of the response should be inclosed 
				(perhaps the response in an automatic generated email does not help the customer to solve his problem).
			</p>
			<p>
				It is very important to define single point of contact here - the only way, how can customer communicate with service provider.
			</p>
			<p>
				Access times of customer support are very similar to a service hours. Define opening and closing time to every day of week.
			</p>
		</div>
    	
    	<c:url value="/agreement/add-customer-support" var="formAction"/>
    	<form:form action="${formAction}" method="POST">
    		<fieldset>
			<legend>Customer support</legend>
			
			<table>
			<tr>
				<td colspan="2"><form:label path="description">Customer support description</form:label></td>
			</tr>
			<tr>
				<td colspan="2"><form:textarea path="description"  cols="8" rows="15"/></td>
			</tr>
			
			<tr>
				<td><form:label path="responseHours">Response limit</form:label></td>
				<td>
					<form:select path="responseHours" items="${hours}">
							<form:option value="">hours</form:option>
					</form:select>[hours]
				</td>
			</tr>
			
			<tr>
				<td>&nbsp;</td>
				<td>
					<form:input path="responseDays" size="1"/>[days]
				</td>
			</tr>
			
			<tr>
				<td colspan="2"><form:label path="response">Response definition</form:label></td>
			</tr>
			<tr>
				<td colspan="2">
					<form:textarea path="response"  cols="60" rows="10"/>
				</td>
			</tr>
			<tr>
				<td colspan="2"><form:label path="note">Note</form:label></td>
			</tr>
			<tr>
				<td colspan="2">
					<form:textarea path="note" cols="60" rows="10"/>
				</td>
			</tr>
		</table>
		<fieldset>
				<legend>Contact</legend>
				<table>
					<tr>
						<td><form:label path="contact.email">Email</form:label></td>
						<td><form:input path="contact.email" type="email"/></td>
					</tr>
					<tr>
						<td><form:label path="contact.web">Web</form:label></td>
						<td><form:input path="contact.web" type="url"/></td>
					</tr>
					<tr>
						<td><form:label path="contact.telephone">Telephone</form:label></td>
						<td><form:input path="contact.telephone" type="tel"/></td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td><form:label path="contact.street">Street</form:label></td>
						<td><form:input path="contact.street"/></td>
					</tr>
					<tr>
						<td><form:label path="contact.town">Town</form:label></td>
						<td><form:input path="contact.town"/></td>
					</tr>
					<tr>
						<td><form:label path="contact.country">Country</form:label></td>
						<td><form:input path="contact.country"/></td>
					</tr>
				</table>
			</fieldset>
		<table>
			<tr>
				<td colspan="2">
					<input type="submit" value="Save"/>
				</td>
			</tr>
			</table>
		</fieldset>
		</form:form>
    	
    	<h3>Access times</h3>
    	
    	<a href="<c:url value="/agreement/customer-support-access-time"/>" title="Add" class="add">
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
				<td><c:if  test="${accessTime.day != null}">${accessTime.day}</c:if></td>
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
					<a href="<c:url value="/agreement/customer-support-delete-access-time?index=${status.index}"/>" title="Delete" class="delete" onClick="return confirm('Are you sure you want to delete this access time? This operation cannot be undone.')">
					<span>Delete</span>
					</a>
				</td>
			</tr>
			</c:forEach>
    	</table>
    	
    </jsp:body>
</t:authLayout>

