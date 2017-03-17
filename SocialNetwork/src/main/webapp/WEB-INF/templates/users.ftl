<#ftl encoding="utf-8">
<#include "base.ftl">
<#macro title>Users</#macro>
<#macro content>
<h1>Users</h1>
    <#list users as u>
    <h3><strong><a href="/home/user/${u.id}">${u.surname} ${u.name}</a></strong></h3>
    <h4><i>${u.description}</i></h4>
    <hr>
    <#else>
    <h2>No users!</h2>
    </#list>
</#macro>
