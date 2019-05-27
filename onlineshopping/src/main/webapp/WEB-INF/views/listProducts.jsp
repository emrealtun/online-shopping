<div class="container">

	<div class="row">
		<div class="col-md-3">
		
		<%@include file="./shared/sidebar.jsp" %>
		</div>
		
		<div class="col-md-9">
		
			<div class="row">
				<div class="col-lg-12">
				
				<c:if  test="${userClickAllProduct==true}">
					<script>
						window.categoryId='';
					</script>
					<ol class="breadcrumb">
							<li><a href="${contextRoot}">Home</a></li>
							<li class="active">All Products</li>							
								
							
					</ol>
				</c:if>
				
				</br>
				</br>
				</br>
					<table id = "productListTable" class="table table-striped table-borderd">
						<thead>
							<tr>
								<th> ID</th>
								<th> Name</th>
														    							
							</tr>
						
						
					    </thead>
					
					</table>
				</div>
			</div>
		
		</div>
	
	</div>
</div>