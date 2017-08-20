<div class="container">
	<div class="row">
		<div class="col-md-3">

			<!--  for sidebar -->
			<%@include file="./shared/sidebar.jsp"%>

		</div>

		<div class="col-md-9">
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${clickAllProducts == true}">
						<!-- Listing all category products -->
						<script>
							window.categoryId = ''
						</script>
						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>

						</ol>
					</c:if>

				</div>
				<c:if test="${clickCategoryProducts == true}">
					<!-- Listing category wise products -->

					<script>
						window.categoryId = '${category.id}';
					</script>

					<ol class="breadcrumb">

						<li><a href="${contextRoot}/home">Home</a></li>
						<li class="active">Category</li>
						<li class="active">${category.name}</li>
					</ol>
				</c:if>

			</div>

			<!--  For jquery datatables -->
			<div class="row">
				<div class="col-xs-12">

					<table id="listProductsTable"
						class="table table-striped table-bordered">
						<thead>
							<tr>
							<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Available Qty</th>
								<th></th>
							</tr>

						</thead>

						<tfoot>
							<tr>
							<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Available Qty</th>
								<th></th>
							</tr>

						</tfoot>

					</table>
				</div>

			</div>
		</div>


	</div>
</div>
