<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ul id="submenu">
	<li>
		<a href="<c:url value="/agreement/new"/>" >Basic informations</a>
	</li>
	<li>
		<a href="<c:url value="/agreement/involved-parties"/>" >Involved parties</a>
	</li>
	<li>
		<a href="<c:url value="/agreement/service-hours"/>" >Service hours</a>
	</li>
	<li>
		<a href="<c:url value="/agreement/customer-support"/>" >Customer support</a>
	</li>
	<li>
		<a href="<c:url value="/agreement/change-management"/>" >Change management</a>
	</li>
	<li>
		<a href="<c:url value="/agreement/glossaries"/>" >Glossaries</a>
	</li>
	<li>
		<a href="<c:url value="/agreement/performance"/>" >Performance</a>
	</li>
	<li>
		<a href="<c:url value="/agreement/availability"/>" >Availability</a>
	</li>
	<li>
		<a href="<c:url value="/agreement/reports"/>" >Reports</a>
	</li>
	<li>
		<strong></strong>
		<a href="<c:url value="/agreement/save"/>" class="save" title="You have to save the agreemnt to upload it on sever.">Save</a>
	</li>
</ul>