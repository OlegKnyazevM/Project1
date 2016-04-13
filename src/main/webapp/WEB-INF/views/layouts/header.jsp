<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/resources/css/main.css">

<html>
<head>
    <title>header</title>
    <style>
        #header {
            position: absolute;
            width: 100%;
            height: 130px;
            background: #fffaa8;
            font-size: 14px;
        }

        h1 {
            display: block;
            font-size: 2em;
            -webkit-margin-before: 0.75em;
            -webkit-margin-after: 0.67em;
            -webkit-margin-start: 50px;
            -webkit-margin-end: 50px;
            font-weight: bold;
        }
        h1{
            padding-left: 160px;

        }
        .noPhoto{
            width: 150px;
            height: 100px;
            padding-left: 5px;
        }
        #header {
            background: #fffaa8;
        }
        #menu {
            border-color: #9cdd72;
        }
        #menu {
            margin: 0;
            padding: 1px 0;
            list-style-type: none;
            height: 24px;
            border-bottom: 1px solid black;
        }
        ul, menu, dir {
            display: block;
            list-style-type: disc;
            -webkit-margin-before: 1em;
            -webkit-margin-after: 1em;
            -webkit-margin-start: 0px;
            -webkit-margin-end: 0px;
            -webkit-padding-start: 40px;
        }
        body {
            background: white;
            color: rgba(0, 0, 0, 0.5);
        }
        body{
             margin: 0;
             padding: 170px;
             background: #e0e0e0;
             color: #333;
             font: 12px/1.5 'segoe ui', 'lucida sans unicode', 'lucida grande', lucida, sans-serif;
         }
        #menu li {
            float: left;
            margin: 0;
            padding: 0;
            width: 25%;
        }
        li {
            display: list-item;
            text-align: -webkit-match-parent;
        }
        #menu {
            margin: 0;
            padding: 24px 0;
            list-style-type: none;
            height: 2px;
            border-bottom: 1px solid green;
        }
        ul, menu, dir {
            display: block;
            list-style-type: disc;
            -webkit-margin-before: 1em;
            -webkit-margin-after: 1em;
            -webkit-margin-start: 0px;
            -webkit-margin-end: 0px;
            -webkit-padding-start: 40px;
        }
        body {
            background: white;
            color: rgba(0, 0, 0, 0.5);
        }
        body {
            margin: 0;
            padding: 0;
            background: #e0e0e0;
            color: #333;
            font: 12px/1.5 'segoe ui', 'lucida sans unicode', 'lucida grande', lucida, sans-serif;
        }
        #menu a {
            background: #effce7;
            color: #73ba45;
        }
        #menu a {
            position: relative;
            display: block;
            margin: 1px;
            height: 24px;
            font-size: 12px;
            line-height: 24px;
            text-decoration: none;
            text-transform: uppercase;
            text-align: center;
            background:#baeb9b ;
            color: black;
        }
        a:-webkit-any-link {
            color: -webkit-link;
            text-decoration: underline;
            cursor: auto;
        }
        #menu a span {
            background: #baeb9b;
        }
        #menu a span {
            display: block;
            position: absolute;
            top: 5px;
            left: 8px;
            width: 8px;
            height: 8px;
            background: white;
        }

    </style>
</head>
<body>
<div id="header">
    <h1 text align="center">YOUR SHOP</h1>

    <ul id="menu">
        <li><a class="sel" href="/user/add" ><span></span>user</a></li>
        <li><a href="/product/add"><span></span>admin</a></li>
        <li><a href="/product/getAll"><span></span>shop</a></li>
        <li><a href="#"><span></span>shoping cart</a></li>

    </ul>

</div>
</body>
</html>