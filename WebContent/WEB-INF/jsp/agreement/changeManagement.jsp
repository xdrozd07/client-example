<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:authLayout>
    <jsp:attribute name="pageTitle">Change management</jsp:attribute>
    
    <jsp:body>
    <t:submenu/>
    	<h2>Change management</h2>
    	
    	<div class="hint">
			<p>
				Brief mention of and/or a reference to the Organization's change management procedures, that must be followed
				- just to reinforce compliance. Contact for a responsible person/department (provider) may be included.
			</p>
		</div>
    	
    	<c:url value="/agreement/add-change-management" var="formAction"/>
    	<form:form action="${formAction}" method="POST">
    		<fieldset>
			<legend>Change management</legend>
			
			<table>
			<tr>
				<td colspan="2"><form:label path="description" required="true">Description</form:label></td>
			</tr>
			<tr>
				<td colspan="2"><form:textarea path="description"  cols="60" rows="10"/></td>
			</tr>
			
			</table>
			<fieldset>
					<legend>Contact</legend>
					<table>
						<tr>
							<td><form:label path="contact.email">Email</form:label></td>
							<td><form:input path="contact.email" type="email" maxlength="255" /></td>
						</tr>
						<tr>
							<td><form:label path="contact.web">Web</form:label></td>
							<td><form:input path="contact.web" type="url" maxlength="255" /></td>
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
					<td colspan="2">
						<input type="submit" value="Save"/>
					</td>
				</tr>
				</table>
			</fieldset>
		</form:form>

    </jsp:body>
</t:authLayout>

