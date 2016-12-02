<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- DataTables CSS -->
<link href="<c:url value="/assets/libs/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css"/>" rel="stylesheet">
<!-- DataTables Responsive CSS -->
<link href="<c:url value="/assets/libs/datatables-responsive/css/dataTables.responsive.css" />" rel="stylesheet">

<!-- DataTables JavaScript -->
<script src="<c:url value="/assets/libs/datatables/media/js/jquery.dataTables.js"/>"></script>
<script src="<c:url value="/assets/libs/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.js"/>"></script>


<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Tình hình cứu trợ</h1>
		</div>
		<!-- /.col-lg-12 -->
		
		<div class="main col-sm-4">
			<div class="form-group">
				<select id="relief-session" name="relief-session" class="form-control">
					<option>Chọn đợt cứu trợ</option>
					<c:forEach items="${reliefSessions}" var="reliefsession">
						<option value="${reliefsession.RLFSS_Code}"><c:out value="${reliefsession.RLFSS_Name}"/></option>
					</c:forEach>
				<select>
			</div>
			<button type="button" class="btn btn-primary active" title="Xem thong tin dot cuu tro" onclick="viewRelief()">Xem</button>
			
			<button type="button" class="btn btn-primary add" title="Thêm thong tin dot cuu tro" onclick="addRelief()">Thêm</button>
			
		</div>
		
	</div>
	<!-- /.row -->
	<div id="googleMap" style="width:100%; height:100%; margin-bottom:10px";></div>
	
	
		<div class="panel panel-default">
		<div class="panel-body">
			<div class="dataTable_wrapper">
				<table class="table table-striped table-bordered table-hover" id="tbl-listStreets">
					<thead>
						<tr>
							<th>Xa</th>
							<th>Dot cuu tro</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${reliefdemandlist}" var="rdl">
							<tr>
								<td><c:out value="${rdl.RLFDM_CommuneName}"/></td>
								<td><c:out value="${rdl.RLFDM_ReliefSessionCode}"/></td>
								
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
<!-- /#page-wrapper -->

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAruL-HLFSNh6G2MLhjS-eBTea7r7EFa5A&libraries=places&callback=initialize" async defer></script>
<script>
var map;
var communes = new Array();
function initialize(){
	var mapProp = {
		center : {lat:21.03333, lng: 105.849998},
		zoom : 12,
		mapTypeIDd : google.maps.MapTypeId.ROADMAP
	}
	map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
}


$(document).ready(function(){
	initialize();
	
})
</script>

<script>

function addRelief(){
	window.location = '${baseUrl}' + "/relief/add-a-relief";
}


function viewReliefInfo(commune, reliefSessionCode){
	var communeCode = commune.infocode;
	
	//var items = "";
	var info = "{\"communeCode\":\"" + communeCode + "\",\"reliefSessionCode\":\"" + reliefSessionCode + "\"}";
	$.ajax({ 
   		type:"POST", 
    	url:"${baseUrl}/relief/get-relief-goods",
    	//contentType: "application/json; charset=utf-8",
        //dataType: "json",
    	data: "info=" + info,
    	//contentType: "application/json; charset=utf-8",
    	//dataType: "json",
    	//Stringified Json Object
    	cache: false,
		beforeSend: function () { 
			
		},
    	success: function(response){
    		console.log(response);
    		var obj = jQuery.parseJSON(response);
    		var items = "<table border=1>";
    		items += "<tr>";
			items += "<td>" + "Tên hàng hoá" + "</td>\n"; 
			items += "<td>" + "Số lượng" + "</td>\n";
			items += "<td>" + "Đơn vị tính" + "</td>\n";
			items += "<td>" + "Thành tiền" + "</td>\n";
			items += "<td>" + "Tổ chức cứu trợ" + "</td>\n";
			items += "</tr>";
		
    		for(i = 0; i < obj.reliefs.length; i++){
    			items += "<tr>";
    			items += "<td>" + decodeURIComponent(obj.reliefs[i].good) + "</td>\n"; 
    			items += "<td>" + obj.reliefs[i].quantity + "</td>\n";
    			items += "<td>" + decodeURIComponent(obj.reliefs[i].unit) + "</td>\n";
    			items += "<td>" + obj.reliefs[i].money + "</td>\n";
    			items += "<td>" + decodeURIComponent(obj.reliefs[i].organization) + "</td>\n";
    			items += "</tr>";
    		}
    		items += "</table>";
    		console.log("viewReliefDemand --> GOT items " + items);
    		var content = decodeURIComponent(commune.name) + "<br>" + items;
    		//alert("name = " + commune.name + ", content = " + content);
    		
    		commune.infowindow.setContent(content);
    		commune.infowindow.open(map, commune);
    		//var infowindow = new google.maps.InfoWindow({
    		//	content: items
    		//});
    		
    		//return items;
    	}	
	});	
	//return items;
}

function viewReliefCommunes(obj){
	var center_lat = obj.center_lat;
	var center_lng = obj.center_lng;
	//alert(center_lat + "," + center_lng);
	
	map.setCenter(new google.maps.LatLng(center_lat, center_lng));
	
	for(i = 0; i <  obj.communes.length; i++){
		var lat = obj.communes[i].lat;
		var lng = obj.communes[i].lng;
		var latlng = new google.maps.LatLng(lat,lng);
		var infocode = obj.communes[i].infocode;
		var name = obj.communes[i].infoname;
		//var demand = getReliefDemand(infocode);
		//alert(demand);
		//console.log("commune " + i + ", demand = " + demand);
		var infowindow = new google.maps.InfoWindow({
			content: infocode
		});
		
		var marker = new google.maps.Marker({
	          'position': latlng,
	          'map': map,
	          //code: infocode,
	          //title: obj.communes[i].infocode,
	          'ID': communes.length,
	          infowindow: infowindow,
	          infocode: infocode,
	          name: name
	        });
		
		
		marker.addListener('click', function() {
		    //this.infowindow.open(map, this);
		    var selectReliefSession=$("#relief-session option:selected").val();
		    viewReliefInfo(this,selectReliefSession);
		    
		});
		
		
	}
}
function viewRelief(){
	var select=$("#relief-session option:selected").val();
	$.ajax({ 
   		type:"POST", 
    	url:"${baseUrl}/relief/get-relief-communes",
    	data: "reliefsession=" + select,
    	//contentType: "application/json; charset=utf-8",
    	//dataType: "json",
    	//Stringified Json Object
    	cache: false,
		beforeSend: function () { 
			
		},
    	success: function(response){
    		console.log(response);
    		var obj = jQuery.parseJSON(response);
    		viewReliefCommunes(obj);
    	}	
	});
}
</script>