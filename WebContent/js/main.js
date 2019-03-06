var rootUrl = "http://localhost:8080/store/rest/product";

var findAll = function() {
	$.ajax({
		type : 'GET',
		url : rootUrl + '/all',
		dataType : "json",
		success : renderList
	});

}
function findById(id) {

	$.ajax({
		type : 'GET',
		url : rootUrl + '/' + id,
		dataType : "json",
		success : function(product) {
			$('#btnDelete').show();
			console.log('findById success: ' + product.id);
			currentProduct = product;
			renderDetails(currentProduct);
		}
	});
}

var renderList = function(product) {
	$.each(product, function(index, product) {
		$('#productList').append(
				'<li> <a href = "#" id="' + product.id + '">' + product.name
						+ '</a></li>');

	});
}
function renderDetails(product) {
	$('#productId').val(product.id);
	$('#name').val(product.name);
	$('#category').val(product.category);
	$('#color').val(product.color);
	$('#price').val(product.price);
	$('#dimension').val(product.dimension);
	$('#weight').val(product.weight);
	$('#discount').val(product.discount);
	$('#unitsavailable').val(product.unitsAvailable);
	$('#image').attr('src', 'images/' + product.image);
}

var formToJSON = function() {
	// var productId=$('#productId').val();
	return JSON.stringify({
		"id" : $('#productId').val(),
		"name" : $('#name').val(),
		"category" : $('#category').val(),
		"color" : $('#color').val(),
		"price" : $('#price').val(),
		"dimension" : $('#dimension').val(),
		"weight" : $('#weight').val(),
		"discount" : $('#discount').val(),
		"unitsAvailable" : $('#unitsavailable').val(),
		"image" : $('#pic').attr('src', "pics/generic.jpg").val(),
	});
}
var addProduct = function() {
	console.log('adding product');
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : rootUrl + '/add',
		dataType : "json",
		data : formToJSON(),
		success : function(data, textStatus, jqXHR) {
			alert('product added successfully');
			$('#productId').val(data.id);
			findAll();
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('add product error : ' + textStatus);
		}
	});
}

function newProduct() {
	$('#productId').val("");
	$('#name').val("");
	$('#category').val("");
	$('#color').val("");
	$('#price').val("");
	$('#dimension').val("");
	$('#weight').val("");
	$('#discount').val("");
	$('#unitsavailable').val("");
	$('#image').attr('src', "");
}

// DOM has loaded
$(document).on("click", "#productList a ", function() {
	findById(this.id);
});
$(document).on("click", '#saveButton', function() {

	if ($('#productId').val() == '')
		addProduct();
	else
		updateProduct();
});
$(document).ready(function() {
	findAll();
	$(document).on("click", '#addButton', function() {
		newProduct();
	});
	
});
