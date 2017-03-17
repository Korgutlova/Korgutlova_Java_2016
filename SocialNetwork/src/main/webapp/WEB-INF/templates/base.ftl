<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><@title/></title>
    <link href="/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="wrapper">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
        <#if user??>
            <a href="/home" class="btn btn-default navbar-btn button_impr">Home page</a>
            <a href="/home/user" class="btn btn-default navbar-btn button_impr">Users</a>
            <a href="/home/messages" class="btn btn-default navbar-btn button_impr">My messages</a>
            <a href="/logout" class="btn btn-default navbar-btn">Logout</a>
        <#else>
            <a href="/sign_up" class="btn btn-default navbar-btn button_impr">Sign up</a>
            <a href="/sign_in" class="btn btn-default navbar-btn">Sign in</a>
        </#if>
        </div>
    </nav>
    <div class="container content">
    <@content/>
    </div>
    <div class="footer">
        <div class="container">
            <div class="row footer_group">
                <div class="col-md-5">
                    <p class="footer_text">© 2017 Social&Netwrok&Kor"</p>
                </div>
                <div class="col-md-2">
                    <a class="footer_text" href="#">soc-kor.com</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>