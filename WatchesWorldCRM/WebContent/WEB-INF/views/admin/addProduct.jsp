<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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


<!-- Switchery -->
<link href="../resources/vendors/switchery/dist/switchery.min.css"
	rel="stylesheet">


<link href="<c:url value="../resources/css/app/jquery-confirm.css" />"
	rel="stylesheet">

<link href="<c:url value="../resources/css/app/kc.fab.css" />"
	rel="stylesheet">

<link href="<c:url value="../resources/css/app/jquery-ui.min.css" />"
	rel="stylesheet">

<link
	href="<c:url value="../resources/css/app/jquery-ui.theme.min.css" />"
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

			<!-- ------------------------------------------ Start Form --------------------------------------------- -->

			<div class="right_col" role="main">
				<spring:url value="/products/saveProduct" var="saveProductUrl" />

				<form:form method="POST" enctype="multipart/form-data"
					action="${saveProductUrl}?${_csrf.parameterName}=${_csrf.token}"
					class="form-horizontal form-label-left" modelAttribute="product">

					<!-- ------------------------------------------ Main Product Info --------------------------------------------- -->

					<span class="section">Main Product Information</span>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="brand">Brand<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" id="brand" name="brand" required="required"
								class="form-control col-md-7 col-xs-12">
						</div>
					</div>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="model">Model<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" id="model" name="model" required="required"
								class="form-control col-md-7 col-xs-12">
						</div>
					</div>
					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="productReference">Reference<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" id="productReference" name="productReference"
								required="required" class="form-control col-md-7 col-xs-12">
						</div>
					</div>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="dial">Dial<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">

							<input type="text" id="dialId" name="dial" required="required"
								class="form-control col-md-7 col-xs-12">
						</div>
					</div>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="year">Year<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">

							<input type="text" id="yearId" name="year" required="required"
								class="form-control col-md-7 col-xs-12"
								data-inputmask="'mask' : '9999'">
						</div>
					</div>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="condition">Condition<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">

							<input type="text" id="conditionId" name="condition"
								required="required" class="form-control col-md-7 col-xs-12">
						</div>
					</div>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="availabilityStatus">Availability Status<span
							class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">

							<input type="text" id="availabilityStatusId"
								name="availabilityStatus" required="required"
								class="form-control col-md-7 col-xs-12">
						</div>
					</div>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="cost">COST €<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">

							<input type="text" id="costId"
								data-inputmask="'mask' : '99,999,99'" required="required"
								class="form-control col-md-7 col-xs-12">
						</div>
					</div>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="sellingPrice">Selling Price<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">

							<input type="text" id="sellingPriceId"
								data-inputmask="'mask' : '99,999,99'" required="required"
								class="form-control col-md-7 col-xs-12">
						</div>
					</div>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="paymentStatus">Payment Status<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">

							<input type="text" id="paymentStatus" name="paymentStatus"
								required="required" class="form-control col-md-7 col-xs-12">
						</div>
					</div>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="profit">Profit €€<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">

							<input type="text" id="profit"
								name="costDetails.costDetailsCurrencies[0].profit"
								required="required" class="form-control col-md-7 col-xs-12">
						</div>
					</div>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="profitPercentage">Profit %%<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">

							<input type="text" id="profitPercentage"
								name="costDetails.costDetailsCurrencies[0].profitPercentage"
								required="required" class="form-control col-md-7 col-xs-12">
						</div>
					</div>

					<!-- ------------------------------------------End Main Product Info --------------------------------------------- -->

					<!-- ------------------------------------------ Product Details --------------------------------------------- -->

					<span class="section">Product Details</span>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="productCase">Case<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">

							<input type="text" id="productCaseId" name="productCase"
								required="required" class="form-control col-md-7 col-xs-12">
						</div>
					</div>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="bracelet">Bracelet<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">

							<input type="text" id="braceletId" name="bracelet"
								required="required" class="form-control col-md-7 col-xs-12">
						</div>
					</div>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="serial">Serial<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">

							<input type="text" id="serialId" name="serial"
								required="required" class="form-control col-md-7 col-xs-12">
						</div>
					</div>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="hasBox">Box<span class="required"></span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="checkbox" name="hasBox" class="js-switch" />
						</div>
					</div>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="hasPapers">Papers<span class="required"></span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="checkbox" name="hasPapers" class="js-switch" />
						</div>
					</div>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12" for="rrp">RRP<span
							class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" id="rrp" data-inputmask="'mask' : '99,999,99'"
								required="required" class="form-control col-md-7 col-xs-12">
						</div>
					</div>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="costPound">COST £<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">

							<input type="text" id="costPoundId"
								data-inputmask="'mask' : '99,999,99'" required="required"
								class="form-control col-md-7 col-xs-12">
						</div>
					</div>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="costUSD">COST $<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">

							<input type="text" id="costUSDId"
								data-inputmask="'mask' : '99,999,99'" required="required"
								class="form-control col-md-7 col-xs-12">
						</div>
					</div>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="extraCost">Extra Cost<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">

							<input type="text" id="extraCost"
								name="costDetails.costDetailsCurrencies[0].extraCost"
								required="required" class="form-control col-md-7 col-xs-12">
						</div>
					</div>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="actuallySold">Actually Sold<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">

							<input type="text" id="actuallySold"
								data-inputmask="'mask' : '99,999,99'" required="required"
								class="form-control col-md-7 col-xs-12">
						</div>
					</div>

					<!-- ------------------------------------------End Product Details --------------------------------------------- -->
					<!-- ------------------------------------------ Location & Parties Details --------------------------------------------- -->

					<span class="section">Locations And Parties Details</span>



					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="currentLocation">Current Location<span
							class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">

							<input type="text" id="currentLocationId" name="currentLocation"
								required="required" class="form-control col-md-7 col-xs-12">
						</div>
					</div>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="boughtFromCountry">Country Bought From<span
							class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">

							<input type="text" id="countryBoughtFromId"
								name="boughtFromCountry" required="required"
								class="form-control col-md-7 col-xs-12">
						</div>
					</div>


					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="supplierName">Supplier<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">

							<input type="text" id="supplierNameId" name="supplierName"
								required="required" class="form-control col-md-7 col-xs-12">
						</div>
					</div>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="soldInCountry">Country Sold<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">

							<input type="text" id="countrySoldInId" name="soldInCountry"
								required="required" class="form-control col-md-7 col-xs-12">
						</div>
					</div>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="clientName">Client<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">

							<input type="text" id="clientNameId" name="clientName"
								required="required" class="form-control col-md-7 col-xs-12">
						</div>
					</div>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="clientAge">Age<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">

							<input type="text" id="clientAgeId"
								data-inputmask="'mask' : '99'" required="required"
								class="form-control col-md-7 col-xs-12">
						</div>
					</div>


					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="clientAge">Gender<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">

							<p>
								M: <input type="radio" class="flat" name="gender" id="genderM"
									value="M" checked="" required /> F: <input type="radio"
									class="flat" name="gender" id="genderF" value="F" />
							</p>

						</div>
					</div>

					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="clientAge">Picture<span class="required">*</span>
						</label>
						<div class="card-body">
							<label class="custom-file-upload"> <input
								class="btn btn-primary btn-round" type="file" name="file" />

							</label>
						</div>
					</div>



					<!-- ------------------------------------------End Location & Parties Details --------------------------------------------- -->
					<div class="ln_solid"></div>
					<div class="form-group">
						<div class="col-md-6 col-md-offset-3">
							<button class="btn btn-primary">Cancel</button>

							<button id="send" type="submit" class="btn btn-success">Submit</button>
						</div>
					</div>


					<input type="text" id="ageMaskValueId" name="clientAge" />
					<input type="text" id="costEuroMaskValueId"
						name="costDetails.costDetailsCurrencies[0].cost" />
					<input type="text" id="sellingPriceMaskValueId"
						name="costDetails.costDetailsCurrencies[0].sellingPrice" />
					<input type="text" id="actuallySoldMaskValueId"
						name="costDetails.costDetailsCurrencies[0].actuallySold" />
					<input type="text" id="rrpMaskValueId"
						name="costDetails.costDetailsCurrencies[0].rrp" />
					<input type="text" id="costPoundMaskValueId"
						name="costDetails.costDetailsCurrencies[1].cost" />
					<input type="text" id="costUSDMaskValueId"
						name="costDetails.costDetailsCurrencies[2].cost" />

				</form:form>
			</div>
			<!-- ------------------------------------------ End Form --------------------------------------------- -->


		</div>

	</div>

	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />


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
	<script src="../resources/vendors/validator/validator.js"></script>

	<!-- jquery.inputmask -->
	<script
		src="../resources/vendors/jquery.inputmask/dist/min/jquery.inputmask.bundle.min.js"></script>

	<!-- Switchery -->
	<script src="../resources/vendors/switchery/dist/switchery.min.js"></script>

	<script src="../resources/js/app/kc.fab.min.js"></script>

	<script src="../resources/js/app/jquery-confirm.js"></script>

	<script src="../resources/js/app/jquery-ui.min.js"></script>

	<script src="../resources/js/app/custom.min.js"></script>

	<script src="../resources/js/app/products.js"></script>
	<script type="text/javascript">
		$(function() {

			$(document).on("keypress", "#costId", function() {
				calculateProfit();
			});

			$(document).on("keypress", "#actuallySold", function() {
				calculateProfit();
			});
		});

		function calculateProfit() {

			var cost = parseFloat($('#costId').val().replace(/,/g, ''));
			var actuallySold = parseFloat($('#actuallySold').val().replace(
					/,/g, ''));

			var profit = actuallySold - cost;
			var percProfit = (profit * 100) / actuallySold;

			var costEuroMaskValueId = parseFloat($('#costId').val().replace(
					/,/g, ''));
			var sellingPriceMaskValueId = parseFloat($('#sellingPriceId').val()
					.replace(/,/g, ''));
			var actuallySoldMaskValueId = parseFloat($('#actuallySold').val()
					.replace(/,/g, ''));

			var rrpMaskValueId = parseFloat($('#rrp').val().replace(/,/g, ''));

			var costPoundMaskValueId = parseFloat($('#costPoundId').val()
					.replace(/,/g, ''));

			var costUSDMaskValueId = parseFloat($('#costUSDId').val().replace(
					/,/g, ''));

			$("#costEuroMaskValueId").val(costEuroMaskValueId);
			$("#sellingPriceMaskValueId").val(sellingPriceMaskValueId);
			$("#actuallySoldMaskValueId").val(actuallySoldMaskValueId);
			$("#rrpMaskValueId").val(rrpMaskValueId);

			$('#profit').val(profit);
			$('#profitPercentage').val(Math.floor(percProfit));
		}

		$(function() {

			$(document).on("keypress", "#clientAgeId", function() {
				var ageMaskValueId = $('#clientAgeId').val();
				$("#ageMaskValueId").val(ageMaskValueId);
			});

		});

		$("#costId").focusout(function() {
			echangeForPound();
			echangeForUSD();
		});

		function echangeForPound() {

			$
					.ajax({
						type : 'GET',
						dataType : 'json',
						url : 'https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE',
						data : {
							"from_currency" : 'EUR',
							"to_currency" : 'GBP',
							"apikey" : "QXESV1T25SDFQL3A"

						},
						cache : false,
						success : function(data) {
							var rate = data['Realtime Currency Exchange Rate']['5. Exchange Rate'];

							var costInEuro = parseFloat($('#costId').val()
									.replace(/,/g, ''));

							var finalValue = costInEuro * rate;
							$("#costPoundMaskValueId").val(finalValue);
							$("#costPoundId").val(finalValue);
						},
						error : function(xhr) {
							alert('Error getting exchange rate');
						}
					});

		}

		function echangeForUSD() {

			$
					.ajax({
						type : 'GET',
						dataType : 'json',
						url : 'https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE',
						data : {
							"from_currency" : 'EUR',
							"to_currency" : 'USD',
							"apikey" : "QXESV1T25SDFQL3A"

						},
						cache : false,
						success : function(data) {
							var rate = data['Realtime Currency Exchange Rate']['5. Exchange Rate'];

							var costInEuro = parseFloat($('#costId').val()
									.replace(/,/g, ''));

							var finalValue = costInEuro * rate;
							$("#costUSDId").val(finalValue);
							$("#costUSDMaskValueId").val(finalValue);
						},
						error : function(xhr) {
							alert('Error getting exchange rate, please enter and exit COST € field again!!!');
						}
					});

		}
	</script>
</body>
</html>