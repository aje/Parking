<#assign spring=JspTaglibs["http://www.springframework.org/tags"]/>
<#include "../layout/main.ftl">

<@layout  title='Park History' >
    <h1>Park History</h1>
    <h3>User name: ${authUser.fullname!} - ${authUser.mobile!}</h3>
    <hr>
    <#include "dashboard-sidebar.ftl">

    <#list orders as order>
        ${order} <br>
    </#list>
</@layout>