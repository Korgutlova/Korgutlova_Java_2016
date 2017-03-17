<#ftl encoding="utf-8">
<#include "base.ftl">
<#macro title>Chat</#macro>
<#macro content>
<h1>Chat</h1>
    <#list messages as message>
        <#if message.sender.id != user.id>
        <div class="row">
            <div class="col-md-5">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-11">
                                <h3>${message.text}</h3>
                                <h4><a href="/home/user/${message.sender.id}">${message.sender.name}</a></h4>
                                <h4><i>${message.date}</i></h4>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <#else>
        <div class="row">
            <div class="col-md-5 col-md-offset-5">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-11">
                            </div>
                            <h3>${message.text}</h3>
                            <h4><a href="/home/user/${message.sender.id}">${message.sender.name}</a></h4>
                            <h4><i>${message.date}</i></h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </#if>
    <hr>
    <#else>
    <h3>No messages!</h3>
    </#list>
<form action="/home/message" method="post">
    <input type="hidden" name="chat" value="${chat}">
    <textarea name="text" cols="70" rows="10" placeholder="Enter your message.." maxlength="1000"></textarea>
    <input class="btn btn-info btn-outline" type="submit" value="Send">
</form>
</#macro>