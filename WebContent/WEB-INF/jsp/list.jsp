<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:authLayout>
    <jsp:attribute name="pageTitle">Agreements</jsp:attribute>
    
    <jsp:body>
    	<h3>Your agreements</h3>
		<table class="list">
			<tr>
				<th>Name</th>
				<th>Valid from</th>
				<th>Valid to</th>
				<th>View</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		<c:forEach var="agreement" items="${agreements}" varStatus="status">
			<tr>
				<td>${agreement.name}</td>
				<td class="middle">
					<c:if  test="${agreement.validFrom != null}">
						<fmt:formatDate value="${agreement.validFrom}" pattern="yyyy-MM-dd" /> 
					</c:if>
				</td>
				<td class="middle">
					<c:if  test="${agreement.validTo != null}">
						<fmt:formatDate value="${agreement.validTo}" pattern="yyyy-MM-dd" /> 
					</c:if>
				</td>
				<td class="middle">
					<a href="<c:url value="/agreement/view?index=${status.index}"/>" title="View" class="view">
					<span>Edit</span>
					</a>
				</td>
				<td class="middle">
					<a href="<c:url value="/agreement/edit?index=${status.index}"/>" title="Edit" class="edit">
					<span>Edit</span>
					</a>
				</td>
				<td class="middle">
					<a href="<c:url value="/agreement/delete?index=${status.index}"/>" title="Delete" class="delete" onClick="return confirm('Are you sure you want to delete this agreement? This operation cannot be undone.')">
					<span>Delete</span>
					</a>
				</td>
		</c:forEach>
		
		<c:if test="${agreements} == null">
			<tr>
				<td class="middle">No agreements found</td>
			</tr>
		</c:if>
		
		</table>
    </jsp:body>
</t:authLayout>

