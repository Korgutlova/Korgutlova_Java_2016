<#ftl encoding="utf-8">
<#include "base.ftl">
<#macro title>Sign up</#macro>
<#macro content>
<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<h1>Sign up</h1>
<@sf.form action="/sign_up" method="post" modelAttribute="userForm">
<fieldset>
    <div>
        <@sf.label path="name">Name</@sf.label>
        <@sf.input path="name" type="text" cssClass="form-control"/>
        <@sf.errors path="name"/>
    </div>
    <div>
        <@sf.label path="surname">Surname</@sf.label>
        <@sf.input path="surname" type="text" cssClass="form-control"/>
        <@sf.errors path="surname"/>
    </div>
    <div>
        <@sf.label path="email">Email</@sf.label>
        <@sf.input path="email" type="email" cssClass="form-control"/>
        <@sf.errors path="email"/>
    </div>
    <div>
        <@sf.label path="password">Password</@sf.label>
        <@sf.input path="password" type="password" cssClass="form-control"/>
        <@sf.errors path="password"/>
    </div>
    <br>
    <label>Description</label>
    <div>
        <@sf.textarea  cols="60" rows="10" path="description"/>
        <@sf.errors path="description"/>
    </div>
    <div>
        <input type="submit" value="Sign up" class="btn btn-info btn-outline">
    </div>
</fieldset>
</@sf.form>
</#macro>