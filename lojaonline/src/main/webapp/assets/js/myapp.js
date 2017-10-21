$(function(){
	
	switch(menu){
	
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	default:
		if(menu == "Home") break;
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	
	}
	
	
	//codigo para o dataTable
	//criar um dataset
	var products = [
		
		['1', 'ABC'],
		['2', 'CYX'],
		['3', 'PQR'],
		['4', 'MNO'],
		['5', 'WVB'],
		['6', 'CFG'],
		['7', 'HIK'],
		['8', 'LMP']
		
	];
	
	var $table = $('#productListTable');
	
	if($table.length){
		//console.log('Inside the table!');
		$table.DataTable({
			
			lengthMenu: [[3,5,10,-1], ['3 Itens', '5 Itens', '10 Itens', 'All']],
			pageLength: 5,
			data: products
		});
	}

});
