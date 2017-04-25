<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="/js/MainScript.js"></script>
    <meta name="Content-Type" content="text/html" charset="UTF-8"/>
    <meta name="viewport" content="width=device-width" initial-scale="1" maximum-scale="1"/>
    <link rel="stylesheet" href="/css/main-style.css"/>
    <link rel="stylesheet"
          href="/css/font-awesome.min.css">
    <title>Portal</title>
</head>
<body>
<div class="header">
    <div class="header-text">Portal</div>
    <div id="nav-menu">
        <ul>
            <a href="#" id="userName"><li>${userName}</li></a>
            <a href="#" id="logout"><li>Logout</li></a>
        </ul>
        <ul>
            <a href="#"><li id="home"></li></a>
            <a href="#"><li id="user"></li></a>
            <a href="#"><li id="settings"></li></a>
            <a href="#"><li id="news"></li></a>
        </ul>
    </div>
</div>
<div class="container">
    <div id="left-nav-bar">
        <ul>
            <li>Events</li>
            <li>Games</li>
            <li>Deep</li>
        </ul>
    </div>
    <div class="content">
        <div class="post">
            <div class="user-profile-avatar"></div>
            <div class="post-in-content">
                Here will be very intersted post about :first-childsdksamdskdmksd
            </div>
            <div class="post-activity">
                <button class="button">Comment</button>
                <textarea class="comment">Write a comment.</textarea>
            </div>
        </div>
        <div class="post">
            <div class="user-profile-avatar"></div>
            <div class="post-in-content">
                Here will be very intersted post about :first-child
            </div>
            <div class="post-activity">
                <button class="button">Comment</button>
                <textarea class="comment">Write a comment.</textarea>
            </div>
        </div>
        <div class="post">
            <div class="user-profile-avatar"></div>
            <div class="post-in-content">
                Here will be very intersted post about :first-child
            </div>
            <div class="post-activity">
                <button class="button">Comment</button>
                <textarea class="comment">Write a comment.</textarea>
            </div>
        </div>
        <div class="post">
            <div class="user-profile-avatar"></div>
            <div class="post-in-content">
                Here will be very intersted post about :first-child
            </div>
            <div class="post-activity">
                <button class="button">Comment</button>
                <textarea class="comment">Write a comment.</textarea>
            </div>
        </div>
        <div class="post">
            <div class="user-profile-avatar"></div>
            <div class="post-in-content">
                Here will be very intersted post about :first-child
            </div>
            <div class="post-activity">
                <button class="button">Comment</button>
                <textarea class="comment">Write a comment.</textarea>
            </div>
        </div>
        <div id="right-friends-menu">
        	<ul id="friends-online">
        	
        	</ul>
			<ul id="action-friends">
			
			</ul>
        </div>

    </div>
</div>
</body>
</html>
