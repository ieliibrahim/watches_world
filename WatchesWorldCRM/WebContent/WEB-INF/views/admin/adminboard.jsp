<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="../resources/images/app/favicon.ico"
	type="image/ico" />
<title>Watches World Admin</title>



<link
	href="<c:url value="../resources/vendors/bootstrap/dist/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- Bootstrap -->
<link href="../resources/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="../resources/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="../resources/vendors/nprogress/nprogress.css"
	rel="stylesheet">
<!-- iCheck -->
<link href="../resources/vendors/iCheck/skins/flat/theme.css"
	rel="stylesheet">
<!-- JQVMap -->
<link href="../resources/vendors/jqvmap/dist/jqvmap.min.css"
	rel="stylesheet" />
<!-- bootstrap-progressbar -->
<link
	href="../resources/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css"
	rel="stylesheet">
<!-- bootstrap-daterangepicker -->
<link
	href="../resources/vendors/bootstrap-daterangepicker/daterangepicker.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="../resources/css/app/custom.min.css" rel="stylesheet">

<!-- Datatables -->
<link
	href="../resources/vendors/bootstrap-daterangepicker/daterangepicker.css"
	rel="stylesheet">

<link
	href="../resources/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css"
	rel="stylesheet">
<link
	href="../resources/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css"
	rel="stylesheet">
<link
	href="../resources/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css"
	rel="stylesheet">
<link
	href="../resources/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css"
	rel="stylesheet">
<link
	href="../resources/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css"
	rel="stylesheet">


<link href="<c:url value="../resources/css/app/jquery-confirm.css" />"
	rel="stylesheet">

<link href="<c:url value="../resources/css/app/kc.fab.css" />"
	rel="stylesheet">

</head>

