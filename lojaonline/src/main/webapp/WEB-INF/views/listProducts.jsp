<div class="container">
	<div class="row">
		<!-- Mostrará o sidebar -->
		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>

		</div>

		<!--  Mostrará o produto atual -->
		<div class="col-md-9">

			<div class="row">

				<div class="col-lg-12">
					<c:if test="${userClickAllProducts == true}">
						<ol class="breadcrumb">

							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="active breadcrumb-item">All Products</li>

						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts == true}">
						<ol class="breadcrumb">

							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="active breadcrumb-item">Category</li>
							<li class="active breadcrumb-item">${category.name}</li>

						</ol>
					</c:if>



				</div>
			</div>

		</div>
	</div>
</div>