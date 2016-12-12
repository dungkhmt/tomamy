<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

<script src="<c:url value="/assets/libs/jquery-ui-1.12.0/jquery-ui.js"/>"> </script>
<link href="<c:url value="/assets/libs/bootstrap-datepicker/css/bootstrap-datepicker.css" />" rel="stylesheet" type="text/css" media="all" />
<script src="<c:url value="/assets/libs/bootstrap-datepicker/js/bootstrap-datepicker.js"/>"></script>
<link href="<c:url value="/assets/libs/bootstrap-timepicker/css/bootstrap-timepicker.css" />" rel="stylesheet" type="text/css" media="all" />

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<script src="<c:url value="/assets/libs/bootstrap-timepicker/js/bootstrap-timepicker.js"/>"></script>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Thêm nhu thông tin cứu trợ</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->

	<form:form action="${baseUrl}/relief/save-a-relief" method="POST" commandName="ReliefDetailAddForm" role="form" class="form-horizontal">
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<div>
						<select class="form-control" name="reliefSessionCode" path="reliefSessionCode">
							<option>Chọn Đợt</option>
							<c:forEach items="${reliefSessions}" var="RS">
								<option value="${RS.RLFSS_Code}"><c:out
										value="${RS.RLFSS_Name}"></c:out></option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<div>
						<select class="form-control" name="reliefOrganizationCode" path="reliefOrganizationCode">
							<option>Chọn tổ chức cứu trợ</option>
							<c:forEach items="${reliefOrganizations}" var="RO">
								<option value="${RO.RLFORG_Code}"><c:out
										value="${RO.RLFORG_Name}"></c:out></option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<div>
						<select class="form-control" name="communeCode" path="communeCode">
							<option>Chọn Xã</option>
							<c:forEach items="${communes}" var="aCommune">
								<option value="${aCommune.COM_Code}"><c:out
										value="${aCommune.COM_Name}"></c:out></option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<div>
						<select class="form-control" name="goodCode" path="goodCode">
							<option>Chọn Mặt hàng</option>
							<c:forEach items="${goods}" var="aGood">
								<option value="${aGood.GOD_Code}"><c:out
										value="${aGood.GOD_Name}"></c:out></option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>

		<div class="form-group">
						<label class="control-label col-lg-2">Ngày giao hàng</label>
						<div class="col-lg-2">
						<form:input  path="date" class="form-control datepicker" name="date" placeholder="Date" ></form:input>
						</div>
						
		</div>
					
		<div class="form-group ">
					<label class="control-label col-sm-2 articleAmount">Số lượng</label>
					<div class="col-sm-2">
						<input class="form-control" name="quantity" placeholder="" ></input>
                    </div>
		</div>	
				
		<div class="form-group ">
					<label class="control-label col-sm-2 articleMoney">Thành tiền</label>
					<div class="col-sm-2">
						<input class="form-control" name="money" placeholder="" ></input>
                    </div>
		</div>	
				
		<button type="submit" class="btn btn-primary" id="addAReliefDemand">Lưu</button>
        <button type="reset" class="btn btn-primary cancel">Hủy</button>
        			
	</form:form>
</div>
<!-- /#page-wrapper -->



<script>
	$(function() {
        $( ".datepicker" ).datepicker({
        		format: 'yyyy:mm:dd'
        		});
        
    });
</script>


