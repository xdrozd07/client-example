<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:authLayout>
    <jsp:attribute name="pageTitle">Reports</jsp:attribute>
    
    <jsp:body>
    <t:submenu/>
    	<h2>Reports</h2>
    	<div class="hint">
			<p>
				If you want to receive periodical report about service operation, you can define plenty of them. All should be named and contain
				some of performance and/or availability metrics.
			</p>
			<p>
				<em>
					<strong>Example: </strong>
					If you wish to receive the report last day every month at 8 AM, select frequency "monthly", day in month set to 31 and hour to 8.
				</em>
			</p>
		</div>
    	
    	<c:url value="/agreement/add-report" var="formAction"/>
    	<form:form action="${formAction}" method="POST">
    		<fieldset>
			<legend>Report</legend>
			
			<table>
				<tr>
					<td><form:label path="name">Name</form:label></td>
					<td><form:input path="name" required="true" maxlength="255"/></td>
				</tr>
				<tr>
					<td><form:label path="hour">Hour</form:label></td>
					<td>
						<form:select path="hour" required="true">
							<form:options items="${hours}"/> 
						</form:select>
					</td>
				</tr>
				<tr>
					<td><form:label path="day">Day in month/week</form:label></td>
					<td>
						<form:select path="day" id="day">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8" class="monthly">8</option>
							<option value="9" class="monthly">9</option>
							<option value="10" class="monthly">10</option>
							<option value="11" class="monthly">11</option>
							<option value="12" class="monthly">12</option>
							<option value="13" class="monthly">13</option>
							<option value="14" class="monthly">14</option>
							<option value="15" class="monthly">15</option>
							<option value="16" class="monthly">16</option>
							<option value="17" class="monthly">17</option>
							<option value="18" class="monthly">18</option>
							<option value="19" class="monthly">19</option>
							<option value="20" class="monthly">20</option>
							<option value="21" class="monthly">21</option>
							<option value="22" class="monthly">22</option>
							<option value="23" class="monthly">23</option>
							<option value="24" class="monthly">24</option>
							<option value="25" class="monthly">25</option>
							<option value="26" class="monthly">26</option>
							<option value="27" class="monthly">27</option>
							<option value="28" class="monthly">28</option>
							<option value="29" class="monthly">29</option>
							<option value="30" class="monthly">30</option>
							<option value="31" class="monthly">31</option>
						</form:select>
					</td>
				</tr>
				<tr>
					<td colspan="2"><span class="note">If you wish the report to be send the last day of month, please set the day number to 31.</span>
				</tr>
				<tr>
					<td><form:label path="frequency">Frequency</form:label></td>
					<td>
						<form:select path="frequency" required="true"  class="frequency">
							<form:option value="">select frequency</form:option>
							<form:options items="${frequency}" />
						</form:select>
					</td>
				</tr>
				<tr>
					<td colspan="2"><form:label path="description">Description</form:label></td>
				</tr>
				<tr>
					<td colspan="2"><form:textarea path="description"  cols="60" rows="10"/></td>
				</tr>
				
			
				<tr>
					<td colspan="2">
						<input type="submit" value="Add"/>
					</td>
				</tr>
			</table>
			</fieldset>
		</form:form>
		
		<h3>Reports</h3>

		<table class="list">
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Frequency</th>
				<th>Hour</th>
				<th>Day</th>
				<th>Contacts</th>
				<th>Metrics</th>
				<th>Delete</th>
			</tr>	
			<c:forEach var="report" items="${reports}" varStatus="status">
			<tr>
				<td><c:if  test="${report.name != null}">${report.name}</c:if></td>
				<td><c:if  test="${report.description != null}">${report.description}</c:if></td>
				<td class="middle">
					<c:if  test="${report.frequency != null}">${report.frequency}</c:if>
				</td>
				<td class="middle">
					<c:if  test="${report.hour != null}">${report.hour}</c:if>
				</td>
				<td class="middle">
					<c:if  test="${report.day != null}">${report.day}</c:if>
				</td>
				
				<td class="middle">
					<a href="<c:url value="/agreement/report-contacts?index=${status.index}"/>" title="Contacts" class="edit">
					<span>"Values"</span>
					</a>
				</td>
				
				<td class="middle">
					<a href="<c:url value="/agreement/report-metrics?index=${status.index}"/>" title="Metrics" class="edit">
					<span>Thresholds</span>
					</a>
				</td>
				
				<td class="middle">
					<a href="<c:url value="/agreement/delete-report?index=${status.index}"/>" title="Delete" class="delete" onClick="return confirm('Are you sure you want to delete this report? This operation cannot be undone.')">
					<span>Delete</span>
					</a>
				</td>
			</tr>
			</c:forEach>
    	</table>


	<script type="text/javascript">
	 $( document ).ready(function(){
	 
		console.log( "ready!" );
		
	 	$('.frequency').change( function() {
	 		
		   
		   if ($('.frequency').val() == 'daily') {
				$('#day').attr('disabled', true);
				console.log("daily");
				
		    } else if($('#frequency').val() == 'weekly'){
		        $('#day').removeAttr('disabled');
				$('.monthly').attr('style', 'display: none;');
				console.log("weekly");
				
		    } else if($('#frequency').val() == 'monthly'){
		        $('#day').removeAttr('disabled');
				$('.monthly').removeAttr('style');
				console.log("monthly");
				
		    } else{
			    console.log("nic");
			}
		});

		$('#frequency').change();
	 });
	 </script>
    </jsp:body>
</t:authLayout>

