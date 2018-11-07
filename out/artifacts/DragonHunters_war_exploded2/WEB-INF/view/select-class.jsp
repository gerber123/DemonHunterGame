<%--
  Created by IntelliJ IDEA.
  User: gerber
  Date: 14.10.2018
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home-page</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}../resources/css/select-class.css"/>
    <link href="https://fonts.googleapis.com/css?family=Cinzel" rel="stylesheet">
</head>
<body>

<div id="welcome">Select Type of <span style="color:red"> Killer</span>! Make<span style="color:red"> War</span>, not Peace</div>
    <div id="container">
    <%--<form:hidden path="${character.id}"/>--%>
    <%--<form:hidden path="${character.nick_name}"/>--%>
     <div class="box" style="opacity: 0;width:280px"></div>

     <div class="box">

        <form:form action="${pageContext.request.contextPath}/creatingProcess/classSelected?characterTypeId=1"
           modelAttribute="character"
           class="form-horizontal">
            <%--<form:hidden path="id"/>--%>
            <%--<form:hidden path="nick_name"/>--%>
            <img src="${pageContext.request.contextPath}/resources/images/hunterIcon.jpg" class="avatar">
            <h1>Hunter!</h1>
            <h3>Aim at the center of the head, he will not notice</h3>
        <%--<a href="${pageContext.request.contextPath}/creatingProcess/classSelected?characterTypeId=1" methods="POST">--%>
            <input type="submit" value="Select" style="margin-bottom:30px" >
        </form:form>
        <%--</a>--%>

    </div>

    <div class="box" style="opacity:0 ;width:2px"></div>
        <div class="box">
        <form:form action="${pageContext.request.contextPath}/creatingProcess/classSelected?characterTypeId=3"
                   modelAttribute="character"
                   class="form-horizontal">
            <%--<form:hidden path="id"/>--%>
            <%--<form:hidden path="nick_name"/>--%>
        <img src="${pageContext.request.contextPath}/resources/images/warriorIcon.jpg" class="avatar">
        <h1>Warrior!</h1>
        <h3>Take axe and start cutting little heads. Little sin</h3>
         <input type="submit" value="Select" >
        </form:form>
    </div>
        <div class="box" style="opacity:0 ;width:2px"></div>

        <div class="box">
    <form:form action="${pageContext.request.contextPath}/creatingProcess/classSelected?characterTypeId=2"
               modelAttribute="character"
               class="form-horizontal">
        <%--<form:hidden path="id"/>--%>
        <%--<form:hidden path="nick_name"/>--%>
        <img src="${pageContext.request.contextPath}/resources/images/mageIcon.jpg" class="avatar">
        <h1>Mage!</h1>
        <h3>Let them burn, and you only look at dancing matches</h3>
        <input type="submit" value="Select" ></a>
    </form:form>
    </div>
        <div class="box" style="opacity:0 ;width:280px"></div>


    </div>
</body>
</html>
