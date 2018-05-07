<#assign spring=JspTaglibs["http://www.springframework.org/tags"]/>
<#include "../layout/main.ftl">

<@layout  title='Dashboard' >
    <h1>User Dashboard</h1>
    <h3>User name: ${authUser.fullname!} - ${authUser.mobile!}</h3>
    <hr>
    <#include "dashboard-sidebar.ftl">
    <strong>Count of Orders: </strong> ${orderCounts!} <br>
    <strong>Count of Hours of parking: </strong> ${hoursCounts!} <br>
    <strong>Most used parking lot: </strong> ${mostUsedLot!} <br>
    <strong>Plate number of your car: </strong><#if authUser.plateNumber??>${authUser.plateNumber!} <#else> <form action="/addPlate" method="post"><input type="text" name="plateNumber"></form> </#if><br>
</@layout>