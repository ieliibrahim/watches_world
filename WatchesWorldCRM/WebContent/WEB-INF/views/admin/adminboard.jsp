<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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


</head>

<body class="nav-md">

	<div class="container body">

		<div class="main_container">


			<!-- ------------------------------------------ Main naigation bar --------------------------------------------- -->

			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="index.html" class="site_title"><i
							class="fa fa-clock-o"></i> <span>Watches World Admin</span></a>
					</div>

					<div class="clearfix"></div>

					<!-- menu profile quick info -->
					<div class="profile clearfix">
						<div class="profile_pic">
							<img src="${user.photo }"
								alt="${user.name }&nbsp;${user.surname }"
								class="img-circle profile_img">
						</div>
						<div class="profile_info">
							<span>Welcome,</span>
							<h2>${user.name }&nbsp;${user.surname }</h2>
						</div>
					</div>
					<!-- /menu profile quick info -->

					<br />

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<h3>General</h3>
							<ul class="nav side-menu">
								<li><a><i class="fa fa-home"></i> Home <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="chartjs.html">Current Stock</a></li>
										<li><a href="chartjs2.html">Watches Sold</a></li>
									</ul></li>
								<li><a><i class="fa fa-bar-chart-o"></i> Statistics</a></li>
								<li><a><i class="fa fa-eur"></i> Investors</a></li>
								<li><a><i class="fa fa-users"></i> Parties <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="tables.html">Suppliers</a></li>
										<li><a href="tables_dynamic.html">Clients</a></li>
									</ul></li>
								<li><a><i class="fa fa-money"></i> Profit</a>
									<ul class="nav child_menu">
										<li><a href="chartjs.html">Main Profit</a></li>
										<li><a href="chartjs2.html">Assets &amp; Depts</a></li>
										<li><a href="morisjs.html">Sold &amp; Bought</a></li>
										<li><a href="echarts.html">Banks &amp; Capital</a></li>
									</ul></li>
								<li><a><i class="fa fa-file-pdf-o"></i>Reports <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="fixed_sidebar.html">Stock</a></li>
									</ul></li>
							</ul>
						</div>

					</div>

				</div>
			</div>

			<!-- ------------------------------------------ End Main naigation bar --------------------------------------------- -->

			<!-- ------------------------------------------ End Top naigation bar --------------------------------------------- -->

			<c:url var="logoutUrl" value="/logout" />
			<div class="top_nav">
				<div class="nav_menu">
					<nav>
						<div class="nav toggle">
							<a id="menu_toggle"><i class="fa fa-bars"></i></a>
						</div>

						<ul class="nav navbar-nav navbar-right">
							<li class=""><a href="javascript:;"
								class="user-profile dropdown-toggle" data-toggle="dropdown"
								aria-expanded="false"> <img src="${user.photo }" alt="">${user.name }&nbsp;${user.surname }
									<span class=" fa fa-angle-down"></span>
							</a>
								<ul class="dropdown-menu dropdown-usermenu pull-right">
									<li><a href="javascript:;"> Profile</a></li>
									<li><a href="${logoutUrl }"><i
											class="fa fa-sign-out pull-right"></i> Log Out</a></li>
								</ul></li>

						</ul>
					</nav>
				</div>
			</div>

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
					<div class="col-md-12 col-sm-12 col-xs-12">

						<table id="products_table_id"
							class="table table-striped table-bordered dt-responsive nowrap"
							cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>INTERNAL REFERENCE</th>
									<th>BRAND</th>
									<th>MODEL</th>
									<th>REFERENCE</th>
									<th>YEAR</th>
									<th>SERIAL</th>

								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>
			<!-- ------------------------------------------ End Products Table --------------------------------------------- -->

		</div>

	</div>

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

	<!-- Custom Theme Scripts -->
	<script src="../resources/js/app/custom.min.js"></script>
	<script
		src="../resources/js/datatables/jquery.dataTables.columnFilter.js"></script>

	<!-- Data tables -->

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$('#products_table_id')
									.DataTable(
											{
												"processing" : true,
												"serverSide" : true,
												"pagingType" : "full_numbers",
												"lengthMenu" : [ [ 10, 25, 50], [ 10, 25, 50 ] ],
												
												"ajax" : {
													"url" : "${pageContext.servletContext.contextPath}/admin/getProductsJSONV2",
													"data" : function(data) {
														//process data before sent to server.
													}
												},
												"columns" : [
														{
															"data" : "productId",
															"name" : "product_id"
														},
														{
															"data" : "brand",
															"name" : "brand"
														},
														{
															"data" : "model",
															"name" : "model"
														},
														{
															"data" : "productReference",
															"name" : "product_reference"
														}, {
															"data" : "year",
															"name" : "year"
														}, {
															"data" : "serial",
															"name" : "serial"
														} ]
											});

							$('#products_table_id').dataTable()
									.fnSetFilteringEnterPress();
						});
	</script>

</body>
</html>