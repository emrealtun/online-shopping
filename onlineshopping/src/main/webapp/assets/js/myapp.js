$(function() {

	switch (menu) {
	case 'Home':
		$('#home').addClass('active');
		break;
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProduct').addClass('active');
		break;
	default:
		if(menu==home) break;
		
		$('listProduct').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}
});



	var $table= $('#productListTable');
		
	if($table.length)
		{
			var jsonUrl='';
			if(window.categoryId == '')
				{
				jsonUrl= window.contextRoot + '/json/data/all/products';
				}
			else{
				jsonUrl= window.contextRoot + '/json/data/category/'+window.categoryId+'/products';
			}
			
			$table.DataTable({
				lengthMenu: [[3,5,10,-1],['3 ENTRY','5 ENTRY','10 ENTRY','ALL']],
				pageLength: 5,
				ajax: {
					url: jsonUrl,
					dataSrc: ''
				},
				
				columns:[
					
					{
						data:'code',
						mRender:function(data,type,row){
							return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
						}
					},
					{
						data: 'name'
					},
					{
						data: 'brand'
					},
					{
						data: 'unitPrice',
						mRender :function(data,type,row){
								return data + '&#8378;'
						}
						
					},
					{
						data: 'quantity',
						mRender:function(data,type,row){
							if(data<1){
								return '<span style="color:red;">Out of Stock</span>'; 
										
							}
							return data;
						}
					},
					{
						data: 'id',
						bSortable: false,
						mRender :function(data,type,row){
						var  str='';
						
						if(row.quantity<1)
							{
							str += '<a href="javascript.void(0)" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
							}
						else{
							str += '<a href="'+ window.contextRoot + '/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';

						}
						
						str += '<a href="'+ window.contextRoot + '/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';

						return str;
							
					}
						
					}
				]
			});
		}
	