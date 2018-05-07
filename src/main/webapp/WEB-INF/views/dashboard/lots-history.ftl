<#assign spring=JspTaglibs["http://www.springframework.org/tags"]/>
<#include "../layout/main.ftl">

<@layout  title='Lots History' >
    <h1>Lots History</h1>
    <h3>User name: ${authUser.fullname!} - ${authUser.mobile!}</h3>
    <hr>
    <#include "dashboard-sidebar.ftl">
</@layout>