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


	var products = [
						['1','QWE'],
						['2','FGH'],
						['3','SDF'],
						['4','CVB'],
						['5','DFG'],
						['6','JKL'],
						['7','IUY'],
						['8','YJM'],
				   ];
	
	
	var $table= $('#productListTable');
	
	
	if($table.length)
		{
			console.log('inside the table');
			
			$table.DataTable({
				data:products,
				lengthMenu: [[3,5,10,-1],['3 ENTRY','5 ENTRY','10 ENTRY']],
				pageLength: 5
				
			});
		}
	