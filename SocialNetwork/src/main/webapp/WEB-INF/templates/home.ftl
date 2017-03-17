<#ftl encoding="utf-8">
<#include "base.ftl">
<#macro title>Home page</#macro>
<#macro content>
<div class="profile">
    <h3>Profile</h3>
    <h4>Surname: ${userPage.surname}</h4>
    <h4>Name: ${userPage.name}</h4>
    <h4>Email: ${userPage.email}</h4>
    <#if userPage.description??>
        <h4>Description: </h4>
        <h5>${userPage.description}</h5>
    </#if>
    <form action="/home/message/${userPage.id}" method="post">
        <input class="btn btn-info btn-outline" type="submit" value="Write a message">
    </form>
</div>
<hr><br>
<h2>Add new post..</h2>
<form method="post" action="/home/post">
    <input type="hidden" name="link" value="${link}">
    <input type="hidden" name="userPage" value="${userPage.id}"/>
    <input type="hidden" name="user" value="${user.id}"/>
    <textarea name="text" cols="70" rows="10" placeholder="Enter your post.." maxlength="1000"></textarea>
    <input class="btn btn-default btn-outline" type="submit" value="New post">
</form>
<hr>
    <#if posts??>
    <h2>Posts:</h2>
        <#list posts as post>
        <h4>${post.text}</h4>
        <h4><i>Author: <a href="/home/user/${post.userSender.id}">${post.userSender.name}</a></i></h4>
        <h4><strong>By ${post.date}</strong></h4>
            <#if post.userSender.id == user.id || user.id == userPage.id>
            <form method="post" action="/home/post/${post.id}">
                <input type="hidden" name="link" value="${link}">
                <input class="btn btn-danger btn-outline" type="submit" value="Delete">
            </form>
            </#if>
        <br>
        <form method="post" action="/home/repost/${post.id}">
            <input type="hidden" name="link" value="<#if link??>${link}<#else></#if>">
            <input class="btn btn-info btn-outline" type="submit" value="Repost">
        </form>
        <hr>
        <#else>
        <h3>No posts!</h3>
        </#list>
    <#else>
    <h3>No posts</h3>
    </#if>

</#macro>