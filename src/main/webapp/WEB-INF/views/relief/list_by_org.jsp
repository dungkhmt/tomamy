<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- DataTables CSS -->
<link
	href="<c:url value="/assets/libs/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css"/>"
	rel="stylesheet">
<!-- DataTables Responsive CSS -->
<link
	href="<c:url value="/assets/libs/datatables-responsive/css/dataTables.responsive.css" />"
	rel="stylesheet">

<!-- DataTables JavaScript -->
<script
	src="<c:url value="/assets/libs/datatables/media/js/jquery.dataTables.js"/>"></script>
<script
	src="<c:url value="/assets/libs/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.js"/>"></script>


<div id="page-wrapper">
	<div class="row">
		<h1 class="page-header">Tình hình cứu trợ</h1>
	</div>

	<div class="row">
		<form class="form">
			<div class="form-group form-inline">
				<select id="relief-org" name="relief-org" class="form-control">
					<option>Chọn tổ chức</option>
					<c:forEach items="${reliefOrgs}" var="org">
						<option value="${org.RLFORG_Code}"><c:out
								value="${org.RLFORG_Name}" /></option>
					</c:forEach>
				</select>
				<button type="button" class="btn btn-primary active"
					title="Xem thong tin dot cuu tro" onclick="viewRelief()">Xem</button>
			</div>
		</form>
	</div>

	<div class="row">
		<div id="googleMap"
			style="width: 100%; height: 100%; margin-bottom: 10px; margin-top: 10px"></div>
	</div>

	<div class="row">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="dataTable_wrapper">
					<table class="table table-striped table-bordered table-hover"
						id="tbl-listStreets">
						<thead>
							<tr>
								<th>Xa</th>
								<th>Dot cuu tro</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${reliefdemandlist}" var="rdl">
								<tr>
									<td><c:out value="${rdl.RLFDM_CommuneName}" /></td>
									<td><c:out value="${rdl.RLFDM_ReliefSessionCode}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- /#dataTable_warpper -->
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
</div>
<!-- /#page-wrapper -->

<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAruL-HLFSNh6G2MLhjS-eBTea7r7EFa5A&libraries=places&callback=initialize"
	async defer></script>
<script>
	var map, markers;
	var communes = new Array();

	function clearMarkers() {
		if(markers) {
			for (var m in markers) {
				m.setMap(null);
			}
		}
	}

	function initialize() {
		var mapProp = {
			center : {
				lat : 21.03333,
				lng : 105.849998
			},
			zoom : 12,
			mapTypeIDd : google.maps.MapTypeId.ROADMAP
		}
		map = new google.maps.Map(document.getElementById("googleMap"), mapProp);
	}

	$(document).ready(function() {
		initialize();
	});

	function viewReliefCommunes(obj) {
		clearMarkers();
		markers = [];
		var center_lat = obj.center_lat;
		var center_lng = obj.center_lng;

		map.setCenter(new google.maps.LatLng(center_lat, center_lng));

		for (i = 0; i < obj.communes.length; i++) {
			var lat = obj.communes[i].lat;
			var lng = obj.communes[i].lng;
			var latlng = new google.maps.LatLng(lat, lng);
			var infocode = obj.communes[i].infocode;
			var name = obj.communes[i].infoname;
			var infowindow = new google.maps.InfoWindow({
				content : infocode
			});

			var marker = new google.maps.Marker({
				'position' : latlng,
				'map' : map,
				'ID' : communes.length,
				infowindow : infowindow,
				infocode : infocode,
				name : name
			});
			
			markers.push(marker);

			marker.addListener('click', function() {
				var selectReliefSession = $("#relief-org option:selected")
						.val();
				viewReliefInfo(this, selectReliefSession);
			});
		}
	}
	
	function viewRelief() {
		var select = $("#relief-org option:selected").val();
		$.ajax({
			type : "POST",
			url : "${baseUrl}/relief/get-relief-communes",
			data : "reliefOrg=" + select,
			cache : false,
			success : function(response) {
				var communes = jQuery.parseJSON(response);
				viewReliefCommunes(communes);
			}
		});
	}
</script>