<body class="nav-md">

	<div class="container body">

		<div class="main_container">


			<!-- ------------------------------------------ Main naigation bar --------------------------------------------- -->
			<%@ include file="../common/nav.jsp"%>
			<!-- ------------------------------------------ End Main naigation bar --------------------------------------------- -->

			<!-- ------------------------------------------ End Top naigation bar --------------------------------------------- -->
			<%@ include file="../common/header.jsp"%>
			<!-- ------------------------------------------ End Top naigation bar --------------------------------------------- -->

			<!-- ------------------------------------------ Totals Tiles --------------------------------------------- -->

			<div class="right_col" role="main">
				<!-- top tiles -->
				<div class="row tile_count">
					<div class="col-md-4 col-sm-4 col-xs-6 tile_stats_count">
						<span class="count_top"><i class="fa fa-money"></i> Total
							Profit - ${month}</span>
						<div class="count">${profitEuro}</div>
						<span class="count_bottom"> ${profitPound} ,&nbsp;
							${profitUSD} </span>
					</div>

					<div class="col-md-4 col-sm-4 col-xs-6 tile_stats_count">
						<span class="count_top"><i class="fa fa-female"></i> Total
							Sold - ${month}</span>
						<div class="count">${soldFemale}-Female</div>
						<span class="count_bottom"> ${soldFemalePerc}% </span>
					</div>

					<div class="col-md-4 col-sm-4 col-xs-6 tile_stats_count">
						<span class="count_top"><i class="fa fa-male"></i> Total
							Sold - ${month} </span>
						<div class="count">${soldMale}-Male</div>
						<span class="count_bottom"> ${soldMalePerc}% </span>
					</div>


				</div>


				<!-- ------------------------------------------ End Totals Tiles --------------------------------------------- -->

				<!-- ------------------------------------------ Products Table --------------------------------------------- -->

				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12 ">

						<table id="productsTableId"
							class="table table-striped table-bordered  row-border order-column"
							style="width: 100%">
							<thead>
								<tr>
									<th>INTERNAL REFERENCE</th>
									<th>BRAND</th>
									<th>MODEL</th>
									<th>REFERENCE</th>
									<th>DIAL</th>
									<th>YEAR</th>
									<th>CONDITION</th>
									<th>AVAILABILITY STATUS</th>
									<th>COST €</th>
									<th>SELLING PRICE</th>
									<th>PAYMENT STATUS</th>
									<th>PROFIT IN €€</th>
									<th>PROFIT IN %%</th>

									<th>CASE</th>
									<th>BRACELET</th>
									<th>SERIAL</th>
									<th>BOX</th>
									<th>PAPERS</th>
									<th>RRP</th>
									<th>COST £</th>
									<th>COST $</th>
									<th>EXTRA COSTS</th>
									<th>ACTUALLY SOLD</th>

									<th>CURRENT LOCATION</th>
									<th>COUNTRY BOUGHT FROM</th>
									<th>SUPPLIER</th>
									<th>COUNTRY SOLD</th>
									<th>CLIENT</th>
									<th>AGE</th>
									<th>GENDER</th>
									<th>Edit</th>
									<th>Delete</th>

								</tr>

							</thead>

							<tbody>

								<c:forEach var="productVar" items="${products}"
									varStatus="productIndexVar">


									<tr>
										<td>${productVar.productId}</td>
										<td>${productVar.brand}</td>
										<td>${productVar.model}</td>
										<td>${productVar.productReference}</td>
										<td>${productVar.dial}</td>
										<td>${productVar.productYear}</td>
										<td>${productVar.productCondition}</td>
										<c:choose>
											<c:when test="${productVar.availabilityStatus == true}">
												<td>AVAILABLE</td>
											</c:when>
											<c:otherwise>
												<td>NOT AVAILABLE</td>
											</c:otherwise>
										</c:choose>
										<td>${productVar.costDetails.costDetailsCurrencies[0].cost}</td>
										<td>${productVar.costDetails.costDetailsCurrencies[0].sellingPrice}</td>
										<td>${productVar.paymentStatus}</td>
										<td>${productVar.costDetails.costDetailsCurrencies[0].profit}</td>
										<td>${productVar.costDetails.costDetailsCurrencies[0].profitPercentage}</td>
										<td>${productVar.productCase}</td>
										<td>${productVar.bracelet}</td>
										<td>${productVar.serial}</td>
										<c:choose>
											<c:when test="${productVar.hasPapers == true}">
												<td>YES</td>
											</c:when>
											<c:otherwise>
												<td>NO</td>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${productVar.hasBox == true}">
												<td>YES</td>
											</c:when>
											<c:otherwise>
												<td>NO</td>
											</c:otherwise>
										</c:choose>
										<td>${productVar.costDetails.costDetailsCurrencies[0].rrp}</td>
										<td>${productVar.costDetails.costDetailsCurrencies[2].cost}</td>
										<td>${productVar.costDetails.costDetailsCurrencies[1].cost}</td>
										<td>${productVar.costDetails.costDetailsCurrencies[0].extraCost}</td>
										<td>${productVar.costDetails.costDetailsCurrencies[0].actuallySold}</td>
										<td>${productVar.currentLocation}</td>
										<td>${productVar.boughtFromCountry}</td>
										<td>${productVar.supplierName}</td>
										<td>${productVar.soldInCountry}</td>
										<td>${productVar.clientName}</td>
										<td>${productVar.clientAge}</td>
										<td>${productVar.clientGender}</td>
										<td><sec:authorize access="hasAuthority('EDIT_PRODUCT')">
												<a
													href="location.href='${pageContext.servletContext.contextPath}/products/editProduct/${productVar.productId}'">
													<i class="fa fa-edit"
													style="font-size: 24px; color: #536A7F"></i>
												</a>

											</sec:authorize></td>

										<td><sec:authorize
												access="hasAuthority('DELETE_PRODUCT')">

												<a onclick="setProductID(${productVar.productId})"
													class="deleteProductId"> <i class="fa fa-remove"
													style="font-size: 24px; color: red; cursor: pointer;"></i>
												</a>

											</sec:authorize></td>
									</tr>

								</c:forEach>
							</tbody>
						</table>

					</div>
				</div>
			</div>
			<!-- ------------------------------------------ End Products Table --------------------------------------------- -->

		</div>

	</div>

	<input type="hidden" id="productValueID" />
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />

	<sec:authorize access="hasAuthority('ADD_PRODUCT')">
		<div class="kc_fab_wrapper" style="margin-bottom: 20px;"></div>
	</sec:authorize>

	<!-- jQuery -->
	<script src="../resources/vendors/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="../resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script src="../resources/vendors/fastclick/lib/fastclick.js"></script>
	<!-- NProgress -->
	<script src="../resources/vendors/nprogress/nprogress.js"></script>
	<!-- Chart.js -->
	<script src="../resources/vendors/Chart.js/dist/Chart.min.js"></script>
	<!-- gauge.js -->
	<script src="../resources/vendors/gauge.js/dist/gauge.min.js"></script>
	<!-- bootstrap-progressbar -->
	<script
		src="../resources/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
	<!-- iCheck -->
	<script src="../resources/vendors/iCheck/icheck.min.js"></script>
	<!-- Skycons -->
	<script src="../resources/vendors/skycons/skycons.js"></script>
	<!-- Flot -->
	<script src="../resources/vendors/Flot/jquery.flot.js"></script>
	<script src="../resources/vendors/Flot/jquery.flot.pie.js"></script>
	<script src="../resources/vendors/Flot/jquery.flot.time.js"></script>
	<script src="../resources/vendors/Flot/jquery.flot.stack.js"></script>
	<script src="../resources/vendors/Flot/jquery.flot.resize.js"></script>
	<!-- Flot plugins -->
	<script
		src="../resources/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
	<script
		src="../resources/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
	<script src="../resources/vendors/flot.curvedlines/curvedLines.js"></script>
	<!-- DateJS -->
	<script src="../resources/vendors/DateJS/build/date.js"></script>
	<!-- JQVMap -->
	<script src="../resources/vendors/jqvmap/dist/jquery.vmap.js"></script>
	<script
		src="../resources/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
	<!-- bootstrap-daterangepicker -->
	<script src="../resources/vendors/moment/min/moment.min.js"></script>
	<script
		src="../resources/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

	<script
		src="../resources/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
	<script
		src="../resources/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
	<script
		src="../resources/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
	<script
		src="../resources/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
	<script
		src="../resources/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
	<script
		src="../resources/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
	<script
		src="../resources/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
	<script
		src="../resources/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
	<script
		src="../resources/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
	<script
		src="../resources/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
	<script
		src="../resources/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
	<script src="../resources/vendors/jszip/dist/jszip.min.js"></script>
	<script src="../resources/vendors/pdfmake/build/pdfmake.min.js"></script>
	<script src="../resources/vendors/pdfmake/build/vfs_fonts.js"></script>

	<!-- validator -->
	<script src="../resources/vendors/validator/validator.js"></script>


	<script src="../resources/js/app/kc.fab.min.js"></script>

	<script src="../resources/js/app/jquery-confirm.js"></script>

	<script src="../resources/js/app/jquery-ui.min.js"></script>

	<script type="text/javascript">
		function setProductID(productId){
			
			var productDiv = document.getElementById("productValueID");
			productDiv.value = productId;
		}
