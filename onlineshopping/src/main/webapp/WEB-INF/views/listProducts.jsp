<div class="container">

	<div class="row">
		<div class="col-md-3">
		
		<%@include file="./shared/sidebar.jsp" %>
		</div>
		
		<div class="col-md-9">
		
			<div class="row">
				<div class="col-lg-12">
				
				<c:if  test="${userClickAllProduct == true}">
					<script>
						window.categoryId='';
					</script>
					<ol class="breadcrumb">
							<li><a href="${contextRoot}">Home</a></li>
							<li class="active">All Products</li>							
								
							
					</ol>
				</c:if>
				
				<c:if  test="${userClickCategoryProduct == true}">
					<script>
						window.categoryId='${category.getId()}';
					</script>
					<ol class="breadcrumb">
							<li><a href="${contextRoot}">Home</a></li>
							<li class="active">Category</li>
							<li class ="active"> ${category.getName()} </li>							
							<li class ="glyphicon glyphicon-eye-open"> </li>							
							
							
					</ol>
				</c:if>
				
					
				</div>
			</div>
		
			<div class="row">
			
				<div class="col-xs-12">
				
					<table id = "productListTable" class="table table-striped table-borderd">
						<thead>
							<tr>
								<th> Name</th>
								<th> Name</th>
								<th> Brand</th>
								<th> Price</th>
								<th> Quantity</th>	
								<th> </th>		
									
																				    							
							</tr>
						
					    </thead>
					
						<tfoot>
							<tr>
								<th> Name</th>
								<th> Name</th>
								<th> Brand</th>
								<th> Price</th>
								<th> Quantity</th>		
								<th> </th>		
																			    							
							</tr>
						
					    </tfoot>
					</table>
					</div>
			</div>
		</div>
	
	</div>
</div>