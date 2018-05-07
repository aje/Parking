<#assign spring=JspTaglibs["http://www.springframework.org/tags"]/>
<#include "../layout/main.ftl">

<@layout  title='Edit user' >
    <h1>Edit User</h1>
    <h3>User name: ${authUser.fullname!} - ${authUser.mobile!}</h3>
    <hr>
    <#include "../dashboard/dashboard-sidebar.ftl">
</@layout>