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


<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Thêm nhu cầu cứu trợ</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->

	<form:form action="${baseUrl}/reliefdemand/save-a-relief-demand" method="POST" commandName="ReliefDemandGoodForm" role="form" class="form-horizontal">
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

		<div class="form-group ">
					<label class="control-label col-sm-2 articleAmount">Số lượng</label>
					<div class="col-sm-2">
						<input class="form-control" name="quantity" placeholder="" ></input>
                    </div>
		</div>	
				
				
		<button type="submit" class="btn btn-primary" id="addAReliefDemand">Lưu</button>
        <button type="reset" class="btn btn-primary cancel">Hủy</button>
        			
	</form:form>
</div>
<!-- /#page-wrapper -->


</script>

