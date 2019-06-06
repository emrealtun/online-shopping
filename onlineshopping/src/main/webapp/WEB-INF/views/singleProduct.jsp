
<div class="container">
	<div class=row">
		<div class="col-xs-12">

			<div class=breadcrumb">

				<a href="${contextRoot}/home">Home /</a>
				<a href="${contextRoot}/show/all/products">Products /</a>
				<span class="active">${product.getName()}</span>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-xs-12 col-sm-4">

			<img src="${images}/${product.getCode()}.jpg" class="img img-responsive" />
		</div>
		<div class="col-xs-12 col-sm-8">

			<h3>${product.getName()}</h3>
			</hr>
			<p>${product.getDescription()}</p>
			</hr>
			<h4>
				Price: <strong> &#8378; ${product.getUnitPrice()} </strong>
			</h4>
			</hr>
			
			<c:choose>
				<c:when test ="${product.getQuantity() < 1 }">
				
							<h6>Avaible quantity: <span style="color:red;">Out of Stock</span></h6>
							<a href="javascript:void(0)" class="btn btn-success disabled">
							<strike> <span class="glyphicon glyphicon-shopping-cart"/> Add to Cart</strike></a>
							<a href="${contextRoot}/show/all/products" class="btn btn-primary disabled"><span class ="glyphicon glyphicon-cart"><strike>Add to Bag</strike></span></a>
							
			
				</c:when>
				
				<c:otherwise>
							<h6>Avaible quantity: ${product.getQuantity()}</h6>
							<a href="${contextRoot}/cart/add/${product.getId()}/product" class="btn btn-success">
							<a href="${contextRoot}/show/all/products" class="btn btn-primary">Add to Bag</a>
							
			<span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart</a>
				 
				</c:otherwise>
				
			</c:choose>
			
	
				 

		</div>
	</div>

</div>