<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<!-- Bootstrap Core CSS -->
    <link href="<c:url value="/assets/libs/bootstrap/dist/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" media="all" />

    <!-- MetisMenu CSS -->
    <link href="<c:url value="/assets/libs/metisMenu/dist/metisMenu.min.css" />" rel="stylesheet" type="text/css" media="all" />

    <!-- Custom CSS -->
    <link href="<c:url value="/assets/css/sb-admin-2.css" />" rel="stylesheet" type="text/css" media="all" />

    <!-- Custom Fonts -->
    <link href="<c:url value="/assets/libs/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" type="text/css" type="text/css" media="all">
	
	<title>Đăng nhập</title>
</head>
<body>

	<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
		<div class="navbar-header">
			<span class="navbar-brand">Hệ thống thông tin cứu trợ thiên tai</span>
		</div>
		
		<ul class="nav navbar-top-links navbar-right">
			<li class="navbar-brand" style="margin-top:-5px;">
				<div id="login" class="btn btn-link" data-toggle="modal" data-target="#loginModal">Đăng nhập</div>
				<div id="register" class="btn btn-link">Đăng ký</div>
			</li>
		</ul>
	</nav>

	<div id="loginModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Thông tin đăng nhập</h4>
				</div>
				<div class="modal-body">
					<form class="form login-form" action="<c:url value="/j_spring_security_check" />" method="post">
						<c:if test="${status != null}">
							<div class="alert-success">
								${status}
							</div>
						</c:if>
						<div class="has-error">
							<span class='help-block form-error' style="text-align:center;color:red;">${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</span>	
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="j_username" id="j_username" value="${param.j_username}" placeholder="Tên đăng nhập"/>
						</div>               
						<div class="form-group">
							<input type="password" class="form-control" name="j_password" id="j_password" value="${param.j_password }" placeholder="Mật khẩu"/>
						</div>              
						<div class="form-group">
							<button type="submit" class="btn btn-success" value="submit">Đăng nhập</button>
						    <span>Nếu bạn chưa có tài khoản, <a href="${baseUrl}/auth/register.html">Đăng ký</a></span>
						</div>
					</form>
				</div>			
				
			</div>

		</div>
	</div>
	
	<div id="jssor_1" style="position: relative; margin: 0 auto; top: 0px; left: 0px; width: 1300px; height: 550px; overflow: hidden; visibility: hidden;">
        <!-- Loading Screen -->
        <div data-u="loading" style="position: absolute; top: 0px; left: 0px;">
            <div style="filter: alpha(opacity=70); opacity: 0.7; position: absolute; display: block; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
            <div style="position:absolute;display:block;background:url('<c:url value="/assets/img/login/loading.gif" />') no-repeat center center;top:0px;left:0px;width:100%;height:100%;"></div>
        </div>
        <div data-u="slides" style="cursor: default; position: relative; top: 0px; left: 0px; width: 1300px; height: 700px; overflow: hidden;">           
            <div data-p="225.00">
                <img data-u="image" src="<c:url value="/assets/img/login/handrescue.jpg" />" />
                <div style="position:absolute;top:30px;left:30px;width:480px;height:120px;z-index:0;font-size:50px;color:#ffffff;line-height:60px;">Hệ thống thông tin cứu trợ thiên tai</div>
                <div style="position:absolute;top:300px;left:500px;width:480px;height:120px;z-index:0;font-size:30px;color:#ffffff;line-height:38px;">Nơi giúp bạn chia sẻ những khó khăn với đồng bào </div>               
                               
            </div>
            <div data-p="225.00">
                <img data-u="image" src="<c:url value="/assets/img/login/baolumientrung.jpg" />" />
                <div style="position:absolute;top:30px;left:30px;width:480px;height:120px;z-index:0;font-size:50px;color:#ffffff;line-height:60px;">Hệ thống thông tin cứu trợ thiên tai</div>
                <div style="position:absolute;top:300px;left:500px;width:480px;height:120px;z-index:0;font-size:30px;color:#ffffff;line-height:38px;">Giúp tấm lòng của bạn đến được với những hoàn cảnh khó khăn</div>               
                               
            </div>
            <div data-p="225.00">
                <img data-u="image" src="<c:url value="/assets/img/login/cugia.jpg" />" />
                <div style="position:absolute;top:30px;left:30px;width:480px;height:120px;z-index:0;font-size:50px;color:#ffffff;line-height:60px;">Hệ thống thông tin cứu trợ thiên tai</div>
                <div style="position:absolute;top:350px;left:700px;width:380px;height:120px;z-index:0;font-size:30px;color:#ffffff;line-height:38px;">Giúp thắp lên nụ cười dù cuộc sống còn nhiều cơ cực</div>               
                               
            </div>
            
        </div>
        <!-- Bullet Navigator -->
        <div data-u="navigator" class="jssorb05" style="bottom:16px;right:16px;" data-autocenter="1">
            <!-- bullet navigator item prototype -->
            <div data-u="prototype" style="width:16px;height:16px;"></div>
        </div>
        <!-- Arrow Navigator -->
        <span data-u="arrowleft" class="jssora22l" style="top:0px;left:8px;width:40px;height:58px;" data-autocenter="2"></span>
        <span data-u="arrowright" class="jssora22r" style="top:0px;right:8px;width:40px;height:58px;" data-autocenter="2"></span>
    </div>
	
	
	
	
	<!-- jQuery -->
	<script src="<c:url value="/assets/libs/jquery/dist/jquery.min.js" />" ></script>
	
	<script src="<c:url value="/assets/js/jssor.slider-22.0.15.mini.js" />" type="text/javascript" data-library="jssor.slider.mini" data-version="22.0.15"></script>
	
	<!-- Bootstrap Core JavaScript -->
	<script src="<c:url value="/assets/libs/bootstrap/dist/js/bootstrap.min.js" />" ></script>
	
	<!-- Metis Menu Plugin JavaScript -->
	<script src="<c:url value="/assets/libs/metisMenu/dist/metisMenu.min.js" />" ></script>
	
	<!-- Custom Theme JavaScript -->
	<script src="<c:url value="/assets/js/sb-admin-2.js" />" ></script>
	<c:if test="${status != null}">
	<script>
	$(document).ready(function() {
		$("#j_username").val('${username}');
		$("#j_password").val('${password}');		
		$("#loginModal").modal({
		    show: 'true'
		});
		$(".form-error").text('');
	});
	</script>
	</c:if>
	<script>
	$(document).ready(function() {
		if($(".form-error").text() != ''){	
			
			$("#loginModal").modal({
			    show: 'true'
			}); 
		}
	});
	$("#register").click(function() {
		window.location = '${baseUrl}'+"/auth/register.html";
	});
	</script>
	
	<script type="text/javascript">
        jQuery(document).ready(function ($) {

            var jssor_1_SlideoTransitions = [
              [{b:-1,d:1,o:-1},{b:0,d:1000,o:1}],
              [{b:1900,d:2000,x:-379,e:{x:7}}],
              [{b:1900,d:2000,x:-379,e:{x:7}}],
              [{b:-1,d:1,o:-1,r:288,sX:9,sY:9},{b:1000,d:900,x:-1400,y:-660,o:1,r:-288,sX:-9,sY:-9,e:{r:6}},{b:1900,d:1600,x:-200,o:-1,e:{x:16}}]
            ];

            var jssor_1_options = {
              $AutoPlay: true,
              $SlideDuration: 800,
              $SlideEasing: $Jease$.$OutQuint,
              $CaptionSliderOptions: {
                $Class: $JssorCaptionSlideo$,
                $Transitions: jssor_1_SlideoTransitions
              },
              $ArrowNavigatorOptions: {
                $Class: $JssorArrowNavigator$
              },
              $BulletNavigatorOptions: {
                $Class: $JssorBulletNavigator$
              }
            };

            var jssor_1_slider = new $JssorSlider$("jssor_1", jssor_1_options);

            /*responsive code begin*/
            /*you can remove responsive code if you don't want the slider scales while window resizing*/
            function ScaleSlider() {
                var refSize = jssor_1_slider.$Elmt.parentNode.clientWidth;
                if (refSize) {
                    refSize = Math.min(refSize, 1920);
                    jssor_1_slider.$ScaleWidth(refSize);
                }
                else {
                    window.setTimeout(ScaleSlider, 30);
                }
            }
            ScaleSlider();
            $(window).bind("load", ScaleSlider);
            $(window).bind("resize", ScaleSlider);
            $(window).bind("orientationchange", ScaleSlider);
            /*responsive code end*/
        });
    </script>
</body>
</html>
