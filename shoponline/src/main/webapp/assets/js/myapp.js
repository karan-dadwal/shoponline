$(function() {

	// fixing menu select problem
	switch (menu) {

	case 'Contact Us':
		$('#contact').addClass('active');
		break;

	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
		
	case 'Home':
		$('#home').addClass('active');
		break;

	default:
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');

		break;
	}
	/*
	 * //for datatables demo data
	 * 
	 * var products = [ [ '1', "axj" ], [ '2', "asa" ], [ '3', "asf" ], [ '4',
	 * "shgfh" ], [ '5', "dhdb" ], [ '6', "bsgsdfg" ], [ '7', "sssssfg" ] ];
	 */
	var $table = $('#listProductsTable');
	if ($table.length) {

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + "/json/data/all/products";
		} else {
			jsonUrl = window.contextRoot + "/json/data/category/"
					+ window.categoryId + "/products";

		}

		$table
				.DataTable({
					lengthMenu : [ [ 3, 5, -1 ],
							[ '3 records', '5 records', 'ALL' ] ],
					pageLength : 3,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [

							{
								data : 'code',
								mRender : function(data, type, row) {
									var str = '';
									str += '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="dataTableImg"/>';
									return str;
								}
							},

							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return "&#8377; " + data;
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1)
										return "<span style='color: red'>Out of Stock</span>";
									return data;
								}

							},
							{
								data : 'id',
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"/></span></a>';

									if (row.quantity < 1)
									{
											str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"/></span></a>';
									}
									else
									{
										str += '<a href="'
												+ window.contextRoot
												+ '/cart/add/'
												+ data
												+ '/	product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"/></span></a>';
									}
									return str;
								}

							}

					]
				});
	}
	
	var $alert = $('.alert');
	if($alert.length)
	{
		setTimeout(function(){
			$alert.fadeOut('slow');
		}, 3000);
	}
});