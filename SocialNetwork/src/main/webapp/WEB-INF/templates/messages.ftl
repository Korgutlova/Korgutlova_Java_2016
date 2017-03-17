<#ftl encoding="utf-8">
<#include "base.ftl">
<#macro title>Chats</#macro>
<#macro content>
        <h1>Your chats:</h1>
    <#list chats as chat>
        <h3><a href="/home/message/${chat.id}">Chat with
            <#if user.id == chat.userOne.id>${chat.userTwo.name}<#else>${chat.userOne.name}</#if>
        </a></h3>
        <hr>
    <#else>
        <h3>No open chats!</h3>
    </#list>
</#macro>