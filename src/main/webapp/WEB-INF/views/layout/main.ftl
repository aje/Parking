<#assign spring=JspTaglibs["http://www.springframework.org/tags"]/>
<#assign basePath><@spring.url value="/resources/resources/assets" /></#assign>
<#assign imgPath><@spring.url value="${basePath}/img" /></#assign>
<#assign jsPath><@spring.url value="${basePath}/js" /></#assign>
<#assign cssPath><@spring.url value="${basePath}/css" /></#assign>

<#macro layout title='Home' body_class='' >
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <@head/>
        <title>ePark - ${title}</title>
    </head>
    <body class='${body_class} '>
        <div class="">
            <#include "header.ftl">
            <!-- begin:: Page -->
            <div class="content">
                <#nested/>
            </div>
            <#include "footer.ftl">
        </div>  <!-- /m-page -->
        <!-- end::Scroll Top -->
        <@footer/>
    </body>
    </html>
</#macro>

<#macro head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport'/>
    <meta content="${_csrf.token!}" name="_csrf"/>
    <meta name="_csrf_header" content="${_csrf.headerName!}"/>
    <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.16/webfont.js"></script>
    <script>
        WebFont.load({
            google: {"families": ["Poppins:300,400,500,600,700", "Roboto:300,400,500,600,700"]},
            active: function () {
                sessionStorage.fonts = true;
            }
        });
    </script>
    <#--<link href=<@spring.url value="${jsPath}/vendor.css" /> rel="stylesheet" type="text/css"/>-->
    <link href=<@spring.url value="${jsPath}/style.css" /> rel="stylesheet" type="text/css"/>
    <#nested/>
    <!--end::Base Styles -->
</#macro>

<#macro footer>
    <!--begin::Base Scripts -->
    <#--<script src=<@spring.url value="${jsPath}/vendor.js" /> type="text/javascript"></script>-->
    <script src=<@spring.url value="${jsPath}/scripts.js" /> type="text/javascript"></script>
    <!--end::Base Scripts -->
    <#nested/>
</#macro>
