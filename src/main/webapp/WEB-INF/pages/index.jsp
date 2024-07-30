<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Report_Generator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
</head>

 
<body>
	<div class="container my-4" >
	<div class="mb-4">
		<h1 class="pb-3 pt-3 text-center">Report Application</h1>
	</div>
		<form:form action="search" modelAttribute="search" method="post">
			<table  class="table">
			<tbody>
			<tr>
				<td >PlanName:</td>
				<td>
					<form:select path="planName" class="form-select">
						<form:option value="">-Select-</form:option>
						<form:options items="${names}"/>
					</form:select>
				</td>
				
				<td>PlanStatus:</td>
				<td>
					<form:select path="planStatus" class="form-select">
						<option value="">-Select-</option>
						<form:options items="${status}"/>
					</form:select>
				</td>
				<td>Gender:</td>
				<td>
					<form:select path="gender" class="form-select">
						<form:option value="">-Select-</form:option>
						<form:option value="Male">Male</form:option>
						<form:option value="Fe-Male">Fe-male</form:option>
					</form:select>
				</td>
			</tr>
			
			<tr>
				<td>Start Date:</td>
				<td>
				 <form:input  path="planStartDate" type="date" pattern="yyyy-mm-dd" class="form-control"></form:input>	
				</td>
				<td>End Date:</td>
				<td>
				 <form:input  path="planEndDate" type="date" pattern="yyyy-mm-dd" class="form-control"></form:input>	
				</td>
				
			</tr>
			
			
			<div class="text-end">
				<td >
					<a href="/" class="btn btn-secondary">Reset</a>
				</td>
				<td >
					<input type="submit" value="search" class="btn btn-primary">
				</td>
			</div>
		
			
			</tbody>
			</table>
		
		</form:form>
		<hr/>
		<div class="table-responsive">
		<table class="table table-striped table-bordered table-hover">
			<thead class="table-dark">
				<tr>
					<th>S.NO</th>
					<th>Holder Name</th>
					<th>Gender</th>
					<th>Plan Name</th>
					<th>Plan Status</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>BenifitAmount</th>
				</tr>
				<tr>
					
						 <c:forEach var = "i" items="${plans}" varStatus="index">
						 <tr>
						 	<td>${index.count }</td>
						 	<td>${i.citizenName}</td>
							<td>${i.gender }</td>
							<td>${i.planName }</td>
							<td>${i.planStatus }</td>
							<td>${i.planStartDate }</td>
							<td>${i.planEndDate }</td>
							<td>${i.benifitAmount }</td>
						</tr>
					      </c:forEach>
						
					
				</tr>
				<tr>
					<td colspan="8" class="text-center">
						<c:if test="${empty plans }">
							 <div class="d-flex justify-content-center align-items-center">
							 	<i class="bi bi-info-circle text-primary fs-3 me-2">>
															 	
							 	</i>
							 	<span>No Record Found</span>
								
							</div>
						</c:if>
					</td>
				</tr>
			</thead>		
		</table>
		</div>
		<hr/>
		 <div class="text-end">
            Export: <a href="excel" class="btn btn-secondary btn-sm ">Excel</a>
            <a href="pdf" class="btn btn-secondary btn-sm">PDF</a>
        </div>
		
		
	</div>
	

</body>

</html>