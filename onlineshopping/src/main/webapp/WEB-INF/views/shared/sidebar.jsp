<h1 class="my-4">Shop Name</h1>
        <div class="list-group">
        
        
        <c:forEach items="${categories}"  var="category">
         
           <a href="${contextRoot}/show/category/${category.getId()}/products" id="a_${category.getName()} " class="list-group-item">${category.getName()}</a>
        
        </c:forEach>
        
        </div>