</script>

	<script type="text/javascript">
		$('#productsTableId').DataTable({
			responsive : {
				details : {
					type : 'inline',
					renderer: $.fn.dataTable.Responsive.renderer.tableAll( {
		                tableClass: 'ui table'
		            } )
		            //, render: $.fn.dataTable.render.number( ',', '.', 2 )
				}
			}
		});
	</script>


	<script>
		$(document)
				.ready(
						function() {
							var links = [

							{
								"bgcolor" : "#536A7F",
								"color" : "#fff",
								"url" : "${pageContext.servletContext.contextPath}/products/addProduct",
								"title" : "Add Product",
								"icon" : "<i class='fa fa-plus'></i>",
							} ]
							$('.kc_fab_wrapper').kc_fab(links);
						})
	</script>

	<script type="text/javascript">
		$('.deleteProductId')
				.on(
						'click',
						function() {
							$
									.confirm({
										content : '',
										title : 'Delete product?',
										icon : 'fa fa-trash-o',
										theme : 'modern',
										closeIcon : true,
										animation : 'scale',
										type : 'orange',
										buttons : {
											confirm : {
												text : 'Delete?',
												btnClass : 'btn-red',
												action : function() {

													var vehicleDiv = document
															.getElementById("productValueID");
													var vehicleId = vehicleDiv.value;

													$
															.ajax({
																url : '${pageContext.servletContext.contextPath}/products/deleteProduct/'

																		+ vehicleId,
																success : function(
																		response) {
																	location
																			.reload();
																}
															});
												}

											},
											cancel : {
												text : 'Cancel',
												btnClass : 'btn-primary',
											}
										}
									});
						});
	</script>

</body>
</html>