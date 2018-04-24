<#assign spring=JspTaglibs["http://www.springframework.org/tags"]/>
<#assign vendorsCSS><@spring.url value="/resources/assets/vendors/base/vendors.bundle.css" /></#assign>
<#assign style><@spring.url value="/resources/assets/demo/default/base/style.bundle.css" /></#assign>
<#assign vendorsJs><@spring.url value="/resources/assets/vendors/base/vendors.bundle.js" /></#assign>
<#assign scripts><@spring.url value="/resources/assets/demo/default/base/scripts.bundle.js" /></#assign>


<#macro body></#macro>
<#macro otherSripts></#macro>

<#macro layout title='Admin' body_class='' >
<!DOCTYPE html>
<html lang="en" >
	<!-- begin::Head -->
	<head>
		<meta charset="utf-8" />
		<title>
			Metronic | Login Page - 2
		</title>
		<meta name="description" content="Latest updates and statistic charts">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!--begin::Web font -->
		<script src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.16/webfont.js"></script>
		<script>
          WebFont.load({
            google: {"families":["Poppins:300,400,500,600,700","Roboto:300,400,500,600,700"]},
            active: function() {
                sessionStorage.fonts = true;
            }
          });
		</script>
		<!--end::Web font -->
        <!--begin::Base Styles -->
	    <link href=${vendorsCSS} rel="stylesheet" type="text/css" />
	    <link href=${style} rel="stylesheet" type="text/css" />
		<!--end::Base Styles -->
		<link rel="shortcut icon" href="../../../assets/demo/default/media/img/logo/favicon.ico" />
	</head>
	<!-- end::Head -->
    <!-- end::Body -->
	<body class="m--skin- m-header--fixed m-header--fixed-mobile m-aside-left--enabled m-aside-left--skin-dark m-aside-left--offcanvas m-footer--push m-aside--offcanvas-default"  >
		<!-- begin:: Page -->
		<div class="m-grid m-grid--hor m-grid--root m-page">
			<@body />
			
		</div>
		<!-- end:: Page -->
	    <div class="m-scroll-top m-scroll-top--skin-top" data-toggle="m-scroll-top" data-scroll-offset="500" data-scroll-speed="300">
	        <i class="la la-arrow-up"></i>
	    </div>

	    <!--begin::Base Scripts -->
	    <script src=${vendorsJs} type="text/javascript"></script>
	    <script src=${scripts} type="text/javascript"></script>
	    <@otherSripts/>
	</body>
	<!-- end::Body -->
</html>
</#macro>
