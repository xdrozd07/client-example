<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:authLayout>
    <jsp:attribute name="pageTitle">Agreements</jsp:attribute>
    
    <jsp:body>
    <t:submenu/>
    	<h2>Basic informations</h2>
    	
    	<c:url value="/agreement/add-basic-informations" var="formAction"/>
    	<form:form action="${formAction}" method="POST">
    		<fieldset>
			<legend>Agreement</legend>
				
					<div class="hint">
						<p>
							First of all it is necessary to name the agreement and set the time bounds. If you wish, you may set the predecessor - one of agreement you have set up before.
							This is useful for building an agreement hierarchy (usage of agreement frames perhaps).
						</p>
						
						<p>
							If you are building a new agreement, you have to write down a covered service description and a description of SLA itself.
							Finally, you may specify security measures restrictions, if you find it useful.
						</p>
					</div>
				
			
			<table>
			<tr>
				<th><form:label path="name">Name of agreement</form:label></th>
				<td><form:input path="name" required="true" maxlength="255" /></td>

			</tr>
			<tr>
				<th><form:label path="type">Agreemetn type</form:label></th>
				<td>
					<form:select path="type">
						<form:options items="${types}" />
					</form:select>
				</td>
			</tr>
			
			<tr>
				<th><form:label path="predecessorIndex">Predecessor</form:label></th>
				<td>
					<form:select path="predecessorIndex">
							<form:option value="-1">No predecessor</form:option>
							<form:options items="${predecessors}" />
						</form:select>
				</td>
			</tr>
			
			<tr>
				<th><form:label path="validFromString">Valid from</form:label></th>
				<td>
					<form:input path="validFromString" type="date" required="true"/>
				</td>
			</tr>
			<tr>
				<th><form:label path="validToString">Valid to</form:label></th>
				<td>
					<form:input path="validToString" type="date" required="true"/>
				</td>
			</tr>

			<tr>
				<th colspan="2"><form:label path="serviceDescription">Service description</form:label></th>
			</tr>
			<tr>
				<td colspan="2">
					<form:textarea path="serviceDescription" cols="40" rows="15"  required="true"/>
				</td>
			</tr>
			
			<tr>
				<th colspan="2"><form:label path="slaDescription">SLA description</form:label></th>
			</tr>
			<tr>
				<td colspan="2">
					<form:textarea path="slaDescription" cols="40" rows="15"/>
				</td>
			</tr>
			
			<tr>
				<th colspan="2"><form:label path="securityDescription">Security description</form:label></th>
			</tr>
			<tr>
				<td colspan="2">
					<form:textarea path="securityDescription" cols="40" rows="15"/>
				</td>
			</tr>

			<tr>
				<td colspan="2">
					<form:input path="id" type="hidden"/>
					<input type="submit" value="Save"/>
				</td>
			</tr>
			</table>
		</fieldset>
		</form:form>
    	
    </jsp:body>
</t:authLayout>

