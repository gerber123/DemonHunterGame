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
          href="${pageContext.request.contextPath}../resources/css/home-page.css"/>
    <link href="https://fonts.googleapis.com/css?family=Cinzel" rel="stylesheet">
</head>
<body>
    <div id="welcome">Keep secret and Dont<span style="color:red"> Kill </span>Your Friends</div>

    <%--<div class="leftbox" style="left:37%" >--%>



    <c:if test="${user.usercharacter==null}">
        <div class="box">
            <img src="${pageContext.request.contextPath}/resources/images/creation.jpg" class="avatar">
            <h1>Creating!</h1>
            <h3>Create Your Own Character and start adventure!</h3>
            <a href="${pageContext.request.contextPath}/creatingProcess/showCreatingCharacterPanel"><input type="submit" value="Creating Panel" style="margin-bottom:30px" ></a>
        </div>
    </c:if>
    <c:if test="${user.usercharacter!=null}">

        <c:if test="${user.usercharacter.characterRace.id=='1'}">
            <c:if test="${user.usercharacter.characterType.id=='1'}">
                <div class="box-human-hunter" >
                    <h1>Go To The Game!</h1>
                    <h3><span style="color:red">Character: </span>${user.usercharacter.nick_name}</h3>
                    <h3><span style="color:red">Class: </span>${user.usercharacter.characterType.name}</h3>
                    <h3><span style="color:red">Lvl: </span>${user.usercharacter.lvl}</h3>
                    <h3><span style="color:red">Race: </span>${user.usercharacter.characterRace.name}</h3>
                    <a href="${pageContext.request.contextPath}/startingPanel"><input type="submit" value="Go To The Adventure" style="margin-bottom:30px" ></a>
                </div>
            </c:if>
            <c:if test="${user.usercharacter.characterType.id=='2'}">
                <div class="box-human-mage" >
                    <h1>Go To The Game!</h1>
                    <h3><span style="color:red">Character: </span>${user.usercharacter.nick_name}</h3>
                    <h3><span style="color:red">Class: </span>${user.usercharacter.characterType.name}</h3>
                    <h3><span style="color:red">Lvl: </span>${user.usercharacter.lvl}</h3>
                    <h3><span style="color:red">Race: </span>${user.usercharacter.characterRace.name}</h3>
                    <a href="${pageContext.request.contextPath}/startingPanel"><input type="submit" value="Go To The Adventure" style="margin-bottom:30px" ></a>
                </div>
            </c:if>
            <c:if test="${user.usercharacter.characterType.id=='3'}">
                <div class="box-human-warrior" >
                    <h1>Go To The Game!</h1>
                    <h3><span style="color:red">Character: </span>${user.usercharacter.nick_name}</h3>
                    <h3><span style="color:red">Class: </span>${user.usercharacter.characterType.name}</h3>
                    <h3><span style="color:red">Lvl: </span>${user.usercharacter.lvl}</h3>
                    <h3><span style="color:red">Race: </span>${user.usercharacter.characterRace.name}</h3>
                    <a href="${pageContext.request.contextPath}/startingPanel"><input type="submit" value="Go To The Adventure" style="margin-bottom:30px" ></a>
                </div>
            </c:if>
        </c:if>
        <c:if test="${user.usercharacter.characterRace.id=='2'}">
            <c:if test="${user.usercharacter.characterType.id=='1'}">
                <div class="box-elf-hunter">
                    <h1>Go To The Game!</h1>
                    <h3><span style="color:red">Character: </span>${user.usercharacter.nick_name}</h3>
                    <h3><span style="color:red">Class: </span>${user.usercharacter.characterType.name}</h3>
                    <h3><span style="color:red">Lvl: </span>${user.usercharacter.lvl}</h3>
                    <h3><span style="color:red">Race: </span>${user.usercharacter.characterRace.name}</h3>
                    <a href="${pageContext.request.contextPath}/startingPanel"><input type="submit" value="Go To The Adventure" style="margin-bottom:30px" ></a>
                </div>
            </c:if>
            <c:if test="${user.usercharacter.characterType.id=='2'}">
                <div class="box-elf-mage">

                    <h1>Go To The Game!</h1>
                    <h3><span style="color:red">Character: </span>${user.usercharacter.nick_name}</h3>
                    <h3><span style="color:red">Class: </span>${user.usercharacter.characterType.name}</h3>
                    <h3><span style="color:red">Lvl: </span>${user.usercharacter.lvl}</h3>
                    <h3><span style="color:red">Race: </span>${user.usercharacter.characterRace.name}</h3>
                    <a href="${pageContext.request.contextPath}/startingPanel"><input type="submit" value="Go To The Adventure" style="margin-bottom:30px" ></a>
                </div>
            </c:if>
            <c:if test="${user.usercharacter.characterType.id=='3'}">
                <div class="box-elf-warrior">

                    <h1>Go To The Game!</h1>
                    <h3><span style="color:red">Character: </span>${user.usercharacter.nick_name}</h3>
                    <h3><span style="color:red">Class: </span>${user.usercharacter.characterType.name}</h3>
                    <h3><span style="color:red">Lvl: </span>${user.usercharacter.lvl}</h3>
                    <h3><span style="color:red">Race: </span>${user.usercharacter.characterRace.name}</h3>
                    <a href="${pageContext.request.contextPath}/startingPanel"><input type="submit" value="Go To The Adventure" style="margin-bottom:30px" ></a>
                </div>
            </c:if>
        </c:if>
        <c:if test="${user.usercharacter.characterRace.id=='3'}">
            <c:if test="${user.usercharacter.characterType.id=='1'}">
                <div class="box-orc-hunter">

                    <h1>Go To The Game!</h1>
                    <h3><span style="color:red">Character: </span>${user.usercharacter.nick_name}</h3>
                    <h3><span style="color:red">Class: </span>${user.usercharacter.characterType.name}</h3>
                    <h3><span style="color:red">Lvl: </span>${user.usercharacter.lvl}</h3>
                    <h3><span style="color:red">Race: </span>${user.usercharacter.characterRace.name}</h3>
                    <a href="${pageContext.request.contextPath}/startingPanel"><input type="submit" value="Go To The Adventure" style="margin-bottom:30px" ></a>
                </div>
            </c:if>
            <c:if test="${user.usercharacter.characterType.id=='2'}">
                <div class="box-orc-mage">

                    <h1>Go To The Game!</h1>
                    <h3><span style="color:red">Character: </span>${user.usercharacter.nick_name}</h3>
                    <h3><span style="color:red">Class: </span>${user.usercharacter.characterType.name}</h3>
                    <h3><span style="color:red">Lvl: </span>${user.usercharacter.lvl}</h3>
                    <h3><span style="color:red">Race: </span>${user.usercharacter.characterRace.name}</h3>
                    <a href="${pageContext.request.contextPath}/startingPanel"><input type="submit" value="Go To The Adventure" style="margin-bottom:30px" ></a>
                </div>
            </c:if>
            <c:if test="${user.usercharacter.characterType.id=='3'}">
                <div class="box-orc-warrior">

                    <h1>Go To The Game!</h1>
                    <h3><span style="color:red">Character: </span>${user.usercharacter.nick_name}</h3>
                    <h3><span style="color:red">Class: </span>${user.usercharacter.characterType.name}</h3>
                    <h3><span style="color:red">Lvl: </span>${user.usercharacter.lvl}</h3>
                    <h3><span style="color:red">Race: </span>${user.usercharacter.characterRace.name}</h3>
                    <a href="${pageContext.request.contextPath}/startingPanel"><input type="submit" value="Go To The Adventure" style="margin-bottom:30px" ></a>
                </div>
            </c:if>
        </c:if>
        <c:if test="${user.usercharacter.characterRace.id=='4'}">
            <c:if test="${user.usercharacter.characterType.id=='1'}">
                <div class="box-dwarf-hunter">

                    <h1>Go To The Game!</h1>
                    <h3><span style="color:red">Character: </span>${user.usercharacter.nick_name}</h3>
                    <h3><span style="color:red">Class: </span>${user.usercharacter.characterType.name}</h3>
                    <h3><span style="color:red">Lvl: </span>${user.usercharacter.lvl}</h3>
                    <h3><span style="color:red">Race: </span>${user.usercharacter.characterRace.name}</h3>
                    <a href="${pageContext.request.contextPath}/startingPanel"><input type="submit" value="Go To The Adventure" style="margin-bottom:30px" ></a>
                </div>
            </c:if>
            <c:if test="${user.usercharacter.characterType.id=='2'}">
                <div class="box-dwarf-mage">

                    <h1>Go To The Game!</h1>
                    <h3><span style="color:red">Character: </span>${user.usercharacter.nick_name}</h3>
                    <h3><span style="color:red">Class: </span>${user.usercharacter.characterType.name}</h3>
                    <h3><span style="color:red">Lvl: </span>${user.usercharacter.lvl}</h3>
                    <h3><span style="color:red">Race: </span>${user.usercharacter.characterRace.name}</h3>
                    <a href="${pageContext.request.contextPath}/startingPanel"><input type="submit" value="Go To The Adventure" style="margin-bottom:30px" ></a>
                </div>
            </c:if>
            <c:if test="${user.usercharacter.characterType.id=='3'}">
                <div class="box-dwarf-warrior">

                    <h1>Go To The Game!</h1>
                    <h3><span style="color:red">Character: </span>${user.usercharacter.nick_name}</h3>
                    <h3><span style="color:red">Class: </span>${user.usercharacter.characterType.name}</h3>
                    <h3><span style="color:red">Lvl: </span>${user.usercharacter.lvl}</h3>
                    <h3><span style="color:red">Race: </span>${user.usercharacter.characterRace.name}</h3>
                    <a href="${pageContext.request.contextPath}/startingPanel"><input type="submit" value="Go To The Adventure" style="margin-bottom:30px" ></a>
                </div>
            </c:if>
        </c:if>
    </c:if>

</body>
</html>
