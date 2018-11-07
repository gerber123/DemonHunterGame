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
          href="${pageContext.request.contextPath}../resources/css/select-race.css"/>
    <link href="https://fonts.googleapis.com/css?family=Cinzel" rel="stylesheet">
</head>
<body>

<div id="welcome">Select Race to Your <span style="color:red"> Killer</span>! World<span style="color:red"> Full</span> of Killers</div>

    <div id="container">
    <%--<form:hidden path="${character.id}"/>--%>
    <%--<form:hidden path="${character.nick_name}"/>--%>
     <%--<c:if test="${user.usercharacter.characterType.id=='1'}">  --%>

     <div class="box" style="opacity: 0; width:180px"></div>

     <div class="box-human" >

        <form:form action="${pageContext.request.contextPath}/creatingProcess/raceSelected?characterRaceId=1"
           modelAttribute="character"
           class="form-horizontal">
            <%--<form:hidden path="id"/>--%>
            <%--<form:hidden path="nick_name"/>--%>
            <%--<form:hidden path="characterType"/>--%>
            <%--<form:hidden path="lvl"/>--%>
            <%--<img src="${pageContext.request.contextPath}/resources/images/hunterIcon.jpg" class="avatar">--%>
            <h1>Human!</h1>
            <h3>Humans can kill you when you are playing chess like a friends </h3>
            <%--<h3>When you play chess with a human, you don't know who will fall first.</h3>--%>
        <%--<a href="${pageContext.request.contextPath}/creatingProcess/classSelected?characterTypeId=1" methods="POST">--%>
            <input type="submit" value="Select" style="margin-bottom:30px" >
        </form:form>
        <%--</a>--%>

    </div>

    <div class="box" style="opacity:0 ;width:2px"></div>
        <div class="box-elf">
        <form:form action="${pageContext.request.contextPath}/creatingProcess/raceSelected?characterRaceId=2"
                   modelAttribute="character"
                   class="form-horizontal">
            <%--<form:hidden path="id"/>--%>
            <%--<form:hidden path="nick_name"/>--%>
            <%--<form:hidden path="characterType"/>--%>
            <%--<form:hidden path="lvl"/>--%>
        <%--<img src="${pageContext.request.contextPath}/resources/images/warriorIcon.jpg" class="avatar">--%>
        <h1>Elf!</h1>
        <%--<h3>All People who saw elf can't say anything more in their life</h3>--%>
        <h3>Anyone who saw the elf didn't have more opportunity to say anything</h3>
         <input type="submit" value="Select" >
        </form:form>
    </div>
        <div class="box" style="opacity:0 ;width:2px"></div>

        <div class="box-orc">
    <form:form action="${pageContext.request.contextPath}/creatingProcess/raceSelected?characterRaceId=3"
               modelAttribute="character"
               class="form-horizontal">
        <%--<form:hidden path="id"/>--%>
        <%--<form:hidden path="nick_name"/>--%>
        <%--<form:hidden path="characterType"/>--%>
        <%--<form:hidden path="lvl"/>--%>
        <%--<img src="${pageContext.request.contextPath}/resources/images/mageIcon.jpg" class="avatar">--%>
        <h1>Orc!</h1>
        <h3>The orc does not think about killing.They just thinking how to do it?</h3>
        <input type="submit" value="Select" ></a>
    </form:form>
    </div>
        <div class="box" style="opacity:0 ;width:2px"></div>

        <div class="box-dwarf">
    <form:form action="${pageContext.request.contextPath}/creatingProcess/raceSelected?characterRaceId=4"
               modelAttribute="character"
               class="form-horizontal">
        <%--<form:hidden path="id"/>--%>
        <%--<form:hidden path="nick_name"/>--%>
        <%--<form:hidden path="characterType"/>--%>
        <%--<form:hidden path="lvl"/>--%>
        <%--<img src="${pageContext.request.contextPath}/resources/images/mageIcon.jpg" class="avatar">--%>
        <h1>Dwarf!</h1>
        <h3>The dwarf can make your sword shine or your heart will stop beating</h3>
        <input type="submit" value="Select" ></a>
    </form:form>
    </div>
        <div class="box" style="opacity:0 ;width:180px"></div>
    </div>
</body>
</html>
