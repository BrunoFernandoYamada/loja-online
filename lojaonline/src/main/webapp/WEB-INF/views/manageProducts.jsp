<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- h-100 ocupa toda area horizontal -->
<div class="container h-100">
	<!-- h-100 ocupa toda area horizontal e align-items-center justify-content-center alinham horizontalmente-->
	<div class="row align-items-center justify-content-center h-100">

		<c:if test="${not empty message}">

			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>

					${message}
				</div>

			</div>

		</c:if>


		<div class="col-md-offset-2 col-md-8">

			<div class="card card-primary card-inverse">

				<div class="card-header">

					<h4>Product Management</h4>

				</div>

				<div class="card-body">

					<!-- FORM ELEMENT -->
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">

						<div class="form-group row">
							<label class="col-form-label col-md-4" for="name">Nome do
								Produto</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name"
									placeholder="nome do produto" class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em"></sf:errors>
							</div>
						</div>

						<div class="form-group row">
							<label class="col-form-label col-md-4" for="brand">Marca</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="Marca" class="form-control" />
								<sf:errors path="brand" cssClass="help-block" element="em"></sf:errors>
							</div>
						</div>

						<div class="form-group row">
							<label class="col-form-label col-md-4" for="description">Descrição</label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description" rows="4"
									placeholder="escreva a descrição do produto" />
								<sf:errors path="description" cssClass="help-block" element="em"></sf:errors>
							</div>
						</div>

						<div class="form-group row">
							<label class="col-form-label col-md-4" for="unitPrice">Preço
								unitário</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice"
									placeholder="Preço unitário em R$" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em"></sf:errors>
							</div>
						</div>

						<div class="form-group row">
							<label class="col-form-label col-md-4" for="quantity">Quantidade</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity"
									placeholder="Quantidade disponível" />
							</div>
						</div>

						<!-- file element for image upload -->
						<div class="form-group row">
							<label class="col-form-label col-md-4" for="file">Imagem</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="form-control" />
								<sf:errors path="file" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="col-form-label col-md-4" for="categoryId">Selecione
								uma categoria</label>
							<div class="col-md-8">
								<sf:select class="form-control" id="categoryId"
									path="categoryId" items="${categories}" itemLabel="name"
									itemValue="id" />
								<c:if test="${product.id==0}">
									<div class="text-right">
										<br />
										<button type="button" data-toggle="modal"
											data-target="#myCategoryModal" class="btn btn-warning btn-sm">Adicionar
											Categoria</button>
									</div>
								</c:if>

							</div>
						</div>

						<div class="form-group row">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit"
									class="brn btn-primary">
								<!-- Hidden fields for products -->
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="active" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />

							</div>
						</div>

					</sf:form>

				</div>

			</div>

		</div>

	</div>

	<div class="row">
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<h3>Produtos Disponíveis</h3>
			<hr />
		</div>
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<div style="overflow: auto">
				<table id="adminProductsTable"
					class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Id</th>
							<th>&#160</th>
							<th>Brand</th>
							<th>Name</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</thead>


					<tfoot>
						<tr>
							<th>Id</th>
							<th>&#160</th>
							<th>Brand</th>
							<th>Name</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</tfoot>
				</table>

			</div>
		</div>

	</div>

	<div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="model-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<h4 class="modal-title">Adicinar nova Categoria</h4>
				</div>
				<div class="modal-body">
					<!-- Categoria Form -->
					<sf:form modelAttribute="category" action="${contextRoot}/manage/category" method="POST" class="form-horizontal">
						<div class="form-group">
							<label for="name" class="control-label col-md-4">Nome da Categoria</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name" cssClass="form-control"/>
							</div>
						</div>
						
						<div class="form-group">
							<label for="category_description" class="control-label col-md-4">Descrição da Categoria</label>
							<div class="col-md-8">
								<sf:textarea rows="5" path="description" id="category_description" cssClass="form-control"/>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8" >
								<input type="submit" value="Add Category" class="btn btn-primary"/>	
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>