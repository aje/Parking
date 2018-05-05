<#assign spring=JspTaglibs["http://www.springframework.org/tags"]/>
<#assign imgPath><@spring.url value="/resources/resources/assets/app/media/img/" /></#assign>
<#assign jsPath><@spring.url value="/resources/resources/assets/app/js/" /></#assign>
<#assign cssPath><@spring.url value="/resources/resources/assets/app/css/" /></#assign>
<#assign vendorsCSS><@spring.url value="/resources/resources/assets/vendors/base/vendors.bundle.css" /></#assign>
<#assign style><@spring.url value="/resources/resources/assets/demo/default/base/style.bundle.css" /></#assign>
<#assign vendorsJs><@spring.url value="/resources/resources/assets/vendors/base/vendors.bundle.js" /></#assign>
<#assign scripts><@spring.url value="/resources/resources/assets/demo/default/base/scripts.bundle.js" /></#assign>

<#macro footer><@common_page_footer/></#macro>
<#macro head><@common_page_head/></#macro>

<#macro otherSripts></#macro>

<#macro layout title='Admin' body_class='' >
    <!DOCTYPE html>
    <html lang="en" >
        <head>
            <@head/>
            <title>${title}</title>
        </head>
        <body class='${body_class} m-page--fluid m--skin- m-content--skin-light2 m-header--fixed m-header--fixed-mobile m-aside-left--enabled m-aside-left--skin-dark m-aside-left--fixed m-aside-left--offcanvas m-footer--push m-aside--offcanvas-default'>
            <div class="m-grid m-grid--hor m-grid--root m-page">
                <#include "header.ftl">
                <!-- begin:: Page -->
                <div class="m-grid__item m-grid__item--fluid m-grid m-grid--ver-desktop m-grid--desktop m-body">
                <#include "sidebar.ftl">
                    <div class="m-grid__item m-grid__item--fluid m-wrapper">
                        <#include "subheader.ftl">
                        <div class="m-content">
                            <#nested/>
                        </div>
                    </div>
                </div>
                <#include "footer.ftl">
            </div>  <!-- /m-page -->
            <#include "quicksidebar.ftl">

            <!-- begin::Scroll Top -->
            <div class="m-scroll-top m-scroll-top--skin-top" data-toggle="m-scroll-top" data-scroll-offset="500" data-scroll-speed="300">
                <i class="la la-arrow-up"></i>
            </div>
            <!-- end::Scroll Top -->

            <@footer/>
            <@otherSripts/>
        </body>
    </html>
</#macro>

<#macro common_page_head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta content="${_csrf.token!}" name="_csrf" />
    <meta name="_csrf_header" content="${_csrf.headerName!}"/>
    <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.16/webfont.js"></script>
    <script>
      WebFont.load({
        google: {"families":["Poppins:300,400,500,600,700","Roboto:300,400,500,600,700"]},
        active: function() {
            sessionStorage.fonts = true;
        }
      });
    </script>
    <link href=${vendorsCSS} rel="stylesheet" type="text/css" />
    <link href=${style} rel="stylesheet" type="text/css" />
    <!--end::Base Styles -->
</#macro>

<#macro common_page_footer pageScripts=''>
    <div class="m-scroll-top m-scroll-top--skin-top" data-toggle="m-scroll-top" data-scroll-offset="500" data-scroll-speed="300">
        <i class="la la-arrow-up"></i>
    </div>

    <!--begin::Base Scripts -->
    <script src=${vendorsJs} type="text/javascript"></script>
    <script src=${scripts} type="text/javascript"></script>
    <!--end::Base Scripts --> 

    <!--begin::Page Resources -->
    
    <!--end::Page Resources -->
</#macro>
