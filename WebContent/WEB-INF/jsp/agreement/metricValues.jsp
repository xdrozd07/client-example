<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:authLayout>
    <jsp:attribute name="pageTitle">Captured Values</jsp:attribute>
    
    <jsp:body>
    <t:submenu/>
    	<h2>Captured Values</h2>

		<table class="list">
			<tr>
				<th>Date</th>
				<th>Value</th>
			</tr>	
			<c:forEach var="value" items="${values}" varStatus="status">
			<tr>
				<td class="middle">
					<c:if  test="${value.captured != null}">
						<fmt:formatDate value="${value.captured}" pattern="yyyy-MM-dd [HH:mm]" />
					</c:if>
				</td>
				<td class="middle"><c:if  test="${value.value != null}">${value.value}</c:if></td>
			</tr>
			</c:forEach>
    	</table>

    </jsp:body>
</t:authLayout>

