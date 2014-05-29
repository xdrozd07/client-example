<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<t:authLayout>
    <jsp:attribute name="pageTitle">Agreements</jsp:attribute>
    
    <jsp:body>
    	<t:submenu/>
    	<h2>Involved parties</h2>
    	
    	<c:url value="/agreement/add-involved-party" var="formAction"/>
    	<form:form action="${formAction}" method="POST"> 
    		<fieldset>
			<legend>Involved party</legend>
			
			<div class="hint">
				<p>
					Every single agreement must be made between at least two involved parties - provider and customer.
					In some case, it may be useful to specify third parties, who participate on the service, perhaps
					independent quality measurement contractor.
				</p>
				<p>
					You may add a contact informations. This should be related with the department, responsible for the agreements
					signing.
				</p>
				<p>
					There may be more than one person responsible for the agreement in every involved party. Signatures of all
					relevant people should be enclosed.
				</p>
			
			</div>
			
			<table>
				<tr>
					<td><form:label path="name">Name</form:label></td>
					<td><form:input path="name"  required="true" maxlength="255" /></td>
				</tr>
				<tr>
					<td><form:label path="role">Role</form:label></td>
					<td>
						<form:select path="role"  required="true">
							<form:option value="">choose role</form:option>
     						<form:options items="${roles}" />
						</form:select>
					</td>
				</tr>
			</table>
			
			<fieldset>
				<legend>Contact</legend>
				<table>
					<tr>
						<td><form:label path="contact.email">Email</form:label></td>
						<td><form:input path="contact.email" type="email"  maxlength="255" /></td>
					</tr>
					<tr>
						<td><form:label path="contact.web">Web</form:label></td>
						<td><form:input path="contact.web" type="url"  maxlength="255" /></td>
					</tr>
					<tr>
						<td><form:label path="contact.telephone">Telephone</form:label></td>
						<td><form:input path="contact.telephone" type="tel" maxlength="15" /></td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td><form:label path="contact.street">Street</form:label></td>
						<td><form:input path="contact.street" maxlength="255" /></td>
					</tr>
					<tr>
						<td><form:label path="contact.town">Town</form:label></td>
						<td><form:input path="contact.town" maxlength="255" /></td>
					</tr>
					<tr>
						<td><form:label path="contact.country">Country</form:label></td>
						<td><form:input path="contact.country" maxlength="255" /></td>
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
    	
    	
    	
		<table class="list">
			<tr>
				<th>Name</th>
				<th>Role</th>
				<th>Contact</th>
				<th>Signatures</th>
				<th>Delete</th>
			</tr>	
			<c:forEach var="party" items="${parties}" varStatus="status">
			<tr>
				<td><c:if  test="${party.name != null}">${party.name}</c:if></td>
				<td class="middle"><c:if  test="${party.role != null}">${party.role}</c:if></td>
				<td>
					<c:if  test="${party.contact != null}">
						<c:if  test="${!empty party.contact.email}">${party.contact.email}<br></c:if>
						<c:if  test="${!empty party.contact.web}" >${party.contact.web}<br></c:if>
						<c:if  test="${!empty party.contact.telephone}">${party.contact.telephone}<br></c:if>
						
						<c:if  test="${!empty party.contact.street}">${party.contact.street}</c:if>
						<c:if  test="${!empty party.contact.town}">, ${party.contact.town}</c:if>
						<c:if  test="${!empty party.contact.country}">, ${party.contact.country}<br></c:if>
					</c:if>
				</td>
				<td class="middle">
					<a href="<c:url value="/agreement/signatories?index=${status.index}"/>" title="Signatures" class="edit">
					<span>Signatures</span>
					</a>
				</td>
				<td class="middle">
					<a href="<c:url value="/agreement/delete-involved-party?index=${status.index}"/>" title="Delete" class="delete" onClick="return confirm('Are you sure you want to delete this party? This operation cannot be undone.')">
					<span>Delete</span>
					</a>
				</td>
			</tr>
			</c:forEach>
    	</table>    	
    	
    </jsp:body>
</t:authLayout>

