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
	
	
	var $table = $('#productListTable');
	
	if($table.length){
		//console.log('Inside the table!');
		
		var jsonUrl = '';
		if(window.categoryId == ''){
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}else{
			jsonUrl = window.contextRoot + '/json/data/category/' + window.categoryId + '/products';
		}
		
		$table.DataTable({
			
			lengthMenu: [[3,5,10,-1], ['3 Itens', '5 Itens', '10 Itens', 'All']],
			pageLength: 5,
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
				{
					data: 'name'
				},
				{
					data: 'brand'
				},
				{
					data: 'unitPrice',
					mRender: function(data, type, row){
						return 'R$ ' + data
					}
						
				},
				{
					data: 'quantity'
				},
				{
					data: 'id',
					bSortable: false,
					mRender: function(data, type, row){
						
						var str = '';
						str += '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160';
						str += '<a href="'+window.contextRoot+'/car/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
						
						return str;
					}
				}
			]		
		});
	}

});
